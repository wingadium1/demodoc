package mhst.dreamteam.Service;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat;

/**
 * Builds a notification message
 *
 * @author MinhNN
 */
public class NotiBuilder {
    private String mTitle;
    private String mTicker;
    private String mContentTxt;
    private String mContentInfo;
    private Bitmap mLargeIcon;
    private int mSmallIcon;
    private int mStyle;
    private Context mContext;
    private String[] mContentInbox;
    private PendingIntent mContentIntent;
    private long mWhen;

    public static final int NOTI_STYLE_NORMAL = 0x00; // Normal view
    public static final int NOTI_STYLE_INBOX = 0x01; // Big view

    public NotiBuilder(Context context) {
        this.mTitle = "";
        this.mTicker = "";
        this.mContentTxt = "";
        this.mContentInfo = "";
        this.mLargeIcon = null;
        this.mSmallIcon = 0;
        this.mStyle = NOTI_STYLE_NORMAL;
        this.mContext = context;
        this.mContentInbox = new String[0];
        this.mContentIntent = null;
        this.mWhen = 0;
    }

    public NotiBuilder(Context context, String mTitle, String mTicker, String mContentTxt, String mContentInfo, Bitmap mLargeIcon, int mSmallIcon) {
        this.mTitle = mTitle;
        this.mTicker = mTicker;
        this.mContentTxt = mContentTxt;
        this.mContentInfo = mContentInfo;
        this.mLargeIcon = mLargeIcon;
        this.mSmallIcon = mSmallIcon;
        this.mStyle = NOTI_STYLE_NORMAL;
        this.mContext = context;
        this.mContentInbox = new String[0];
        this.mContentIntent = null;
        this.mWhen = 0;
    }

    public NotiBuilder(Context context, String mTitle, String mTicker, String mContentTxt, String mContentInfo, Bitmap mLargeIcon, int mSmallIcon, int mStyle) {
        this.mTitle = mTitle;
        this.mTicker = mTicker;
        this.mContentTxt = mContentTxt;
        this.mContentInfo = mContentInfo;
        this.mLargeIcon = mLargeIcon;
        this.mSmallIcon = mSmallIcon;
        this.mStyle = mStyle;
        this.mContext = context;
        this.mContentInbox = new String[0];
        this.mContentIntent = null;
        this.mWhen = 0;
    }

    public NotiBuilder(Context mContext, String mTitle, String mTicker, String mContentTxt, String mContentInfo, Bitmap mLargeIcon, int mSmallIcon, int mStyle, String[] mContentInbox) {
        this.mContentInbox = mContentInbox;
        this.mTitle = mTitle;
        this.mTicker = mTicker;
        this.mContentTxt = mContentTxt;
        this.mContentInfo = mContentInfo;
        this.mLargeIcon = mLargeIcon;
        this.mSmallIcon = mSmallIcon;
        this.mStyle = mStyle;
        this.mContext = mContext;
        this.mContentIntent = null;
        this.mWhen = 0;
    }

    public String getTitle() {
        return mTitle;
    }

    public NotiBuilder setTitle(String mTitle) {

        this.mTitle = mTitle;
        return this;
    }

    public String getTicker() {
        return mTicker;
    }

    public NotiBuilder setTicker(String mTicker) {
        this.mTicker = mTicker;
        return this;
    }

    public String getContentTxt() {
        return mContentTxt;
    }

    public NotiBuilder setContentTxt(String mContentTxt) {
        this.mContentTxt = mContentTxt;
        return this;
    }

    public String getContentInfo() {
        return mContentInfo;
    }

    public NotiBuilder setContentInfo(String mContentInfo) {
        this.mContentInfo = mContentInfo;
        return this;
    }

    public Bitmap getLargeIcon() {
        return mLargeIcon;
    }

    public NotiBuilder setLargeIcon(Bitmap mLargeIcon) {
        this.mLargeIcon = mLargeIcon;
        return this;
    }

    public int getSmallIcon() {
        return mSmallIcon;
    }

    public NotiBuilder setSmallIcon(int mSmallIcon) {
        this.mSmallIcon = mSmallIcon;
        return this;
    }

    public int getStyle() {
        return mStyle;
    }

    public NotiBuilder setStyle(int mStyle) {
        this.mStyle = mStyle;
        return this;
    }

    public String[] getContentInbox() {
        return mContentInbox;
    }

    public NotiBuilder setContentInbox(String[] mContentInbox) {
        this.mContentInbox = mContentInbox;
        return this;
    }

    public NotiBuilder setContentIntent(PendingIntent pendingIntent) {
        this.mContentIntent = pendingIntent;
        return this;
    }

    public long getWhen() {
        return mWhen;
    }

    public NotiBuilder setWhen(long mWhen) {
        this.mWhen = mWhen;
        return this;
    }

    /**
     * Builds a notification message template <br />
     * Requires style (normal or inbox), content title, content text, content info are not null or empty;
     * otherwise, this function will return null.
     * @return Notification Builder
     */
    public NotificationCompat.Builder build() {
        if (mStyle == NOTI_STYLE_NORMAL || mStyle == NOTI_STYLE_INBOX) {
            if (!(isNullOrEmpty(mTitle) || isNullOrEmpty(mContentTxt) || isNullOrEmpty(mContentInfo))) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext);

                builder.setContentTitle(mTitle)
                        .setContentText(mContentTxt)
                        .setContentInfo(mContentInfo);

                if (!isNullOrEmpty(mTicker)) {
                    builder.setTicker(mTicker);
                }

                if (mLargeIcon != null) {
                    builder.setLargeIcon(mLargeIcon);
                }

                if (mSmallIcon != 0) {
                    builder.setSmallIcon(mSmallIcon);
                }

                if (mStyle == NOTI_STYLE_INBOX) {
                    NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                    inboxStyle.setBigContentTitle(mTitle);
                    for (String line : mContentInbox) {
                        inboxStyle.addLine(line);
                    }
                    builder.setStyle(inboxStyle);
                }

                if (mWhen != 0) {
                    builder.setWhen(mWhen);
                }

                if (mContentIntent != null) {
                    builder.setContentIntent(mContentIntent);
                }

                return builder;
            }
        }
        return null;
    }

    private boolean isNullOrEmpty(String str) {
        return (str == null || str.isEmpty());
    }
}
