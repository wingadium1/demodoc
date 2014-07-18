package mhst.dreamteam;

import android.content.Context;

/**
 * Contains every configuration variables such as server address, resources, ...
 * @author MinhNN
 */
public class GlobalConfig {
    public static Context ApplicationContext = null;

    public static String Server = "";
    public static String loginUri = "/icinga-web/modules/appkit/login/json";
    public static String logoutUri = "/icinga-web/modules/appkit/logout?logout=1";
}
