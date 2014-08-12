package mhst.dreamteam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

import mhst.dreamteam.Icinga.IcingaExecutor;
import mhst.dreamteam.Icinga.IcingaUdt;
import mhst.dreamteam.SessionMng.LoginActivity;
import mhst.dreamteam.SessionMng.Session;

/**
 * This is where our program starts
 * @author MinhNN
 */
public class MainActivity extends Activity {
    TextView tvHello;
    Session currentSession;

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

        // Do next step here
        tvHello = (TextView) findViewById(R.id.tvHello);

    }

    private void updateList() {
        String result = null;
        try {
            //result = new IcingaExecutor().execute(IcingaUdt.getTemplate(
            // IcingaUdt.ICINGA_TEMPLATE_MAINACTIVITY_SERVICE)).get();
            result = new IcingaExecutor().execute(IcingaUdt.getTemplate(
                    IcingaUdt.ICINGA_TEMPLATE_MAINACTIVITY_PENDINGHOST,0,0,"")).get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if (result != null) {
            tvHello.setText(result);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case GlobalConst.REQUESTCODE_REQUIRE_LOGIN:
                // if user not log in, just exit; otherwise, update main activity view
                if (resultCode != GlobalConst.RETURNCODE_SUCCESS) { finish(); }
                else { updateList(); }
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

