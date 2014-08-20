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
 * Display list of services
 * @author MinhNN
 */
public class ServicelistFragment extends Fragment {
    ArrayList<Map<String, Object>> mService;
    Context mContext;
    ServicelistAdapter mListServiceAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_servicelist, container, false);
        mContext = inflater.getContext();
        mService = new ArrayList<Map<String, Object>>();
        ListView listService = (ListView) view.findViewById(R.id.lvListService);
        mListServiceAdapter = new ServicelistAdapter(inflater, mService);
        listService.setAdapter(mListServiceAdapter);
        updateList();
        return view;
    }

    public void updateList() {

    }
}
