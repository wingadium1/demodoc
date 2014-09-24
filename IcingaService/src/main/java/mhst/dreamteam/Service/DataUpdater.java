package mhst.dreamteam.Service;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

import mhst.dreamteam.IcingaClient.GlobalConst;
import mhst.dreamteam.IcingaClient.Icinga.IcingaApi;
import mhst.dreamteam.IcingaClient.Interface.OnCompleteListener;

/**
 * Background service to check notification from server
 *
 * @author MinhNN
 */
public class DataUpdater extends IntentService implements OnCompleteListener {
    private Stack<Map<String, Object>> mEventStack;

    private boolean isLoading = false;
    private NotiBuilder mNotiBuilder;
    private NotificationManager mNotiMng;
    private long lastChecked;

    private final String NOTIFICATION_ID = "NOTIFICATION_ID";
    private final String NOTIFICATION_TYPE = "NOTIFICATION_TYPE";
    private final String NOTIFICATION_CONTACT = "NOTIFICATION_CONTACT";
    private final String NOTIFICATION_HOST_NAME = "HOST_NAME";
    private final String NOTIFICATION_SERVICE_NAME = "SERVICE_NAME";
    private final String NOTIFICATION_STATE = "NOTIFICATION_STATE";
    private final String NOTIFICATION_STARTTIME = "NOTIFICATION_STARTTIME";
    private final String NOTIFICATION_OUTPUT = "NOTIFICATION_OUTPUT";
    private final String NOTIFICATION_COMMAND_NAME = "COMMAND_NAME";

    private final int NOTIFICATION_TYPE_HOST = 0;
    private final int NOTIFICATION_TYPE_SERVICE = 1;

    public DataUpdater() {
        super("IcingaDataUpdater");
        mEventStack = new Stack<Map<String, Object>>();
        mNotiBuilder = new NotiBuilder(this);
        mNotiBuilder.setTitle(this.getResources().getString(R.string.app_name))
                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_launcher));
        mNotiMng = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Calendar now = Calendar.getInstance();
        lastChecked = now.getTimeInMillis();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!mEventStack.isEmpty()) {
                    while (!mEventStack.isEmpty()) {
                        Map<String, Object> event = mEventStack.pop();

                        // Convert notification state to nature text
                        String sState = "";
                        int nState = (Integer) event.get(NOTIFICATION_STATE);
                        switch (nState) {
                            case 0: // Host UP or service OK
                                sState = ((Integer) event.get(NOTIFICATION_TYPE) == NOTIFICATION_TYPE_HOST) ? "UP" : "OK";
                                break;
                            case 1: // Host DOWN or service WARNING
                                sState = ((Integer) event.get(NOTIFICATION_TYPE) == NOTIFICATION_TYPE_HOST) ? "DOWN" : "WARNING";
                                break;
                            case 2: // Host UNREACHABLE or service CRITICAL
                                sState = ((Integer) event.get(NOTIFICATION_TYPE) == NOTIFICATION_TYPE_HOST) ? "UNREACHABLE" : "CRITICAL";
                                break;
                            case 3: // Service UNKNOWN
                                sState = "UNKNOWN";
                                break;
                        }

                        // Build string content text
                        String content = "[" + sState + "]\n" +
                                (((Integer) event.get(NOTIFICATION_TYPE) == NOTIFICATION_TYPE_HOST) ? event.get(NOTIFICATION_HOST_NAME) : event.get(NOTIFICATION_SERVICE_NAME)) +
                                ": " + event.get(NOTIFICATION_OUTPUT);

                        // Set content text and info
                        mNotiBuilder.setContentTxt(content);
                        mNotiBuilder.setContentInfo((String) event.get(NOTIFICATION_CONTACT));

                        // Set ticker to display summary on status bar
                        mNotiBuilder.setTicker("[" + sState + "] " + event.get(NOTIFICATION_OUTPUT));

//                        // Intent to open main activity
//                        Intent intent = new Intent(DataUpdater.this, MainActivity.class);
//                        // Request code to decide which fragment will be opened when main activity displayed
//                        intent.putExtra("RequestCode", (Integer) event.get(NOTIFICATION_STATE));
//
//                        // What to do when click notification (in this case, open main activity)
//                        PendingIntent pending = PendingIntent.getActivity(DataUpdater.this, (Integer) event.get(NOTIFICATION_STATE),
//                                intent, PendingIntent.FLAG_UPDATE_CURRENT);
//                        mNotiBuilder.setContentIntent(pending);
//
//                        // Notify the notification service
//                        mNotiMng.notify(GlobalConst.REQUESTCODE_NOTIFICATION_HOST_UPDATE, mNotiBuilder.build().build());
                    }
                }
            }
        }, 1000, 1000);

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!isLoading) {
                    IcingaApi.cronks(DataUpdater.this, IcingaApi.TEMPLATE_ICINGA_NOTIFICATION);
                    isLoading = true;
                }
            }
        }, 1000, 500);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onComplete(Object obj, String sender) {
        if (obj != null) {
            ArrayList<Map<String, Object>> result = (ArrayList<Map<String, Object>>) obj;
            long startTime;
            for (Map<String, Object> o : result) {
                startTime = Time.valueOf((String) o.get(NOTIFICATION_STARTTIME)).getTime();
                if (startTime > lastChecked) {
                    mEventStack.push(o);
                }
            }
        }
        isLoading = false;
    }
}
