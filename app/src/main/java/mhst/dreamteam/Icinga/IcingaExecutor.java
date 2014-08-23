package mhst.dreamteam.Icinga;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import mhst.dreamteam.Controller.NetController;
import mhst.dreamteam.Interface.OnCompleteListener;
import mhst.dreamteam.R;
import mhst.dreamteam.SessionMng.Session;

/**
 * Execute Icinga Api request. This class uses to send request to server and get raw response String.
 * Uses IcingaApi to parse the response data.
 *
 * @author MinhNN
 * @see mhst.dreamteam.Icinga.IcingaApi
 */
public class IcingaExecutor extends AsyncTask<String, Void, String> {
    private Context mContext;
    private ProgressDialog mProgress;
    private OnCompleteListener mListener;
    private Session currentSs;
    private boolean mExecuting;

    public IcingaExecutor(Context context, OnCompleteListener listener) {
        mContext = context;
        mListener = listener;
        currentSs = Session.getInstance();
        mExecuting = false;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgress = new ProgressDialog(mContext);
        mProgress.setCancelable(false);
        mProgress.setMessage(mContext.getResources().getString(R.string.message_loading_data) + "...");
        mProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        if (!currentSs.isInProgress() && !mProgress.isShowing()) {
            currentSs.isInProgress(true);
            mProgress.show();
        }
    }
    @Override
    protected String doInBackground(String... params) {
        if (!mExecuting) {
            mExecuting = true;
            // Get current application session
            Session AppSession = Session.getInstance();

            // Check if user is logged in or if session has cookie
            if (!AppSession.isLogin()) return null;
            if (AppSession.getCookie() == null) return null;

            // Properties for request
            Map<String, String> prop = new HashMap<String, String>();
            if (AppSession.getCookie() != null) {
                prop.put("Cookie", AppSession.getCookie());
            }

            // Parse api uri (for further use)
            String Uri = AppSession.getWorkingServer() + params[0];

            // Send request and get response
            String result;
            Log.i("Icinga Executor", Uri);
            publishProgress();
            Map<String, Object> response = NetController.sendRequest("GET", Uri, null, prop);
            if (response.containsKey("Code")) {
                if (((Integer) response.get("Code")) == HttpStatus.SC_OK) {
                    if (response.containsKey("Data")) {
                        result = (String) response.get("Data");
                        if (result != null) return result;
                    }
                }
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        if (!currentSs.isInProgress() && !mProgress.isShowing()) {
            currentSs.isInProgress(true);
            mProgress.show();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (mProgress != null) {
            mProgress.dismiss();
            currentSs.isInProgress(false);
        }
        if (mListener != null) {
            mListener.onComplete(result, "IcingaExecutor");
        }
    }
}
