package mhst.dreamteam.SessionMng;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.MediumTest;

import junit.framework.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import mhst.dreamteam.Const;

/**
 * Test login action:<br />
 * +Test case 1: Connection fails<br />
 * +Test case 2: Wrong username or password<br />
 * +Test case 3: Successful<br />
 */
public class LogInTest extends AndroidTestCase {
    private Map<String, Map<String, String>> testCase = null; // Map<"Case_Name", Map<"Server/User/Pass", value>>

    public LogInTest() {
        super();
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        testCase = new HashMap<String, Map<String, String>>();

        // Successful login dataset
        Map<String, String> child_success = new HashMap<String, String>();
        child_success.put("Server", "http://web.demo.icinga.org");
        child_success.put("User", "guest");
        child_success.put("Pass", "guestuser");

        // Wrong user/pass login dataset (User == non_root)
        Map<String, String> child_wrong_user_pass = new HashMap<String, String>();
        child_wrong_user_pass.put("Server", "http://web.demo.icinga.org");
        child_wrong_user_pass.put("User", "non_root");
        child_wrong_user_pass.put("Pass", "123@123a");

        // Connection fails login dataset
        Map<String, String> child_connection_fail = new HashMap<String, String>();
        child_connection_fail.put("Server", "http://123456789");
        child_connection_fail.put("User", "root");
        child_connection_fail.put("Pass", "123@123a");

        testCase.put("SuccessCase", child_success);
        testCase.put("WrongUserCase", child_wrong_user_pass);
        testCase.put("ConnectFailCase", child_connection_fail);
    }

    @MediumTest
    public void testPreconditions() {
        assertNotNull("Null test case", testCase);
        assertEquals("Empty test case", false, testCase.isEmpty());
        assertEquals("Lack of test case", 3, testCase.size());
    }

    @LargeTest
    public void testLogInAction_ConnectionFails() {
        // Get test case dataset
        Map<String, String> test = testCase.get("ConnectFailCase");
        String sServer = test.get("Server");
        String sUser = test.get("User");
        String sPass = test.get("Pass");

        // Begin test
        try {
            int res = new Login().execute(sServer, sUser, sPass).get();
            Assert.assertEquals("This should be a connection error", Const.ERROR_CONNECTION_ERROR, res);
        } catch (InterruptedException e) {
            Assert.fail("ConnectionFails() method: " + e.getMessage());
        } catch (ExecutionException e) {
            Assert.fail("ConnectionFails() method: " + e.getMessage());
        }
    }

    @LargeTest
    public void testLogInAction_WrongUserPass() {
        // Get test case dataset
        Map<String, String> test = testCase.get("WrongUserCase");
        String sServer = test.get("Server");
        String sUser = test.get("User");
        String sPass = test.get("Pass");

        // Begin test
        try {
            int res = new Login().execute(sServer, sUser, sPass).get();
            assertEquals("User or pass should be wrong.", Const.ERROR_WRONG_USER_PASS, res);
        } catch (InterruptedException e) {
            Assert.fail("WrongUserPass() method: " + e.getMessage());
        } catch (ExecutionException e) {
            Assert.fail("WrongUserPass() method: " + e.getMessage());
        }
    }

    @LargeTest
    public void testLogInAction_Success() {
        // Get test case dataset
        Map<String, String> test = testCase.get("SuccessCase");
        String sServer = test.get("Server");
        String sUser = test.get("User");
        String sPass = test.get("Pass");

        // Begin test
        try {
            int res = new Login().execute(sServer, sUser, sPass).get();
            assertEquals("Logged in failed", Const.SESSION_LOGGED_IN, res);
        } catch (InterruptedException e) {
            Assert.fail("Success() method: " + e.getMessage());
        } catch (ExecutionException e) {
            Assert.fail("Success() method: " + e.getMessage());
        }
    }
}