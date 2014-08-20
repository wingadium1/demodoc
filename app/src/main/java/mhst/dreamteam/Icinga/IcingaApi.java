package mhst.dreamteam.Icinga;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Implement Icinga REST API. This class uses to get response data from IcingaExecutor and convert
 * to list of icinga target.
 * @author MinhNN
 * @see mhst.dreamteam.Icinga.IcingaExecutor
 * @see mhst.dreamteam.Icinga.IcingaParam
 */
public class IcingaApi {
    /**
     * Returns list of target requested. This method convert the string reponse from server to
     * a list of map key and value that defines the target
     * @param params the string parameter to send to request to server
     * @return list of icinga target
     */
    public static ArrayList<Map<String, Object>> get(String params) {
        // Check if params is null or has no element
        if (params == null || params.isEmpty()) return null;

        // Execute api request
        try {
            // Get response from server
            String response = new IcingaExecutor().execute(params).get();
            // Becareful, check null return data before doing anything
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
