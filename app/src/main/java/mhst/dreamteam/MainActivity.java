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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import mhst.dreamteam.IcingaClient.GlobalConst;
import mhst.dreamteam.UI.LoginActivity;
import mhst.dreamteam.IcingaClient.SessionMng.Session;
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
    private int[] menuNumbers;

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
        menuNumbers = new int[menuItems.length];
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.lv_nav_drawer);

        ArrayAdapter<String> nav_adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.layout_side_menu_item, menuItems) {
            @Override
            @SuppressWarnings("ViewHolder")
            public View getView(int position, View convertView, ViewGroup parent) {
                convertView = getLayoutInflater().inflate(R.layout.layout_side_menu_item, parent, false);

                TextView tvTitle = (TextView) convertView.findViewById(R.id.tvSideMenuItemTitle);
                TextView tvNumber = (TextView) convertView.findViewById(R.id.tvSideMenuItemNumber);

                tvTitle.setText(menuItems[position]);
                if (menuNumbers[position] != 0) {
                    tvNumber.setText(menuItems[position]);
                }

                return convertView;
            }
        };

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

    private void selectItem(int pos) {
        Fragment fragToChange;
        boolean notFoundFragment = true;
        FragmentManager fragMng = getFragmentManager();
        fragToChange = fragMng.findFragmentByTag(menuItems[pos]);
        switch (pos) {
            case 0: // Overview
                if ((notFoundFragment = (fragToChange == null))) {
                    fragToChange = new OverviewFragment();
                }
                break;
            case 1: // Host
                if ((notFoundFragment = (fragToChange == null))) {
                    fragToChange = new HostlistFragment();
                }
                break;
            case 2: // Service
                if ((notFoundFragment = (fragToChange == null))) {
                    fragToChange = new ServicelistFragment();
                }
                break;
        }

        if (fragToChange != null) {
            FragmentTransaction fragTrans = fragMng.beginTransaction();
            fragTrans.replace(R.id.main_content, fragToChange);
            if (notFoundFragment) {
                fragTrans.addToBackStack(menuItems[pos]);
            }
            fragTrans.commit();
        }

        mDrawerList.setItemChecked(pos, true);
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
                    selectItem(0); // Overview
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

