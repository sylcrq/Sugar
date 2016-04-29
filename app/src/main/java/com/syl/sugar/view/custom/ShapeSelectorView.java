package com.syl.sugar.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.syl.sugar.R;

/**
 * Defining Custom Views
 *
 * 1. Drawing - Control the rendering of the view on screen visually by overriding the onDraw method.
 * <p>2. Interaction - Control the ways the user can interact with the view with the onTouchEvent and gestures.
 * <p>3. Measurement - Control the content dimensions of the view on screen by overriding the onMeasure method.
 * <p>4. Attributes - Defining custom XML attributes for your view and using them to control behavior with TypedArray
 * <p>5. Persistence - Storing and restoring state on configuration changes to avoid losing the state with onSaveInstanceState and onRestoreInstanceState
 *
 * Created by shenyunlong on 3/21/16.
 */
public class ShapeSelectorView extends View {

    private String[] mShapeValues = {"square", "circle"};
    private int mCurrentShapeIndex = 0;

    private int mShapeColor;
    private boolean mDisplayShapeName;

    private int mShapeWidth = 100;
    private int mShapeHeight = 100;
    private int mTextXOffset = 0;
    private int mTextYOffset = 30;

    private Paint mPaint;

    public ShapeSelectorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttributes(attrs);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String shapeSelected = mShapeValues[mCurrentShapeIndex];

        if(shapeSelected.equals("square")) {
            canvas.drawRect(0, 0, mShapeWidth, mShapeHeight, mPaint);
        } else if(shapeSelected.equals("circle")) {
            canvas.drawCircle(mShapeWidth/2, mShapeHeight/2, mShapeWidth/2, mPaint);
        }

        if(mDisplayShapeName) {
            canvas.drawText(shapeSelected, 0 + mTextXOffset, mShapeHeight + mTextYOffset, mPaint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int contentWidth = mShapeWidth;
        int minw = contentWidth + getPaddingLeft() + getPaddingRight();
        int w = resolveSizeAndState(minw, widthMeasureSpec, 0);

        int textPadding = 10;
        int contentHeight = mShapeHeight;
        int minh = contentHeight + getPaddingTop() + getPaddingBottom();
        if(mDisplayShapeName) {
            minh += mTextYOffset + textPadding;
        }
        int h = resolveSizeAndState(minh, heightMeasureSpec, 0);

        // Calling this method determines the measured width and height
        // Retrieve with getMeasuredWidth or getMeasuredHeight methods later
        setMeasuredDimension(w, h);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = super.onTouchEvent(event);

        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            mCurrentShapeIndex = (mCurrentShapeIndex + 1) % mShapeValues.length;
            postInvalidate();
            return true;
        }

        return result;
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();

        // Store base view state
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        // Save our custom view state to bundle
        bundle.putInt("currentShapeIndex", mCurrentShapeIndex);

        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {

        if(state instanceof Bundle) {
            Bundle bundle = (Bundle) state;

            // Load back our custom view state
            mCurrentShapeIndex = bundle.getInt("currentShapeIndex");
            // Load base view state back
            state = bundle.getParcelable("instanceState");
        }

        super.onRestoreInstanceState(state);
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(mShapeColor);
        mPaint.setTextSize(30);
    }

    private void initAttributes(AttributeSet attrs) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.ShapeSelectorView, 0, 0);

        try {
            mShapeColor = a.getColor(R.styleable.ShapeSelectorView_shapeColor, Color.BLACK);
            mDisplayShapeName = a.getBoolean(R.styleable.ShapeSelectorView_displayShapeName, false);
        } finally {
            // TypedArray objects are shared and must be recycled.
            a.recycle();
        }
    }

    public boolean isDisplayShapeName() {
        return mDisplayShapeName;
    }

    public void setDisplayShapeName(boolean displayShapeName) {
        mDisplayShapeName = displayShapeName;
        invalidate();
        requestLayout();
    }

    public int getShapeColor() {
        return mShapeColor;
    }

    public void setShapeColor(int shapeColor) {
        mShapeColor = shapeColor;
        invalidate();
        requestLayout();
    }
}
