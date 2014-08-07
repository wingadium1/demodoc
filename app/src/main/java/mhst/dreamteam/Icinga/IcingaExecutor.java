package mhst.dreamteam.Icinga;

import android.os.AsyncTask;

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
 * Execute Icinga Api request
 * @author MinhNN
 */
public class IcingaExecutor extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {
        // Split target and filter
        String sTarget = params[0];
        String[] aColumn = Arrays.copyOfRange(params, 1, params.length);

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

        // Parse api uri
        // Uri = http://server_address/Api_Uri/target/columns[column_filters]/authkey=something/json
        String Uri = AppSession.getWorkingServer() + GlobalConfig.apiUri + "/"
                + sTarget + "/columns" + parseColumn(aColumn)
                + "/" + GlobalConfig.returnType;

        // Send request and get response
        String result;
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

    /**
     * Parses list of columns into string
     * @param aColumn list of column
     * @return string to use in request
     */
    private static String parseColumn(String... aColumn) {
        if (aColumn == null || aColumn.length == 0) return "";

        String sColumns = "[";

        for (String s : aColumn) {
            sColumns += s + "|";
        }

        sColumns = sColumns.substring(0, sColumns.length()-1) + "]";

        try {
            sColumns = URLEncoder.encode(sColumns, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }

        return sColumns;
    }
}
