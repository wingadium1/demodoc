package mhst.dreamteam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import mhst.dreamteam.SessionMng.LoginActivity;
import mhst.dreamteam.SessionMng.Session;

/**
 * This is where our program starts
 * @author MinhNN
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get application context for further uses
        GlobalConfig.ApplicationContext = getApplicationContext();

        // Log in if not, required
        if (!Session.isLogin()) {
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivityForResult(i, Const.REQUESTCODE_REQUIRE_LOGIN);
        }

        setContentView(R.layout.activity_main);

        // Do next step here
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Const.REQUESTCODE_REQUIRE_LOGIN:
                // if user not log in, just exit
                if (resultCode != Const.RETURNCODE_SUCCESS) { finish(); }
                break;
        }
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
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
