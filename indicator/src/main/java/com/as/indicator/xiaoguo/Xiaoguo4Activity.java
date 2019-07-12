package com.as.indicator.xiaoguo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.as.indicator.MainActivity;
import com.as.indicator.R;

public class Xiaoguo4Activity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout account_layout;
    private RelativeLayout progress_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiaoguo4);

        account_layout = findViewById(R.id.account_layout);
        progress_layout = findViewById(R.id.progress_layout);
        TextView tvclick = findViewById(R.id.tvclick);
        tvclick.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvclick:
                v.setVisibility(View.INVISIBLE);
                initAnim();

                break;
            default:
                break;
        }
    }


    private void initAnim() {
        AnimatorSet set = new AnimatorSet();

        ValueAnimator animator = ValueAnimator.ofFloat(0, 0);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (Float) animation.getAnimatedValue();
                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) account_layout
                        .getLayoutParams();
                params.leftMargin = (int) value;
                params.rightMargin = (int) value;
                account_layout.setLayoutParams(params);
            }
        });

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(account_layout,
                "scaleX", 1f, 0.5f);
        set.setDuration(1000);
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        set.playTogether(animator, objectAnimator);
        set.start();

        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                progress_layout.setVisibility(View.VISIBLE);
                account_layout.setVisibility(View.INVISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        progressAnimator();
                        Toast.makeText(Xiaoguo4Activity.this, "OVER", Toast.LENGTH_SHORT).show();
                    }
                }, 3000);

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    private void progressAnimator() {
        PropertyValuesHolder animator = PropertyValuesHolder.ofFloat("scaleX",
                0.5f, 1f);
        PropertyValuesHolder animator2 = PropertyValuesHolder.ofFloat("scaleY",
                0.5f, 1f);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(progress_layout,
                animator, animator2);
        objectAnimator.setDuration(1000);
        objectAnimator.setInterpolator(new MyInterpolator());
        objectAnimator.start();
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(Xiaoguo4Activity.this, "It's over", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }
}
