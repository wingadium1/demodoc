package mhst.dreamteam;

import android.app.Application;
import android.app.IntentService;
import android.content.Intent;

import mhst.dreamteam.IcingaClient.SessionMng.Session;

/**
 * This class implement those class that will go through application life time
 *
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
