package mhst.dreamteam.UI;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

import mhst.dreamteam.R;

/**
 * Display list of hosts
 * @author MinhNN
 */
public class HostlistFragment extends Fragment {
    ArrayList<Map<String, Object>> mHost;
    Context mContext;
    HostlistAdapter mListHostAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hostlist, container, false);
        mContext = inflater.getContext();
        mHost = new ArrayList<Map<String, Object>>();
        ListView listHost = (ListView) view.findViewById(R.id.lvListHost);
        mListHostAdapter = new HostlistAdapter(inflater, mHost);
        listHost.setAdapter(mListHostAdapter);
        updateList();
        return view;
    }

    public void updateList() {

    }

}
