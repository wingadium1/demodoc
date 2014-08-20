package mhst.dreamteam.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

import mhst.dreamteam.Icinga.IcingaApiConst;
import mhst.dreamteam.Icinga.IcingaConst;
import mhst.dreamteam.R;

/**
 * Host list adapter
 * @author MinhNN
 */
public class HostlistAdapter extends BaseAdapter {
    ArrayList<Map<String, Object>> mListItem;
    LayoutInflater mInflater;

    public HostlistAdapter(LayoutInflater inflater, ArrayList<Map<String, Object>> listItem) {
        if (listItem == null || inflater == null) {
            throw new NullPointerException();
        }
        mListItem = listItem;
        mInflater = inflater;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.host_item_layout, parent);

        TextView tvSttColor = (TextView) convertView.findViewById(R.id.tvHostSttColor);
        TextView tvStatus = (TextView) convertView.findViewById(R.id.tvStatus);
        TextView tvHostName = (TextView) convertView.findViewById(R.id.tvHostName);
        TextView tvService = (TextView) convertView.findViewById(R.id.tvNumberService);
        TextView tvLastCheck = (TextView) convertView.findViewById(R.id.tvLastCheck);

        Map<String, Object> item = mListItem.get(position);

        int nColor = R.color.gray;
        String sStatus = "UNKNOWN";
        switch ((Integer) item.get(IcingaConst.HOST_CURRENT_STATE)) {
            case IcingaApiConst.HOST_STATE_OK:
                nColor = R.color.green;
                sStatus = "UP";
                break;
            case IcingaApiConst.HOST_STATE_UNREACHABLE:
                nColor = R.color.orange;
                sStatus = "UNREACHABLE";
                break;
            case IcingaApiConst.HOST_STATE_DOWN:
                nColor = R.color.red_dark;
                sStatus = "DOWN";
                break;
        }

        tvSttColor.setBackgroundColor(nColor);
        tvStatus.setTextColor(nColor);
        tvStatus.setText(sStatus);
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
