package com.example.lawrencemullen.doodle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

public class SetColorActivity extends AppCompatActivity {
    private SeekBar AlphaBar;
    private SeekBar RedBar;
    private SeekBar GreenBar;
    private SeekBar BlueBar;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_color);

        Intent data = getIntent();
        int color = data.getIntExtra("alpha", DoodleView.DEFAULT_COLOR);
        AlphaBar = (SeekBar) findViewById(R.id.alpha);
        RedBar = (SeekBar) findViewById(R.id.red);
        GreenBar = (SeekBar) findViewById(R.id.green);
        BlueBar = (SeekBar) findViewById(R.id.blue);


        AlphaBar.setProgress(0);
        RedBar.setProgress(0);
        GreenBar.setProgress(0);
        BlueBar.setProgress(0);


        AlphaBar.setOnSeekBarChangeListener(seekBarListener);
        RedBar.setOnSeekBarChangeListener(seekBarListener);
        GreenBar.setOnSeekBarChangeListener(seekBarListener);
        BlueBar.setOnSeekBarChangeListener(seekBarListener);

        imageView = (ImageView) findViewById(R.id.imageView);
        updateImageView();
    }
    void updateImageView() {
        // draw a white circle the size of the seekBar
        Paint p = new Paint();
        p.setColor(Color.argb(AlphaBar.getProgress(),RedBar.getProgress(),GreenBar.getProgress(), BlueBar.getProgress()));
        Bitmap bitmap = Bitmap.createBitmap(250, 250, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawCircle(125, 125,125, p);
        imageView.setImageBitmap(bitmap);
    }

    SeekBar.OnSeekBarChangeListener seekBarListener =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    updateImageView();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };
    public void onCancelClick(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void onOKClick(View view) {
        // send back the new width size
        Intent data = new Intent();
        data.putExtra("alpha", AlphaBar.getProgress());
        data.putExtra("red", RedBar.getProgress());
        data.putExtra("blue", BlueBar.getProgress());
        data.putExtra("green", GreenBar.getProgress());


        setResult(RESULT_OK, data);
        finish();
    }

}


