package mhst.dreamteam.IcingaClient.Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Cookie Manager
 *
 * @author MinhNN
 */
public class CookieMng {
    /**
     * Parses cookie string into list of field and value
     *
     * @param cookie cookie string to pass
     * @return a map contains list of field and value
     */
    public static Map<String, String> parse(String cookie) {
        // Check if cookie is null or empty or not contain "="
        if (cookie == null || cookie.isEmpty() || !cookie.contains("=")) {
            return null;
        }

        // Return data
        Map<String, String> result = new HashMap<String, String>();
        ArrayList<String> listCookie = new ArrayList<String>();

        // Check if cookie contains 1 or more field
        if (cookie.contains(";")) {
            // Split to list of field
            String[] list = cookie.split(";");
            for (String s : list) {
                if (!s.trim().isEmpty()) {
                    listCookie.add(s.trim());
                }
            }
        } else { // Just have 1 field
            listCookie.add(cookie.trim());
        }

        // Begin to parse
        for (String aCookie : listCookie) {
            // A valid pair of field and value must have "="
            if (aCookie.contains("=")) {
                String field = aCookie.substring(0, aCookie.indexOf("=")).trim();
                String value = aCookie.substring(aCookie.indexOf("=") + 1).trim();
                if(!field.isEmpty())
                result.put(field, value);
            }
        }
        return result;
    }

    /**
     * Builds cookie string from a list of field
     *
     * @param cookie list of field to build
     * @return a string of cookie
     */
    public static String build(Map<String, String> cookie) {
        // if map contains nothing, return null
        if (cookie.size() == 0) return null;
        // String result
        String result = "";
        // Get list of field
        String[] aField = cookie.keySet().toArray(new String[cookie.size()]);
        // Append field and value to result
        for (String field : aField) {
            if(!field.isEmpty()) {
                result += removeSpecial(field) + "=" + removeSpecial(cookie.get(field)) + ";";
            }
        }
        return result;
    }

    /**
     * To remove special character equal sign = and semicolon ; at value and value
     */
    public static String removeSpecial(String field){
        return field.trim().replace(";", "").replace("=","");
    }
}
