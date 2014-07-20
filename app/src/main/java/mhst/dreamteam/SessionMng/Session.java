package mhst.dreamteam.SessionMng;

import android.util.Log;

import java.security.InvalidParameterException;
import java.util.concurrent.ExecutionException;

import mhst.dreamteam.Const;

/**
 * Manage session
 * @author MinhNN
 */
public class Session {
    private static int loginResult = Const.ERROR_UNKNOWN_ERROR;

    /**
     * Checks if user logged into system or not.
     * @return  true - user logged in<br />
     *          false - user has not logged in yet
     */
    public static boolean isLogin() {
        return (loginResult == Const.RETURNCODE_SUCCESS);
    }

    /**
     * Logs user into server
     * @param loginInfo                     loginInfo[0] = Server Address<br />
     * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; loginInfo[1] = Username<br />
     * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; loginInfo[2] = Password<br />
     * @throws InvalidParameterException
     */
    public static int doLogin(String... loginInfo)
            throws InvalidParameterException {
        // Check input data
        if (loginInfo.length == 0) {
            throw new InvalidParameterException();
        } else if (loginInfo.length != 3) {
            throw new InvalidParameterException();
        }
        // Check if input string is null or empty
        for (String str : loginInfo) {
            if (str == null || str.isEmpty()) {
                throw new InvalidParameterException();
            }
        }

        // Parse server address
        loginInfo[0] = "http://" + loginInfo[0];
        // Do log in and return result code
        try {
            loginResult = new Login().execute(loginInfo).get();
            Log.i("Session login", "Login result = " + loginResult);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return loginResult;
    }

    public static void doLogout() {

    }
}
