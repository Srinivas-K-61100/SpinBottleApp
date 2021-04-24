package com.example.spinbottleapp;

import android.app.Activity;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Random;
public class MainActivity extends Activity {
    ImageView iv_bottle;
    Button b_go;
    Random r;
    int angle;
    boolean restart = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_bottle = (ImageView) findViewById(R.id.imageButton);
        b_go = (Button) findViewById(R.id.button);
        r = new Random();
        b_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(restart) {
                    angle = angle % 360;
                    RotateAnimation rotate = new RotateAnimation(angle, 360,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(1000);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());
                    iv_bottle.startAnimation(rotate);
                    b_go.setText("GO");
                    restart = false;
                } else {
                    angle = r.nextInt(3600) + 360;
                    RotateAnimation rotate = new RotateAnimation(0, angle,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(3600);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());
                    iv_bottle.startAnimation(rotate);
                    restart = true;
                    b_go.setText("RESET");
                } }
        });
    }
}