package mhst.dreamteam;

import android.app.Application;

import mhst.dreamteam.SessionMng.Session;

/**
 * This class implement those class that will go through application life time
 * @author MinhNN
 */
public class ApplicationContext extends Application {
    public static ApplicationContext AppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        AppContext = this;
        Session.init();
        System.setProperty("http.keepAlive", "true");
    }
}
