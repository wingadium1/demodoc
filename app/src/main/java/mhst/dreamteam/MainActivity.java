package mhst.dreamteam;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import mhst.dreamteam.Controller.NetController;
import mhst.dreamteam.Icinga.IcingaApi;
import mhst.dreamteam.Icinga.IcingaCronks;
import mhst.dreamteam.Icinga.IcingaExecutor;
import mhst.dreamteam.Icinga.IcingaJson;
import mhst.dreamteam.Icinga.IcingaUdt;
import mhst.dreamteam.UI.LoginActivity;
import mhst.dreamteam.SessionMng.Session;
import mhst.dreamteam.UI.HostlistFragment;
import mhst.dreamteam.UI.OverviewFragment;
import mhst.dreamteam.UI.ServicelistFragment;

/**
 * This is where our program starts
 *
 * @author MinhNN
 */
public class MainActivity extends Activity {
    private Session currentSession;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mDrawerList;
    private String[] menuItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        currentSession = Session.getInstance();

        // Log in if not, required
        if (!currentSession.isLogin()) {
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivityForResult(i, GlobalConst.REQUESTCODE_REQUIRE_LOGIN);
        }

        setContentView(R.layout.activity_main);

        menuItems = getResources().getStringArray(R.array.side_menu_item);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.lv_nav_drawer);

        ArrayAdapter<String> nav_adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, menuItems);

        mDrawerList.setAdapter(nav_adapter);

        mDrawerList.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
            }
        });

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_launcher, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getActionBar().setHomeButtonEnabled(true);

    }

    private void updateList() {
        String result = null;
        try {
            //result = new IcingaExecutor().execute(IcingaUdt.getTemplate(
            // IcingaUdt.ICINGA_TEMPLATE_MAINACTIVITY_SERVICE)).get();
            result = new IcingaExecutor().execute(IcingaUdt.getTemplate(
                    IcingaUdt.ICINGA_TEMPLATE_MAINACTIVITY_PENDINGHOST, 0, 0, "")).get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        if (result != null) {
//            tvHello.setText(result);
//        }
    }

    private void selectItem(int pos) {
        Fragment fragToChange = null;
        switch (pos) {
            case 0: // Overview
                fragToChange = new OverviewFragment();
                break;
            case 1: // Host
                fragToChange = new HostlistFragment();
                break;
            case 2: // Service
                fragToChange = new ServicelistFragment();
                break;
        }

        if (fragToChange != null) {
            FragmentManager fragMng = getFragmentManager();
            FragmentTransaction fragTrans = fragMng.beginTransaction();
            fragTrans.replace(R.id.main_content, fragToChange);
            fragTrans.commit();
        }

        mDrawerList.setItemChecked(pos, true);
        setTitle(menuItems[pos]);
        mDrawerLayout.closeDrawers();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case GlobalConst.REQUESTCODE_REQUIRE_LOGIN:
                // if user not log in, just exit; otherwise, update main activity view
                if (resultCode != GlobalConst.RETURNCODE_SUCCESS) {
                    finish();
                } else {
                    //updateList();
                    List result = new IcingaJson().get("icinga-unhandled-host-problems");
                    tvHello.setText(result.toString());
                }
                break;
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}

