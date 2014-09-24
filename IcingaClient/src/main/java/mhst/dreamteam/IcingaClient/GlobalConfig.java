package mhst.dreamteam.IcingaClient;

/**
 * Contains every configuration variables such as server address, resources, ...
 *
 * @author MinhNN
 */
public class GlobalConfig {
    public static String prefLoginInfo = "LoginInfo"; // File name to save Login Info

    public static String returnType = "xml"; // Return type from Icinga API
    public static String apiUri = "/icinga-web/web/api"; // URI to access the API
    public static String cronksUri = "/icinga-web/modules/cronks/viewproc/%s/json"; // URI to access the API

    public static String loginUri = "/icinga-web/modules/appkit/login/json"; // Login URI
    public static String logoutUri = "/icinga-web/modules/appkit/logout?logout=1"; // Logout URI
}
