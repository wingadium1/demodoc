package mhst.dreamteam.Icinga;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpStatus;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import mhst.dreamteam.Controller.NetController;
import mhst.dreamteam.GlobalConfig;
import mhst.dreamteam.SessionMng.Session;

/**
 * Execute Icinga Api request. This class uses to send request to server and get raw response String.
 * Uses IcingaApi to parse the response data.
 * @author MinhNN
 * @see mhst.dreamteam.Icinga.IcingaApi
 */
public class IcingaExecutor extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {
        // Get current application session
        Session AppSession = Session.getInstance();

        // Check if user is logged in or if session has cookie
        if (!AppSession.isLogin()) return null;
        if (AppSession.getCookie() == null) return null;

        // Properties for request
        Map<String, String> prop = new HashMap<String, String>();
        if (AppSession.getCookie() !=  null) {
            prop.put("Cookie", AppSession.getCookie());
        }

        // Parse api uri (for further use)
        String Uri = AppSession.getWorkingServer() + GlobalConfig.apiUri + params[0];

        // Send request and get response
        String result;
        Log.i("Icinga Executor", Uri);
        Map<String, Object> response = NetController.sendRequest("GET", Uri, null, prop);
        if (response.containsKey("Code")) {
            if (((Integer) response.get("Code")) == HttpStatus.SC_OK) {
                if (response.containsKey("Data")) {
                    result = (String) response.get("Data");
                    if (result != null) return result;
                }
            }
        }
        return null;
    }
}
