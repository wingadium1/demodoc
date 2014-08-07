package mhst.dreamteam.SessionMng;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import mhst.dreamteam.ApplicationContext;
import mhst.dreamteam.GlobalConst;
import mhst.dreamteam.Controller.NetController;
import mhst.dreamteam.GlobalConfig;

/**
 * Logs out from server
 * @author MinhNN
 */
public class Logout extends AsyncTask<Void, Void, Integer> {

    @Override
    protected Integer doInBackground(Void... HttpUri) {
        // TODO Auto-generated method stub
        // Get current session instance
        Session currentSession = Session.getInstance();

        // Parse logout URL
        String sLogoutUrl = currentSession.getWorkingServer() + GlobalConfig.logoutUri; // Logout Url

        // Properties for request
        Map<String, String> prop = new HashMap<String, String>();
        if (currentSession.getCookie() !=  null) {
            prop.put("Cookie", currentSession.getCookie());
        }

        // Send request and get response data
        Map<String, Object> mResponse = NetController.sendRequest("GET", sLogoutUrl, "", prop);

        // Check if there is any error
        if (mResponse == null) return GlobalConst.ERROR_UNKNOWN_ERROR; // No response data
        if (mResponse.containsKey("Error")) return (Integer) mResponse.get("Error"); // Check if any error was detected
        int sttCode;
        if (mResponse.containsKey("Code")) {
            sttCode = (Integer) mResponse.get("Code"); // Get response code
        } else {
            return GlobalConst.ERROR_UNKNOWN_ERROR; // No response code
        }
        Log.i("Log out", "Status code = " + sttCode);

        // Check logout condition
        if (sttCode == HttpStatus.SC_MOVED_TEMPORARILY) { // 302
            // Logout successfully
            Log.i("Log out", "Logged out");
            return GlobalConst.SESSION_LOGGED_OUT;
        } else if (sttCode == HttpStatus.SC_FORBIDDEN) { // 403
            // Not logged in yet
            Log.i("Log out", "Not logged in yet");
            return GlobalConst.SESSION_LOGGED_OUT;
        }
        Log.e("Log out", "Not yet");
        return GlobalConst.SESSION_LOGGED_IN;
    }
}
