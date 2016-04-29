package com.syl.sugar.view.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by syl on 16/3/19.
 */
public class SimpleDrawingView extends View {

    private int mPaintColor = Color.BLACK;
    private Paint mPaint;
//    private List<Point> mPoints;
    private Path mPath = new Path();

    public SimpleDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        for(Point point : mPoints) {
//            canvas.drawCircle(point.x, point.y, 10, mPaint);
//        }
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
//        mPoints.add(new Point(Math.round(touchX), Math.round(touchY)));

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // Starts a new line in the path
                mPath.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                // Draws line between last point and this point
                mPath.lineTo(touchX, touchY);
                break;
            default:
                return false;
        }

        postInvalidate();
        return true;  // Indicate we've consumed the touch
    }

    private void initPaint() {
        mPaint = new Paint();
//        mPoints = new ArrayList<>();

        mPaint.setAntiAlias(true);
        mPaint.setColor(mPaintColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
    }
}
