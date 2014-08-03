package mhst.dreamteam.SessionMng;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.LargeTest;

import junit.framework.Assert;

import java.util.concurrent.ExecutionException;

import mhst.dreamteam.Const;
import mhst.dreamteam.GlobalConfig;

/**
 * Test logout action:<br />
 * +Test case 1: Connection fails<br />
 * +Test case 2: Successful<br />
 */
public class LogOutTest extends AndroidTestCase {

    public LogOutTest() {
        super();
    }

    @LargeTest
    public void testLogOutAction_ConnectionFails() {
        // Set a wrong server address to connect
        GlobalConfig.Server = "http://1234567890";

        // Begin test
        try {
            int res = new Logout().execute().get();
            Assert.assertEquals("This should be a connection error", Const.ERROR_CONNECTION_ERROR, res);
        } catch (InterruptedException e) {
            Assert.fail("ConnectionFails() method: " + e.getMessage());
        } catch (ExecutionException e) {
            Assert.fail("ConnectionFails() method: " + e.getMessage());
        }
    }

    @LargeTest
    public void testLogOutAction_Success() {
        // Begin test
        try {
            // Login first
            // Server: http://web.demo.icinga.org
            // Username: guest
            // Password: guestuser
            new Login().execute("http://web.demo.icinga.org", "guest", "guestuser");
            // And then test logout
            int res = new Logout().execute().get();
            assertEquals("Logged out failed", Const.SESSION_LOGGED_OUT, res);
        } catch (InterruptedException e) {
            Assert.fail("Success() method: " + e.getMessage());
        } catch (ExecutionException e) {
            Assert.fail("Success() method: " + e.getMessage());
        }
    }
}