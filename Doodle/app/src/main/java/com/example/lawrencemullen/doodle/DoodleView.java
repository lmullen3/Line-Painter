package com.example.lawrencemullen.doodle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by lawrencemullen on 9/10/15.
 */


public class DoodleView extends View{
    public final static int DEFAULT_WIDTH = 25;

    private ArrayList<Line> theLines;
    private int lineWidth = DEFAULT_WIDTH;
    private int redColor = 0;
    private float x1=0;
    private float y1=0;

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        theLines = new ArrayList<Line>();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        theLines.add(new Line(x1 , y1,  event.getX(),event.getY(), lineWidth));
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        for (Line line : theLines) {
            line.drawLine(canvas);
        }
        invalidate();
    }
    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    public int getLineWidth() {
        return lineWidth;
    }
    public void setRedColor(int redColor){
        this.redColor = redColor;
    }
    public int getRedValue(){
        return redColor;
    }


}
