package mhst.dreamteam.IcingaClient.SessionMng;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.LargeTest;

import mhst.dreamteam.IcingaClient.GlobalConst;
import mhst.dreamteam.IcingaClient.Interface.OnCompleteListener;

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
        Session.getInstance().doLogin(getContext(), new OnCompleteListener() {
            @Override
            public void onComplete(Object obj, String sender) {
                assertEquals("Login failed", true, Session.getInstance().isLogin());
                // And then test logout
                int res = Session.getInstance().doLogout();
                assertEquals("Logout failed", GlobalConst.SESSION_LOGGED_OUT, res);
            }
        }, "web.demo.icinga.org", "guest", "guestuser");
    }
}