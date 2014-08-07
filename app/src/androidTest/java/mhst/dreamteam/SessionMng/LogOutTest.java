package mhst.dreamteam.SessionMng;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.LargeTest;

import mhst.dreamteam.GlobalConst;

/**
 * Test logout action:<br />
 * +Test case 1: Successful<br />
 * @author MinhNN
 */
public class LogOutTest extends AndroidTestCase {

    public LogOutTest() {
        super();
    }

    @LargeTest
    public void testLogOutAction_Success() {
        // Begin test
        // Login first
        // Server: http://web.demo.icinga.org
        // Username: guest
        // Password: guestuser
        Session.getInstance().doLogin("web.demo.icinga.org", "guest", "guestuser");
        assertEquals("Login failed", true, Session.getInstance().isLogin());
        // And then test logout
        int res = Session.getInstance().doLogout();
        assertEquals("Logout failed", GlobalConst.SESSION_LOGGED_OUT, res);
    }
}