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
 * @author MinhNN
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
            Assert.assertEquals("This should be an unknown error", Const.ERROR_UNKNOWN_HOST, res);
        } catch (InterruptedException e) {
            Assert.fail("ConnectionFails() method: " + e.getMessage());
        } catch (ExecutionException e) {
            Assert.fail("ConnectionFails() method: " + e.getMessage());
        }
    }

    @LargeTest
    public void testLogOutAction_Success() {
        // Begin test
        // Login first
        // Server: http://web.demo.icinga.org
        // Username: guest
        // Password: guestuser
        Session.doLogin("web.demo.icinga.org", "guest", "guestuser");
        assertEquals("Login failed", true, Session.isLogin());
        // And then test logout
        int res = Session.doLogout();
        assertEquals("Logout failed", Const.SESSION_LOGGED_OUT, res);
    }
}