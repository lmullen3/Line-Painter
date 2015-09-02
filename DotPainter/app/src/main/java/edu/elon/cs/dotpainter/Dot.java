package edu.elon.cs.dotpainter;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * A single dot on the screen.
 *
 * @author J. Hollingsworth and CSC 303 - Fall 2015
 */
public class Dot {

    private final int RADIUS = 50;

    private float x, y;
    private Paint paint;

    public Dot(float x, float y) {
        this.x = x;
        this.y = y;

        // random color
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        int alpha = (int) (Math.random() * 256);
        paint = new Paint();
        paint.setARGB(alpha, red, green, blue);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(x, y, RADIUS, paint);
    }

}
