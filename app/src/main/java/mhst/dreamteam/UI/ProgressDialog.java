package mhst.dreamteam.UI;

import android.app.Dialog;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import mhst.dreamteam.R;

/**
 * @author MinhNN
 */
public class ProgressDialog extends Dialog {
    private String mTitle;
    private String mMsg;
    private TextView tvMsg;
    private ImageView ivLoad;
    private RotateAnimation anim;

    public ProgressDialog(Context context) {
        super(context, R.style.ProgressDialog);
        setContentView(R.layout.layout_progress_dialog);
        mTitle = mMsg = "";
        setCancelable(false);
        tvMsg = (TextView) findViewById(R.id.tvMsg);
        ivLoad = (ImageView) findViewById(R.id.ivLoading);

        anim = new RotateAnimation(0f, 360f, ivLoad.getPivotX(), ivLoad.getPivotY());
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(700);
    }

    public ProgressDialog(Context context, String title, String msg) {
        super(context, R.style.ProgressDialog);
        setContentView(R.layout.layout_progress_dialog);
        mTitle = title;
        mMsg = msg;
        setCancelable(false);
        tvMsg = (TextView) findViewById(R.id.tvMsg);
        ivLoad = (ImageView) findViewById(R.id.ivLoading);

        anim = new RotateAnimation(0f, 350f, 15f, 15f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(700);
    }

    public ProgressDialog setTitle(String title) {
        mTitle = title;
        return this;
    }

    public ProgressDialog setMessage(String msg) {
        mMsg = msg;
        return this;
    }

    @Override
    public void show() {
        ivLoad.setAnimation(anim);
        this.setTitle(mTitle);
        tvMsg.setText(mMsg);
        super.show();
    }
}
