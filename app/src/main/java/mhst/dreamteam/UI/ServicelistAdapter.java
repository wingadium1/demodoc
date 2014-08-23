package mhst.dreamteam.UI;

import android.annotation.SuppressLint;
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
 * Service list adapter
 *
 * @author MinhNN
 */
public class ServicelistAdapter extends BaseAdapter {
    private ArrayList<Map<String, Object>> mListItem;
    private LayoutInflater mInflater;

    public ServicelistAdapter(LayoutInflater inflater, ArrayList<Map<String, Object>> listItem) {
        if (listItem == null || inflater == null) {
            throw new NullPointerException();
        }
        mListItem = listItem;
        mInflater = inflater;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.service_item_layout, parent, false);

        TextView tvSttColor = (TextView) convertView.findViewById(R.id.tvServiceSttColor);
        TextView tvStatus = (TextView) convertView.findViewById(R.id.tvStatus);
        TextView tvServiceName = (TextView) convertView.findViewById(R.id.tvServiceName);
        TextView tvServiceOutput = (TextView) convertView.findViewById(R.id.tvServiceOutput);
        TextView tvLastCheck = (TextView) convertView.findViewById(R.id.tvLastCheck);

        Map<String, Object> item = mListItem.get(position);

        int nColor = Color.ORANGE;
        String sStatus = "UNKNOWN";
        String temp;
        if ((temp = (String) item.get(IcingaConst.SERVICE_CURRENT_STATE)) != null) {
            switch (Integer.parseInt(temp)) {
                case IcingaApiConst.SERVICE_STATE_OK:
                    nColor = Color.GREEN;
                    sStatus = "OK";
                    break;
                case IcingaApiConst.SERVICE_STATE_WARNING:
                    nColor = Color.GRAY;
                    sStatus = "WARNING";
                    break;
                case IcingaApiConst.SERVICE_STATE_CRITICAL:
                    nColor = Color.RED;
                    sStatus = "CRITICAL";
                    break;
            }
        }

        tvSttColor.setBackgroundColor(nColor);
        tvStatus.setTextColor(nColor);
        tvStatus.setText(sStatus);
        tvServiceName.setText((String) item.get(IcingaConst.SERVICE_NAME));
        tvServiceOutput.setText((String) item.get(IcingaConst.SERVICE_OUTPUT));
        tvLastCheck.setText((String) item.get(IcingaConst.SERVICE_LAST_CHECK));
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
