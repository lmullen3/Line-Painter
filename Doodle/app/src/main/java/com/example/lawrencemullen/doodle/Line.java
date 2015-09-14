package com.example.lawrencemullen.doodle;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by lawrencemullen on 9/10/15.
 */
public class Line {

    private float x1, y1, x2,y2;
    private int lineWidth;
    private Paint paint;

    public Line(float firstX, float firstY, float secondX, float secondY,  int lineWidth) {
        this.x1 = firstX;
        this.y1 = firstY;
        this.x2 = secondX;
        this.y2 = secondY;
        this.lineWidth = lineWidth;



   // public setColor( Color redValue, Color blueValue, Color greenValue, Color alphaValue){
        // random color
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        int alpha = (int) (Math.random() * 256);
        paint = new Paint();
        paint.setARGB(alpha, red, green, blue);
    }
    public void drawLine(Canvas canvas){
        canvas.drawLine(x1, y1,x2,y2, paint);
    }

}
