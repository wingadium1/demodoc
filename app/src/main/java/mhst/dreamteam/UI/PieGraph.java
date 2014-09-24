package mhst.dreamteam.UI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.*;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mhst.dreamteam.IcingaClient.Interface.OnPieChartClickListener;

/**
 * Draw a pie graph
 *
 * @author MinhNN
 */
public class PieGraph extends View {
    private List<Integer> mPercentage;
    private List<Integer> mColors;
    private List<Float> mAngle;
    private List<Integer> mValues;
    private List<String> mNames;
    private String mTitle;
    private Paint paint;
    private RectF rectf;
    private OnPieChartClickListener mListener;
    private float nScreenW;

    public static final int DEFAULT_LEFT = 0;
    public static final int DEFAULT_TOP = 0;
    public static final int DEFAULT_RIGHT = 100;
    public static final int DEFAULT_BOTTOM = 100;

    public PieGraph(Context context) {
        super(context);
    }

    public PieGraph(Context context, OnPieChartClickListener listener) {
        super(context);
        mPercentage = new ArrayList<Integer>();
        mColors = new ArrayList<Integer>();
        mAngle = new ArrayList<Float>();
        mValues = new ArrayList<Integer>();
        mNames = new ArrayList<String>();
        mListener = listener;
        // Init
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectf = new RectF(DEFAULT_LEFT, DEFAULT_TOP, DEFAULT_RIGHT, DEFAULT_BOTTOM);
    }

    public PieGraph(Context context, OnPieChartClickListener listener, int left, int top, int right, int bottom) {
        super(context);
        mPercentage = new ArrayList<Integer>();
        mColors = new ArrayList<Integer>();
        mAngle = new ArrayList<Float>();
        mValues = new ArrayList<Integer>();
        mNames = new ArrayList<String>();
        mListener = listener;
        // Init
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectf = new RectF(left, top, right, bottom);

        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        nScreenW = size.x;
    }

    public PieGraph setTitle(String title) {
        mTitle = title;

        return this;
    }

    public PieGraph setSections(Integer... values) {
        if (values != null) {
            mPercentage.clear();
            mPercentage.addAll(Arrays.asList(values));
            this.invalidate();
        }

        return this;
    }

    public PieGraph setValues(Integer... values) {
        if (values != null) {
            mValues.clear();
            mValues.addAll(Arrays.asList(values));
            this.invalidate();
        }

        return this;
    }

    public PieGraph setNames(String... values) {
        if (values != null) {
            mNames.clear();
            mNames.addAll(Arrays.asList(values));
            this.invalidate();
        }

        return this;
    }

    public PieGraph setColors(Integer... colors) {
        if (colors != null) {
            mColors.clear();
            mColors.addAll(Arrays.asList(colors));

            for (int color=0; color<mColors.size(); color++) {
                mColors.set(color, setAlpha(mColors.get(color)));
            }
            this.invalidate();
        }

        return this;
    }

    private int setAlpha(int color) {
        return Color.argb(225, Color.red(color), Color.green(color), Color.blue(color));
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPercentage != null && mColors != null && mAngle != null && mValues != null && mNames != null) {
            if (mPercentage.size() == mColors.size() && mPercentage.size() == mValues.size()
                    && mPercentage.size() == mNames.size() && mColors.size() > 0) {
                if (mTitle != null) {
                    Rect bounds = new Rect();
                    paint.getTextBounds(mTitle, 0, mTitle.length(), bounds);
                    int w = bounds.width();
                    paint.setColor(Color.BLUE);
                    paint.setTextSize(30);
                    canvas.drawText(mTitle, rectf.centerX()-w*0.5f, rectf.top-20, paint);
                }
                float nCircleRadius = (Math.abs(rectf.right) - Math.abs(rectf.left)) * 0.5f;
                float xCenter = rectf.left + nCircleRadius;
                float yCenter = rectf.top + nCircleRadius;
                mAngle.clear();
                mAngle.add(-90f); // First element angle

                // Calculate degree first
                float[] degree = new float[mPercentage.size()];
                int total = 0;

                // Total = 360*
                for (int i : mPercentage) {
                    total += i;
                }
                // Section / Total * 360
                for (int i = 0; i < mPercentage.size(); i++) {
                    degree[i] = 360 * ((float) mPercentage.get(i) / (float) total);
                }

                // Draw pie
                int numberOfSection = 0;
                paint.setStyle(Paint.Style.FILL);
                for (int i = 0; i < mPercentage.size(); i++) {
                    if (i == 0) {
                        paint.setColor(mColors.get(i));
                        canvas.drawArc(rectf, mAngle.get(mAngle.size() - 1), degree[i], true, paint);
                    } else {
                        mAngle.add(mAngle.get(mAngle.size() - 1) + degree[i - 1]);
                        paint.setColor(mColors.get(i));
                        canvas.drawArc(rectf, mAngle.get(mAngle.size() - 1), degree[i], true, paint);
                    }
                    if (mPercentage.get(i) > 0) {
                        numberOfSection++;
                    }
                }
                mAngle.add(270f); // End of pie

                // Init name for each section
                paint.setTextSize(20);
                float piece = nScreenW/numberOfSection;
                float[] xStartText = new float[mNames.size()];
                float temp = 0;
                Rect bounds = new Rect();
                for (int i=0; i<mNames.size(); i++) {
                    if (mPercentage.get(i) > 0) {
                        paint.getTextBounds(mNames.get(i), 0, mNames.get(i).length(), bounds);
                        if ((bounds.width() + 25) >= piece) {
                            mNames.set(i, mNames.get(i).substring(0, mNames.get(i).length() * 3 / 4));
                            paint.getTextBounds(mNames.get(i), 0, mNames.get(i).length(), bounds);
                        }
                        xStartText[i] = temp + piece * 0.5f - bounds.width() * 0.5f;
                        temp += piece;
                    }
                }

                // Draw stroke for each section
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.WHITE);
                for (int i = 0; i < mAngle.size()-1; i++) {
                    if (mPercentage.get(i) > 0) {
                        canvas.drawArc(rectf, mAngle.get(i), degree[i], true, paint);
                    }
                }

                // Border
                canvas.drawCircle(xCenter, yCenter, nCircleRadius, paint);

                // Draw annotation text
                paint.setColor(Color.BLACK);
                for (int i = 0; i < mNames.size(); i++) {
                    if (mPercentage.get(i) > 0) {
                        canvas.drawText(mNames.get(i), xStartText[i], rectf.bottom + 50, paint);
                    }
                }
                // Symbol
                paint.setStyle(Paint.Style.FILL);
                for (int i = 0; i < mNames.size(); i++) {
                    if (mPercentage.get(i) > 0) {
                        paint.setColor(mColors.get(i));
                        canvas.drawRect(xStartText[i] - 25, rectf.bottom + 30, xStartText[i] - 5, rectf.bottom + 50, paint);
                    }
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // Find the radius and center point
            float nCircleRadius = (Math.abs(rectf.right) - Math.abs(rectf.left)) * 0.5f;
            float xCenter = rectf.left + nCircleRadius;
            float yCenter = rectf.top + nCircleRadius;

            // Get the coordinate user clicked
            float xCoord = event.getX();
            float yCoord = event.getY();

            // Get the distance from touch point to center point
            float xRadius = xCoord - xCenter;
            float yRadius = yCoord - yCenter;
            float nTouchRadius = (float)Math.sqrt(xRadius*xRadius + yRadius*yRadius);

            // Calculate the degree
            float rad = (float) Math.atan2(yRadius, xRadius);
            float deg = (float) Math.toDegrees(rad); // rad/2pi
            if (deg < -90f) { // if the point is at the IV quarter
                deg += 360;
            }


            // Check if the point is in the circle and which section it belongs to
            if (xCoord > rectf.left && xCoord < rectf.right
                    && yCoord > rectf.top && yCoord < rectf.bottom
                    && nTouchRadius <= nCircleRadius) { // Actually we only need this condition
                for (int i = 0; i < mAngle.size() - 1; i++) {
                    if (deg >= mAngle.get(i) && deg < mAngle.get(i + 1)) {
                        mListener.onPieChartClick(mValues.get(i));
                    }
                }
            }
        }

        return super.onTouchEvent(event);
    }
}
