package mhst.dreamteam.SessionMng;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.security.InvalidParameterException;

import mhst.dreamteam.Const;
import mhst.dreamteam.GlobalConfig;
import mhst.dreamteam.R;

/**
 * Login activity
 * @author MinhNN
 */
public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Get control IDs
        final EditText etIp = (EditText) findViewById(R.id.etIp);       // Server address
        final EditText etUser = (EditText) findViewById(R.id.etUser);   // Username
        final EditText etPass = (EditText) findViewById(R.id.etPass);   // Password
        final CheckBox cbRem = (CheckBox) findViewById(R.id.cbPass);    // Remember me?
        final Button btLogin = (Button) findViewById(R.id.btLogIn);     // Log in
        final Button btReg = (Button) findViewById(R.id.btRegister);    // Register
        final TextView tvStt = (TextView) findViewById(R.id.tvStt);     // Status


        // What do we do when "Log in" button clicked
        btLogin.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int result = Session.doLogin(etIp.getText().toString(), etUser.getText().toString(), etPass.getText().toString());
                    // Process result
                    switch (result) {
                        case Const.RETURNCODE_SUCCESS: // Log in successfully
                            setResult(result);
                            finish();
                        case Const.ERROR_WRONG_USER_PASS: // Wrong username or password
                            tvStt.setText(LoginActivity.this.getString(R.string.error_wrong_user_pass));
                            break;
                        case Const.ERROR_CONNECTION_ERROR: // Connection error
                            new AlertDialog.Builder(LoginActivity.this)
                                    .setMessage(R.string.error_server_unreachable)
                                    .setTitle(R.string.error)
                                    .create().show();
                            tvStt.setText(LoginActivity.this.getString(R.string.error_server_unreachable));
                            break;
                        default: // Log in failed, unknown error
                            tvStt.setText(LoginActivity.this.getString(R.string.error_login_fail));
                    }
                } catch (InvalidParameterException ex) {
                    // Empty field
                    tvStt.setText(LoginActivity.this.getString(R.string.error_empty_field));
                }
            }
        });

        // When register button clicked
        btReg.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start register activity
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
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