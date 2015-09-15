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
    private int alphaValue = 0;
    private int redValue = 0;
    private int greenValue = 0;
    private int blueValue = 0;
    public final static int DEFAULT_COLOR = Color.argb(250,10,0,0);
    public final static int DEFAULT_WIDTH = 60;
    private ArrayList<Line> theLines;
    private int lineWidth = DEFAULT_WIDTH;
    private int lineColor = DEFAULT_COLOR;
    private float x1=0;
    private float y1=0;
    private float x2 = 0;
    private float y2 = 0;

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        theLines = new ArrayList<Line>();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            x1 = event.getX();
            y1 = event.getY();

        } else {
            x1=x2;
            y1=y2;
            x2 = event.getX();
            y2 = event.getY();


        }

        theLines.add(new Line(x1, y1, x2,y2, lineWidth));
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
    public void setColor(int color){
        this.lineColor = color;
    }
    public int getColor(){
        return this.lineColor;
    }


}
