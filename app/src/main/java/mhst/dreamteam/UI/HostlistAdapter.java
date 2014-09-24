package mhst.dreamteam.UI;

import android.annotation.SuppressLint;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

import mhst.dreamteam.IcingaClient.Icinga.IcingaApiConst;
import mhst.dreamteam.IcingaClient.Icinga.IcingaConst;
import mhst.dreamteam.R;

/**
 * Host list adapter
 *
 * @author MinhNN
 */
public class HostlistAdapter extends BaseAdapter {
    private ArrayList<Map<String, Object>> mListItem;
    private LayoutInflater mInflater;

    public HostlistAdapter(LayoutInflater inflater, ArrayList<Map<String, Object>> listItem) {
        if (listItem == null || inflater == null) {
            throw new NullPointerException();
        }
        mListItem = listItem;
        mInflater = inflater;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.layout_host_item, parent, false);

        TextView tvSttColor = (TextView) convertView.findViewById(R.id.tvHostSttColor);
        TextView tvStatus = (TextView) convertView.findViewById(R.id.tvStatus);
        TextView tvHostName = (TextView) convertView.findViewById(R.id.tvHostName);
        TextView tvService = (TextView) convertView.findViewById(R.id.tvNumberService);
        TextView tvLastCheck = (TextView) convertView.findViewById(R.id.tvLastCheck);

        Map<String, Object> item = mListItem.get(position);

        int nColor = Color.GRAY;
        String sStatus = "UNKNOWN";
        String temp;
        if ((temp = (String) item.get(IcingaConst.HOST_CURRENT_STATE)) != null) {
            switch (Integer.parseInt(temp)) {
                case IcingaApiConst.HOST_STATE_OK:
                    nColor = Color.GREEN;
                    sStatus = "UP";
                    break;
                case IcingaApiConst.HOST_STATE_UNREACHABLE:
                    nColor = Color.ORANGE;
                    sStatus = "UNREACHABLE";
                    break;
                case IcingaApiConst.HOST_STATE_DOWN:
                    nColor = Color.RED_DARK;
                    sStatus = "DOWN";
                    break;
            }
        }

        String service = "";
        if (item.containsKey("SERVICE_WANRING")) {
            service += "<font color=\"#9A9A9A\">"
                    + String.valueOf(item.get("SERVICE_WANRING")) + " warning</font>";
        }
        if (item.containsKey("SERVICE_CRITICAL")) {
            if (!service.isEmpty()) {
                service += " - ";
            }
            service += "<font color=\"#FF0000\">"
                    + String.valueOf(item.get("SERVICE_CRITICAL")) + " critical</font>";
        }
        if (service.isEmpty()) {
            service = "<font color=\"#00FF00\">OK</font>";
        }

        tvSttColor.setBackgroundColor(nColor);
        tvStatus.setTextColor(nColor);
        tvStatus.setText(sStatus);
        tvService.setText(Html.fromHtml(service));
        tvHostName.setText((String) item.get(IcingaConst.HOST_NAME));
        tvLastCheck.setText((String) item.get(IcingaConst.HOST_LAST_CHECK));
        return convertView;
    }

    @Override
    public int getCount() {
        return mListItem.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return mListItem.get(position);
    }
}
