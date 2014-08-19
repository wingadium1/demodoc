package mhst.dreamteam.Icinga;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import mhst.dreamteam.Json.JsonHelper;

/**
 * Implement Icinga REST API. This class uses to get response data from IcingaCronks and convert
 * to list of icinga target.
 *
 * @author NamTD
 * @see mhst.dreamteam.Icinga.IcingaExecutor
 * @see mhst.dreamteam.Icinga.IcingaParam
 */
public class IcingaJson {
    /**
     * Returns list of target requested. This method convert the string reponse from server to
     * a list of map key and value that defines the target
     *
     * @param params the string parameter to send to request to server
     * @return list of icinga target
     */
    public static List<Map<String, Object>> get(String... params) {
        // Check if params is null or has no element
        if (params == null) return null;
        for (int i = 0; i < params.length; i++) {
            if (params[i].isEmpty()) return null;
        }

        // Execute api request
        try {
            // Get response from server
            String response = new IcingaCronks().execute(params[0]).get();
            JSONObject obj = new JSONObject(response);
            JSONArray listMachine = obj.getJSONArray("rows");
            List<Map<String, Object>> result = new List<HashMap()>;
            for(int i =0;i<listMachine.length();i++){
                result.add(new JsonHelper().toMap(listMachine.getJSONObject(i)));
            }
            return result;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
