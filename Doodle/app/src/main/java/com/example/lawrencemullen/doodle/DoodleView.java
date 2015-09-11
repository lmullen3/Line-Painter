package com.example.lawrencemullen.doodle;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lawrencemullen on 9/10/15.
 */


public class DoodleView extends View{
    public final static int DEFAULT_WIDTH = 25;

    private ArrayList<Line> theLines;
    private int lineWidth = DEFAULT_WIDTH;

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        theLines = new ArrayList<Line>();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        theLines.add(new Line(event.getX(), event.getY(), lineWidth));
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        for (Line line : theLines) {
            Line.draw(canvas);
        }
        invalidate();
    }


}
