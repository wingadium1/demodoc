package mhst.dreamteam.Icinga;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

import mhst.dreamteam.GlobalConfig;
import mhst.dreamteam.Interface.OnCompleteListener;
import mhst.dreamteam.Json.JsonHelper;

/**
 * Implement Icinga REST API. This class uses to get response data from IcingaExecutor and convert
 * to list of icinga target.
 *
 * @author MinhNN
 * @see mhst.dreamteam.Icinga.IcingaExecutor
 * @see mhst.dreamteam.Icinga.IcingaParam
 */
public class IcingaApi {

    // Template
    public static final String TEMPLATE_EXAMPLE_HOST = "example-host-template";
    public static final String TEMPLATE_ICINGA_INSTANCE = "icinga-instance-template";
    public static final String TEMPLATE_PROBLEMS_ICINGA_ALL_HOST = "icinga-all-host-problems";
    public static final String TEMPLATE_ICINGA_LOG = "icinga-log-template";
    public static final String TEMPLATE_ICINGA_ALL_PROBLEMS = "icinga-all-problems-template";
    public static final String TEMPLATE_ICINGA_NOTIFICATION = "icinga-notification-template";
    public static final String TEMPLATE_PROBLEMS_ICINGA_ALL_SERVICE = "icinga-all-service-problems";
    public static final String TEMPLATE_ICINGA_OPEN_PROBLEMS = "icinga-open-problems-template";
    public static final String TEMPLATE_ICINGA_DOWNTIME_HISTORY = "icinga-downtime-history-template";
    public static final String TEMPLATE_ICINGA_SERVICEGROUP_SUMMARY = "icinga-servicegroup-summary-template";
    public static final String TEMPLATE_ICINGA_DOWNTIME = "icinga-downtime-template";
    public static final String TEMPLATE_ICINGA_SERVICE_HISTORY = "icinga-service-history-template";
    public static final String TEMPLATE_ICINGA_HOSTGROUP_SUMMARY = "icinga-hostgroup-summary-template";
    public static final String TEMPLATE_ICINGA_SERVICE = "icinga-service-template";
    public static final String TEMPLATE_ICINGA_HOST_HISTORY = "icinga-host-history-template";
    public static final String TEMPLATE_PROBLEMS_ICINGA_UNHANDLED_HOST = "icinga-unhandled-host-problems";
    public static final String TEMPLATE_ICINGA_HOST = "icinga-host-template";
    public static final String TEMPLATE_PROBLEMS_ICINGA_UNHANDLED_SERVICE = "icinga-unhandled-service-problems";

    /**
     * Returns list of target requested. This method convert the string reponse from server to
     * a list of map key and value that defines the target
     *
     * @param context parent activity
     * @param listener listener for task completion
     * @param params the string parameter to send to request to server
     */
    @SuppressWarnings("unchecked")
    public static void get(Context context, OnCompleteListener listener, String params) {
        // Check if params is null or has no element
        if (params == null || params.isEmpty()) return;
        final OnCompleteListener _listener = listener;

        // Execute api request
        // Listen for completion to get response from server
        OnCompleteListener listener_param = new OnCompleteListener() {
            @Override
            public void onComplete(Object obj, String sender) {
                if (obj != null) {
                    String result = (String) obj;
                    try {
                        JSONObject jsonObj = new JSONObject(result);
                        JSONArray listMachine = jsonObj.getJSONArray("result");
                        ArrayList<Map<String, Object>> list = JsonHelper.toArrayList(listMachine);
                        _listener.onComplete(list, "IcingaGet");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    _listener.onComplete(null, "IcingaGet");
                }
            }
        };
        new IcingaExecutor(context, listener_param).execute(GlobalConfig.apiUri + params);
    }

    @SuppressWarnings("unchecked")
    public static void cronks(Context context, OnCompleteListener listener, String params) {
        // Check if params is null or has no element
        if (params == null || params.isEmpty()) return;
        final OnCompleteListener _listener = listener;

        // Execute api request
        // Listen for completion to get response from server
        OnCompleteListener listener_param = new OnCompleteListener() {
            @Override
            public void onComplete(Object obj, String sender) {
                if (obj != null) {
                    String result = (String) obj;
                    try {
                        JSONObject jsonObj = new JSONObject(result);
                        JSONArray listMachine = jsonObj.getJSONArray("rows");
                        ArrayList<Map<String, Object>> list = JsonHelper.toArrayList(listMachine);
                        _listener.onComplete(list, "IcingaCronks");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    _listener.onComplete(null, "IcingaCronks");
                }
            }
        };
        new IcingaExecutor(context, listener_param).execute(GlobalConfig.cronksUri.replace("%s", params));
    }
}
