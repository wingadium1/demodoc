package mhst.dreamteam.IcingaClient;

/**
 * Contains global constants
 *
 * @author MinhNN
 */
public class GlobalConst {

    /////////////////////////////////////// RETURN CODE ////////////////////////////////////////////
    public static final int RETURNCODE_SUCCESS = 1;
    public static final int RETURNCODE_FAILURE = -1;

    ///////////////////////////////////////// SESSION //////////////////////////////////////////////
    public static final int SESSION_LOGGED_IN = 1;
    public static final int SESSION_LOGGED_OUT = 0;

    ////////////////////////////////////// REQUEST CODE ////////////////////////////////////////////
    public static final int REQUESTCODE_NORMAL = 0;
    public static final int REQUESTCODE_REQUIRE_LOGIN = 1;
    public static final int REQUESTCODE_NOTIFICATION_UPDATE = 128;
    public static final int REQUESTCODE_NOTIFICATION_HOST_UPDATE = 32;
    public static final int REQUESTCODE_NOTIFICATION_SERVICE_UPDATE = 64;

    //////////////////////////////////// ERROR CONSTANTS ///////////////////////////////////////////
    public static final int ERROR_UNKNOWN_ERROR = -1;
    public static final int ERROR_WRONG_USER_PASS = 4;
    public static final int ERROR_CONNECTION_ERROR = 64;
    public static final int ERROR_UNKNOWN_HOST = 128;
    public static final int ERROR_NO_RESPONSE_DATA = 1024;

}
