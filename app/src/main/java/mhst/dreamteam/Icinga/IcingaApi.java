package mhst.dreamteam.Icinga;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Implement Icinga REST API
 * @author MinhNN
 */
public class IcingaApi {
    public static List<Map<String, Object>> get(String... params) {
        // Check if params is null or has no element
        if (params == null || params.length == 0) return null;

        // Execute api request
        try {
            String response = new IcingaExecutor().execute(params).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
