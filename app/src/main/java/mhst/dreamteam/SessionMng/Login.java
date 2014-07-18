package mhst.dreamteam.SessionMng;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import mhst.dreamteam.Const;
import mhst.dreamteam.GlobalConfig;
import mhst.dreamteam.R;

/**
 * Executes login/logout action...
 * @author MinhNN
 */
public class Login extends AsyncTask<String, Void, Integer>{
    HttpClient client; // Client to connect to server

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Create new client
        client = new DefaultHttpClient();
    }

    @Override
    protected Integer doInBackground(String... loginInfo) {
        // Parse login url
        loginInfo[0] += GlobalConfig.loginUri;
        try {
            // Create new post request
            HttpPost postRequest = new HttpPost(loginInfo[0]);

            // Set header for post request
            postRequest.setHeader("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");

            // Add entity to form request
            List<NameValuePair> valuePairs = new ArrayList<NameValuePair>(2);
            valuePairs.add(new BasicNameValuePair("dologin", "1"));
            valuePairs.add(new BasicNameValuePair("username", loginInfo[1]));
            valuePairs.add(new BasicNameValuePair("password", loginInfo[2]));
            postRequest.setEntity(new UrlEncodedFormEntity(valuePairs));

            // Execute the request
            HttpResponse response = client.execute(postRequest);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 200
                // Login successfully
                GlobalConfig.Server = loginInfo[0]; // Set working server
                return Const.RETURNCODE_SUCCESS;
            } else if (response.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY) { // 302
                // Wrong username or password
                return Const.ERROR_WRONG_USER_PASS;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // Connection terminated, login failed
            return Const.ERROR_CONNECTION_ERROR;
        }
        return Const.ERROR_UNKNOWN_ERROR;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        Log.i("Login Task", "Retrieving data...");
    }

    @Override
    protected void onPostExecute(Integer aInt) {
        super.onPostExecute(aInt);

    }
}
