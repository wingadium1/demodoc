package mhst.dreamteam.UI;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Draw a pie graph
 * @author MinhNN
 */
public class PieGraph extends View {
    List<Integer> mPercentage;
    List<Integer> mColors;
    Paint paint;
    RectF rectf;

    public PieGraph(Context context) {
        super(context);
        mPercentage = new ArrayList<Integer>();
        mColors = new ArrayList<Integer>();
        // Init
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectf = new RectF(10, 10, 200, 200);
    }

    public PieGraph setValues(Integer... values) {
        if (values != null) {
            mPercentage.addAll(Arrays.asList(values));
        }
        return this;
    }

    public PieGraph setColors(Integer... colors) {
        if (colors != null) {
            mPercentage.addAll(Arrays.asList(colors));
        }
        return this;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int startAngle = 0;

        // Calculate degree first
        float[] degree = new float[mPercentage.size()];
        int total = 0;

        // Total = 360*
        for (int i : mPercentage) {
            total += i;
        }
        // Section / Total * 360
        for (int i=0; i< mPercentage.size(); i++) {
            degree[i] = 360 * (mPercentage.get(i)/total);
        }

        // Draw pie
        for (int i=0; i<mPercentage.size(); i++) {
            if (i == 0) {
                paint.setColor(mColors.get(i));
                canvas.drawArc(rectf, 0, degree[i], true, paint);
            }
            else
            {
                startAngle += degree[i-1];
                paint.setColor(mColors.get(i));
                canvas.drawArc(rectf, startAngle, degree[i], true, paint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float xCoord = event.getX();
        float yCoord = event.getY();
        float xRadius = xCoord - ((rectf.left < rectf.right) ? (rectf.right - rectf.left) : (rectf.left - rectf.right))/2;
        float yRadius = yCoord - ((rectf.top < rectf.bottom) ? (rectf.bottom - rectf.top) : (rectf.top - rectf.bottom))/2;
        float rad = (float) Math.atan2(yRadius, xRadius);
        float deg = (float) (rad*180/Math.PI); // rad/2pi

        if (xCoord > rectf.left && xCoord < rectf.right
                && yCoord > rectf.top && yCoord < rectf.bottom) {

        }
        return super.onTouchEvent(event);
    }
}
