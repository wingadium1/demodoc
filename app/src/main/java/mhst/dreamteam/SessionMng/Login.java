package mhst.dreamteam.SessionMng;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mhst.dreamteam.Const;
import mhst.dreamteam.Controller.NetController;
import mhst.dreamteam.GlobalConfig;
import mhst.dreamteam.Misc.CookieMng;

/**
 * Executes login/logout action...
 * @author MinhNN
 */
public class Login extends AsyncTask<String, Void, Map<String, Object>>{

    @Override
    @SuppressWarnings("unchecked")
    protected Map<String, Object> doInBackground(String... loginInfo) {
        // Parse login url
        loginInfo[0] += GlobalConfig.loginUri;

        // Return data
        Map<String, Object> mResult = new HashMap<String, Object>();

        try {
            // Parse login information to send to server
            String sRequest = "dologin=1" +
                    "&username=" + URLEncoder.encode(loginInfo[1], "utf-8") +
                    "&password=" + URLEncoder.encode(loginInfo[2], "utf-8");

            // Properties for request
            Map<String, String> prop = new HashMap<String, String>();
            if (Session.getCookie() !=  null) {
                prop.put("Cookie", Session.getCookie());
            }

            // Send request and get response data
            Map<String, Object> mResponse = NetController.sendRequest("POST", loginInfo[0], sRequest, prop);

            // Check if there is any error
            if (mResponse == null) {
                mResult.put("Code", Const.ERROR_UNKNOWN_ERROR);
                return mResult; // No response data
            }
            if (mResponse.containsKey("Error")) {
                mResult.put("Code", mResponse.get("Error"));
                return mResult; // Check if any error was detected
            }
            int sttCode;
            if (mResponse.containsKey("Code")) {
                sttCode = (Integer) mResponse.get("Code"); // Get response code
            } else {
                mResult.put("Code", Const.ERROR_UNKNOWN_ERROR);
                return mResult; // No response code
            }
            Log.i("Log in", "Status code = " + sttCode);

            // Check login condition
            if (sttCode == HttpStatus.SC_OK) { // 200
                // This must be the necessary condition to login successful (i.e. response code == 200)
                if (!mResponse.containsKey("Data")) {
                    mResult.put("Code", Const.ERROR_NO_RESPONSE_DATA);
                    return mResult; // No response message
                }
                // Get response data to check the sufficient condition
                JSONObject json = new JSONObject((String) mResponse.get("Data"));
                boolean success = json.getBoolean("success");
                // success == true <=> login successfully; otherwise, login failed
                if (!success) { // Something wrong, login failed
                    JSONObject err = json.getJSONObject("errors");
                    if (err.has("username")) {
                        mResult.put("Code", Const.ERROR_WRONG_USER_PASS);
                        return mResult;
                    } else {
                        mResult.put("Code", Const.ERROR_UNKNOWN_ERROR);
                        return mResult;
                    }
                }
                // Login successfully
                // Find cookies
                Map<String, String> headers = (Map<String, String>) mResponse.get("Headers");
                if (headers.containsKey("Set-Cookie")) {
                    Object obj = headers.get("Set-Cookie");
                    // Parse and build cookie string, make sure no duplicate field
                    if (obj != null) {
                        if (obj instanceof ArrayList) { // Always fails??? No I don't think so
                            String setCookie = "";
                            ArrayList<String> cookie = (ArrayList<String>) obj;
                            for (String field : cookie) {
                                setCookie += field + ";";
                            }
                            Map<String, String> cookieList = CookieMng.parse(setCookie);
                            cookieList.remove("path");
                            setCookie = CookieMng.build(cookieList);
                            mResult.put("Cookie", setCookie);
                        } else {
                            mResult.put("Cookie", headers.get("Set-Cookie"));
                        }
                    }
                }
                GlobalConfig.Server = loginInfo[0]; // Set working server
                mResult.put("Code", Const.SESSION_LOGGED_IN);
                return mResult;
            } else { // Error detected
                if (!mResponse.containsKey("Data")) {
                    mResult.put("Code", Const.ERROR_NO_RESPONSE_DATA);
                    return mResult; // No response data
                }
                // Get response data to find out the reason
                JSONObject json = new JSONObject((String) mResponse.get("Data"));
                boolean success = json.getBoolean("success");
                if (!success) { // Obviously success == false
                    JSONObject err = json.getJSONObject("errors");
                    if (err.has("username")) {
                        mResult.put("Code", Const.ERROR_WRONG_USER_PASS);
                        return mResult; // Wrong username or password
                    } else {
                        mResult.put("Code", Const.ERROR_UNKNOWN_ERROR);
                        return mResult; // Unknown error
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        mResult.put("Code", Const.ERROR_UNKNOWN_ERROR);
        return mResult;
    }

}
