package mhst.dreamteam.Controller;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mhst.dreamteam.GlobalConst;

/**
 * Network controller<br />
 * Uses to control network communication such as send request to server and get response data, etc.
 * @author MinhNN
 */
public class NetController {
    /**
     * Uses to send request to a specific server via POST or GET method.
     * @param sMethod "POST" - using POST method or "GET" - using GET method
     * @param sURL Target URL to send request
     * @param sParam (POST method only) data to send to server
     * @return a hashmap of response data<br />
     *         "Code" - response code<br />
     *         "Data" - data response from server (eg. json)<br />
     *         "Error" - any error detected while communicating with server
     */
    public static Map<String, Object> sendRequest(String sMethod, String sURL, String sParam, Map<String, String> mProperty) {
        HttpURLConnection connection = null;
        Map<String, Object> result = new HashMap<String, Object>(); // Map data response from server
        try {
            // Create new URL
            URL HttpUrl = new URL(sURL);
            // Open connection for that URL
            connection = (HttpURLConnection) HttpUrl.openConnection();
            // Set properties for this connection
            connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
            // if mProperty != null, set list of property in mProperty
            if (mProperty != null) {
                String[] keyList = mProperty.keySet().toArray(new String[mProperty.size()]); // List of property name
                for (String keyName : keyList) {
                    connection.setRequestProperty(keyName, mProperty.get(keyName));
                }
            }
            connection.setDoInput(true);
            // Enable send request body (POST Method if true; otherwise, GET Method)
            connection.setDoOutput(sMethod.equalsIgnoreCase("POST"));

            if (sMethod.equalsIgnoreCase("POST")) {
                // Send request
                DataOutputStream post = new DataOutputStream(connection.getOutputStream());
                post.writeBytes(sParam);
                post.flush();
                post.close();
            }

            // Get response
            int sttCode = connection.getResponseCode(); // Get status code
            result.put("Code", sttCode);
            Log.i("NetController", "Response code = " + sttCode);

            // Get headers
            Map<String, Object> headers = new HashMap<String, Object>();
            String sHeader;
            int i = 1;
            while ((sHeader = connection.getHeaderFieldKey(i)) != null) {
                if (headers.containsKey(sHeader)) {
                    ArrayList<String> listValue = new ArrayList<String>();
                    listValue.add((String) headers.get(sHeader));
                    listValue.add(connection.getHeaderField(i));
                    headers.put(sHeader, listValue);
                } else {
                    headers.put(sHeader, connection.getHeaderField(i));
                }
                i++;
            }
            result.put("Headers", headers);

            // Get response data
            if (sttCode != 200) { // if status code != HTTP 200 OK, read response data from error stream
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                String sErrorBuffer;
                StringBuilder sError = new StringBuilder();
                while ((sErrorBuffer = errorReader.readLine()) != null) {
                    sError.append(sErrorBuffer);
                    sError.append("\r\n");
                }
                errorReader.close();

                // Put data response message to map
                Log.e("NetController", sError.toString());
                result.put("Data", sError.toString());
            } else { // if status code is HTTP 200 OK, read data response from input stream
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String sBuffer;
                StringBuilder sResponse = new StringBuilder();
                while ((sBuffer = responseReader.readLine()) != null) {
                    sResponse.append(sBuffer);
                    sResponse.append("\r\n");
                }
                responseReader.close();

                // Put data response message to map
                Log.i("NetController", sResponse.toString());
                result.put("Data", sResponse.toString());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
            result.put("Error", GlobalConst.ERROR_UNKNOWN_HOST);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            result.put("Error", GlobalConst.ERROR_UNKNOWN_ERROR);
        } catch (IOException e) {
            e.printStackTrace();
            result.put("Error", GlobalConst.ERROR_CONNECTION_ERROR);
        } finally {
            if (connection != null) connection.disconnect();
        }
        return result;
    }

}
