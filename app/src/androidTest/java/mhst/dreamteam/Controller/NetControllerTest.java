package mhst.dreamteam.Controller;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.LargeTest;

import junit.framework.Assert;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import mhst.dreamteam.Const;

/**
 * Test send request action:<br />
 * +Test case 1: Unknown host<br />
 * +Test case 2: Connect successful<br />
 * @author MinhNN
 */
public class NetControllerTest extends AndroidTestCase {

    public NetControllerTest() {
        super();
    }

    @LargeTest
    public void testNetController_UnknownHost() {
        // Unknown host to connect
        String sURL = "http://1234567890";

        // Begin test
        Map<String, Object> response = NetController.sendRequest("POST", sURL, "", null);
        // Check if any error was detected
        assertEquals("No error detected", true, response.containsKey("Error"));
        // Get error code
        int res = (Integer) response.get("Error");
        // Check if it is UNKNOWN HOST ERROR or not
        Assert.assertEquals("This should be unknown host error", Const.ERROR_UNKNOWN_HOST, res);
    }

    @LargeTest
    public void testNetController_Success() throws UnsupportedEncodingException {
        // Server to connect
        String sURL = "http://web.demo.icinga.org/icinga-web/modules/appkit/login/json";
        String sRequest = "dologin=1&username=guest&password=123@123a";

        // Begin test
        Map<String, Object> response = NetController.sendRequest("POST", sURL, sRequest, null);
        // Check if there is any response code
        assertEquals("No response code", true, response.containsKey("Code"));
    }

}
