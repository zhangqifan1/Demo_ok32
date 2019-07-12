package com.as.indicator.xiaoguo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.as.indicator.R;
import com.as.indicator.widgt.AnimationButton;

public class Xiaoguo5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiaoguo5);
        final AnimationButton ab_btn = findViewById(R.id.ab_btn);

        ab_btn.setAnimationButtonListener(new AnimationButton.AnimationButtonListener() {
            @Override
            public void onClickListener() {
                ab_btn.start();
            }

            @Override
            public void animationFinish() {
                Toast.makeText(Xiaoguo5Activity.this,"动画执行完毕",Toast.LENGTH_SHORT).show();
//                finish();
                ab_btn.reset();
            }
        });


    }
}
