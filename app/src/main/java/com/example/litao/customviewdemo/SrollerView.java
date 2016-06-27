package com.example.litao.customviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.Scroller;

public class SrollerView extends Button {
    private Scroller mSroller = new Scroller(getContext());
    public SrollerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SrollerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void smoothScrollTo(int destX, int destY){
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int deltaX = destX - scrollX;
        int deltaY = destY - scrollY;
        //slow scroll to destX and destY
        mSroller.startScroll(scrollX,scrollY,deltaX,deltaY,5000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mSroller.computeScrollOffset()){
            scrollTo(mSroller.getCurrX(),mSroller.getCurrY());
            postInvalidate();
        }
    }
}
