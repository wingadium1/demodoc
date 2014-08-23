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
import mhst.dreamteam.Icinga.IcingaUdt;
import mhst.dreamteam.Interface.OnCompleteListener;
import mhst.dreamteam.R;

/**
 * Display list of services
 *
 * @author MinhNN
 */
public class ServicelistFragment extends Fragment implements OnCompleteListener {
    private ArrayList<Map<String, Object>> mService;
    private Context mContext;
    private ServicelistAdapter mListServiceAdapter;
    private String mRequest;
    private AlertDialog mDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_servicelist, container, false);

        mContext = inflater.getContext();
        mService = new ArrayList<Map<String, Object>>();
        ListView listService = (ListView) view.findViewById(R.id.lvListService);
        mListServiceAdapter = new ServicelistAdapter(inflater, mService);
        listService.setAdapter(mListServiceAdapter);

        ((Activity) mContext).setTitle(mContext.getResources().getString(R.string.title_fragment_service));

        // Get argument
        Bundle arg = getArguments();
        String request;
        if (arg != null) {
            request = arg.getString("Request", null);
            mRequest = ((request == null) ? IcingaUdt.getTemplate(IcingaUdt.ICINGA_TEMPLATE_MAINACTIVITY_SERVICE, 0, -1, null)
                    : request);
        } else {
            mRequest = IcingaUdt.getTemplate(IcingaUdt.ICINGA_TEMPLATE_MAINACTIVITY_SERVICE, 0, -1, null);
        }

        updateList();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
        ((Activity) mContext).setTitle(mContext.getResources().getString(R.string.title_fragment_service));
        updateList();
    }

    public void updateList() {
        IcingaApi.get(mContext, this, mRequest);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onComplete(Object obj, String sender) {
        if (obj != null) {
            mService.clear();
            mService.addAll((ArrayList<Map<String, Object>>) obj);
            mListServiceAdapter.notifyDataSetChanged();
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
