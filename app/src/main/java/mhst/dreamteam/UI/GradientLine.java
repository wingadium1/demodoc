package mhst.dreamteam.UI;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;

/**
 * Draw a gradient line
 *
 * @author MinhNN
 */
public class GradientLine extends View {
    private int xStart, yStart, xEnd, yEnd;
    private LinearGradient mGradient;
    private Paint mPaint;

    public GradientLine(Context context) {
        super(context);
        mGradient = new LinearGradient(0, 0, 0, 0, null, null, Shader.TileMode.MIRROR);
        mPaint = new Paint();
        mPaint.setDither(true);
        mPaint.setShader(mGradient);
        this.invalidate();
    }

    public GradientLine(Context context, int xstart, int ystart, int xend, int yend, int[] colors, float[] pos) {
        super(context);
        xStart = xstart;
        yStart = ystart;
        xEnd = xend;
        yEnd = yend;
        mGradient = new LinearGradient(xStart, yStart, xEnd, yEnd, colors, pos, Shader.TileMode.MIRROR);
        mPaint = new Paint();
        mPaint.setDither(true);
        mPaint.setShader(mGradient);
        this.invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(xStart, yStart, xEnd, yEnd, mPaint);
    }
}
