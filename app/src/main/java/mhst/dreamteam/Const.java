package mhst.dreamteam;

/**
 * Contains global constants
 * @author MinhNN
 */
public class Const {

    // RETURN CODE
    public static final int RETURNCODE_SUCCESS = 1;
    public static final int RETURNCODE_FAILURE = -1;

    // SESSION
    public static final int SESSION_LOGGED_IN = 1;
    public static final int SESSION_LOGGED_OUT = -1;

    // REQUEST CODE
    public static final int REQUESTCODE_NORMAL = 0;
    public static final int REQUESTCODE_REQUIRE_LOGIN = 1;

    // ERROR CONSTANTS
    public static final int ERROR_UNKNOWN_ERROR = -1;
    public static final int ERROR_WRONG_USER_PASS = 4;
    public static final int ERROR_CONNECTION_ERROR = 64;

}
