package mhst.dreamteam.UI;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Map;

import mhst.dreamteam.Icinga.IcingaApi;
import mhst.dreamteam.Icinga.IcingaConst;
import mhst.dreamteam.Icinga.IcingaUdt;
import mhst.dreamteam.Interface.OnCompleteListener;
import mhst.dreamteam.Interface.OnPieChartClickListener;
import mhst.dreamteam.R;

/**
 * Display overview information
 *
 * @author MinhNN
 */
public class OverviewFragment extends Fragment implements OnPieChartClickListener, OnCompleteListener{
    private Context mContext;
    private RelativeLayout mMainLayout;
    private Integer[] mHostSection, mServiceSection;
    private Integer[] mHostColor, mServiceColor;
    private String[] mHostName, mServiceName;
    private PieGraph mHostChart, mServiceChart;
    private AlertDialog mDialog;

    private final int HOST_UP = 0;
    private final int HOST_DOWN = 1;
    private final int HOST_UNREACHABLE = 2;
    private final int HOST_PENDING = 3;

    private final int SERVICE_OK = 4;
    private final int SERVICE_WARNING = 5;
    private final int SERVICE_CRITICAL = 6;
    private final int SERVICE_UNKNOWN = 7;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        // Init resources
        mContext = inflater.getContext();
        mHostSection = new Integer[]{0, 0, 0, 0}; // 4 state
        mHostColor = new Integer[]{Color.GREEN, Color.RED_DARK, Color.ORANGE, Color.GRAY};
        mHostName = new String[]{"", "", "", ""}; // 4 state
        mServiceSection = new Integer[]{0, 0, 0, 0}; // 4 state
        mServiceColor = new Integer[]{Color.GREEN, Color.GRAY, Color.RED, Color.ORANGE};
        mServiceName = new String[]{"", "", "", ""}; // 4 state
        mMainLayout = (RelativeLayout) view.findViewById(R.id.fragmentOverview);
        FrameLayout hostLayout = (FrameLayout) view.findViewById(R.id.graphHostList);
        FrameLayout serviceLayout = (FrameLayout) view.findViewById(R.id.graphServiceList);
        FrameLayout dividerLayout = (FrameLayout) view.findViewById(R.id.graphDivider);

        // Get screen attributes
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        final int nScreenW = size.x;
        final int nScreenH = size.y-100;

        // Set title
        ((Activity) mContext).setTitle(mContext.getResources().getString(R.string.title_fragment_overview));

        // Init chart position and size
        int left = nScreenW/2 - nScreenH*3/20;
        int top = nScreenH/12;
        int right = left + 3*nScreenH/10;
        int bottom = top + 3*nScreenH/10;

        // Creat new chart
        mHostChart = new PieGraph(mContext, this, left, top, right, bottom);
        mHostChart.setSections(mHostSection).setColors(mHostColor)
                .setValues(HOST_UP, HOST_DOWN, HOST_UNREACHABLE, HOST_PENDING)
                .setNames(mHostName).setTitle("HOST");
        mServiceChart = new PieGraph(mContext, this, left, bottom + nScreenH/5, right, bottom + nScreenH/5 + bottom - top);
        mServiceChart.setSections(mServiceSection).setColors(mServiceColor)
                .setValues(SERVICE_OK, SERVICE_WARNING, SERVICE_CRITICAL, SERVICE_UNKNOWN)
                .setNames(mServiceName).setTitle("SERVICE");
        GradientLine divider = new GradientLine(mContext, 0, bottom + nScreenH/10, nScreenW, bottom + nScreenH/10,
                new int[]{Color.WHITE, Color.BLUE, Color.WHITE}, null);

        hostLayout.addView(mHostChart);
        serviceLayout.addView(mServiceChart);
        dividerLayout.addView(divider);

        // Update UI
        updateUi();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
        ((Activity) mContext).setTitle(mContext.getResources().getString(R.string.title_fragment_overview));
        updateUi();
    }

    private void updateUi() {
        IcingaApi.get(mContext, this, IcingaUdt.getTemplate(IcingaUdt.ICINGA_TEMPLATE_MAINACTIVITY_HOST, 0, -1, ""));
        IcingaApi.get(mContext, this, IcingaUdt.getTemplate(IcingaUdt.ICINGA_TEMPLATE_MAINACTIVITY_SERVICE, 0, -1, ""));
    }

    @Override
    public void onPieChartClick(int element) {
        Fragment frag = null;
        Bundle b = new Bundle();
        FragmentManager fragMng = getFragmentManager();
        switch (element) {
            case HOST_UP:
                frag = new HostlistFragment();
                b.putString("Request", IcingaUdt.getTemplate(IcingaUdt.ICINGA_TEMPLATE_MAINACTIVITY_OKHOST, 0, -1, null));
                b.putString("TitleEx", "[UP]");
                break;
            case HOST_DOWN:
                frag = new HostlistFragment();
                b.putString("Request", IcingaUdt.getTemplate(IcingaUdt.ICINGA_TEMPLATE_MAINACTIVITY_DOWNHOST, 0, -1, null));
                b.putString("TitleEx", "[DOWN]");
                break;
            case HOST_UNREACHABLE:
                frag = new HostlistFragment();
                b.putString("Request", IcingaUdt.getTemplate(IcingaUdt.ICINGA_TEMPLATE_MAINACTIVITY_UNREACHABLEHOST, 0, -1, null));
                b.putString("TitleEx", "[UNREACHABLE]");
                break;
            case HOST_PENDING:
                frag = new HostlistFragment();
                b.putString("Request", IcingaUdt.getTemplate(IcingaUdt.ICINGA_TEMPLATE_MAINACTIVITY_PENDINGHOST, 0, -1, null));
                b.putString("TitleEx", "[PENDING]");
                break;
            case SERVICE_OK:
                frag = new ServicelistFragment();
                b.putString("Request", IcingaUdt.getTemplate(IcingaUdt.ICINGA_TEMPLATE_MAINACTIVITY_OKSERVICE, 0, -1, null));
                b.putString("TitleEx", "[OK]");
                break;
            case SERVICE_WARNING:
                frag = new ServicelistFragment();
                b.putString("Request", IcingaUdt.getTemplate(IcingaUdt.ICINGA_TEMPLATE_MAINACTIVITY_WARNINGSERVICE, 0, -1, null));
                b.putString("TitleEx", "[WARNING]");
                break;
            case SERVICE_CRITICAL:
                frag = new ServicelistFragment();
                b.putString("Request", IcingaUdt.getTemplate(IcingaUdt.ICINGA_TEMPLATE_MAINACTIVITY_CRITICALSERVICE, 0, -1, null));
                b.putString("TitleEx", "[CRITICAL]");
                break;
            case SERVICE_UNKNOWN:
                frag = new ServicelistFragment();
                b.putString("Request", IcingaUdt.getTemplate(IcingaUdt.ICINGA_TEMPLATE_MAINACTIVITY_UNKNOWSERVICE, 0, -1, null));
                b.putString("TitleEx", "[UNKNOWN]");
                break;
        }

        if (frag != null) {
            frag.setArguments(b);
            FragmentTransaction fragTrans = fragMng.beginTransaction();
            fragTrans.replace(R.id.main_content, frag);
            fragTrans.addToBackStack("DetailChart");
            fragTrans.commit();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onComplete(Object obj, String sender) {
        if (obj != null) {
            ArrayList<Map<String, Object>> result = (ArrayList<Map<String, Object>>) obj;
            if (result.size() > 0) {
                // Check is host request or service request
                if (!result.get(0).containsKey(IcingaConst.SERVICE_CURRENT_STATE)) {
                    // Host request
                    // Reset value
                    for (int j = 0; j < mHostSection.length; j++) {
                        mHostSection[j] = 0;
                    }
                    // New value
                    for (Map<String, Object> target : result) {
                        int state = Integer.parseInt((String) target.get(IcingaConst.HOST_CURRENT_STATE));
                        for (int j = 0; j < mHostSection.length; j++) {
                            if (state == j) {
                                mHostSection[j]++;
                            }
                        }
                    }
                } else {
                    // Service request
                    // Reset value
                    for (int j = 0; j < mServiceSection.length; j++) {
                        mServiceSection[j] = 0;
                    }
                    // New value
                    for (Map<String, Object> target : result) {
                        int state = Integer.parseInt((String) target.get(IcingaConst.SERVICE_CURRENT_STATE));
                        for (int j = 0; j < mServiceSection.length; j++) {
                            if (state == j) {
                                mServiceSection[j]++;
                            }
                        }
                    }
                }

                mHostName[0] = mHostSection[0] + " UP";
                mHostName[1] = mHostSection[1] + " DOWN";
                mHostName[2] = mHostSection[2] + " UNREACHABLE";
                mHostName[3] = mHostSection[3] + " PENDING";

                mServiceName[0] = mServiceSection[0] + " OK";
                mServiceName[1] = mServiceSection[1] + " WARNING";
                mServiceName[2] = mServiceSection[2] + " CRITICAL";
                mServiceName[3] = mServiceSection[3] + " UNKNOWN";

                mHostChart.setNames(mHostName).setSections(mHostSection);
                mServiceChart.setNames(mServiceName).setSections(mServiceSection);
            }
        } else {
            // Error
            if (mDialog == null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                mDialog = builder.setIcon(android.R.drawable.ic_dialog_alert)
                                .setTitle("Oops")
                                .setMessage(getResources().getString(R.string.error_icinga_fail))
                                .setPositiveButton(getResources().getString(R.string.action_tryagain),
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                updateUi();
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
