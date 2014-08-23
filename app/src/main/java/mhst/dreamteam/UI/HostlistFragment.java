package mhst.dreamteam.UI;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

import mhst.dreamteam.Icinga.IcingaApi;
import mhst.dreamteam.Icinga.IcingaApiConst;
import mhst.dreamteam.Icinga.IcingaConst;
import mhst.dreamteam.Icinga.IcingaUdt;
import mhst.dreamteam.Interface.OnCompleteListener;
import mhst.dreamteam.R;

/**
 * Display list of hosts
 *
 * @author MinhNN
 */
public class HostlistFragment extends Fragment implements OnCompleteListener {
    private ArrayList<Map<String, Object>> mHost;
    private Context mContext;
    private HostlistAdapter mListHostAdapter;
    private String mRequest;
    private AlertDialog mDialog;
    private String mTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hostlist, container, false);

        // Init resourses
        mContext = inflater.getContext();
        mHost = new ArrayList<Map<String, Object>>();
        mTitle = "";
        ListView listHost = (ListView) view.findViewById(R.id.lvListHost);
        mListHostAdapter = new HostlistAdapter(inflater, mHost);
        listHost.setAdapter(mListHostAdapter);

        // Get argument
        Bundle arg = getArguments();
        String request;
        String title = "";
        if (arg != null) {
            request = arg.getString("Request", null);
            mRequest = ((request == null) ? IcingaUdt.getTemplate(IcingaUdt.ICINGA_TEMPLATE_MAINACTIVITY_HOST, 0, -1, null)
                    : request);
            title = arg.getString("TitleEx", "");
        } else {
            mRequest = IcingaUdt.getTemplate(IcingaUdt.ICINGA_TEMPLATE_MAINACTIVITY_HOST, 0, -1, null);
        }

        // Set title
        mTitle = mContext.getResources().getString(R.string.title_fragment_host) + " " + title;
        ((Activity) mContext).setTitle(mTitle);

        // Update list
        updateList();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
        ((Activity) mContext).setTitle(mTitle);
        updateList();
    }

    public void updateList() {
        IcingaApi.get(mContext, this, mRequest);
        IcingaApi.cronks(mContext, this, IcingaApi.TEMPLATE_PROBLEMS_ICINGA_ALL_SERVICE);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onComplete(Object obj, String sender) {
        if (obj != null) {
            ArrayList<Map<String, Object>> result = (ArrayList<Map<String, Object>>) obj;
            if (sender.equals("IcingaGet")) {
                mHost.clear();
                mHost.addAll(result);
                mListHostAdapter.notifyDataSetChanged();
            } else if (sender.equals("IcingaCronks")) {
                if (result.size() > 0) {
                    for (Map<String, Object> item : result) {
                        for (Map<String, Object> host : mHost) {
                            if (host.get(IcingaConst.HOST_NAME).equals(item.get(IcingaConst.HOST_NAME))) {
                                if (Integer.parseInt((String)item.get(IcingaConst.SERVICE_CURRENT_STATE))
                                        == IcingaApiConst.SERVICE_STATE_WARNING) {
                                    if (!host.containsKey("SERVICE_WARNING")) {
                                        host.put("SERVICE_WARNING", 0);
                                    }
                                    host.put("SERVICE_WARNING", (Integer)host.get("SERVICE_WARNING")+1);
                                } else if (Integer.parseInt((String)item.get(IcingaConst.SERVICE_CURRENT_STATE))
                                        == IcingaApiConst.SERVICE_STATE_CRITICAL) {
                                    if (!host.containsKey("SERVICE_CRITICAL")) {
                                        host.put("SERVICE_CRITICAL", 0);
                                    }
                                    host.put("SERVICE_CRITICAL", (Integer)host.get("SERVICE_CRITICAL")+1);
                                }
                            }
                        }
                    }
                    mListHostAdapter.notifyDataSetChanged();
                }
            }
        } else {
            if (mDialog == null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                mDialog = builder.setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Oops")
                        .setMessage(getResources().getString(R.string.error_icinga_fail))
                        .setPositiveButton(getResources().getString(R.string.action_tryagain),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        updateList();
                                    }
                                })
                        .setNegativeButton(getResources().getString(R.string.action_cancel),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Do nothing
                                    }
                                })
                        .create();
            }

            if (!mDialog.isShowing()) {
                mDialog.show();
            }
        }
    }
}
