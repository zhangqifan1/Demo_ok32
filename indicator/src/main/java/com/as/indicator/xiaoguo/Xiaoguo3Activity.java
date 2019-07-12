package com.as.indicator.xiaoguo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PointFEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.as.indicator.MainActivity;
import com.as.indicator.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

public class Xiaoguo3Activity extends AppCompatActivity {


    private ImageView iv_center;
    private ImageView iv0, iv1, iv2, iv3;
    private View lefttop, righttop, leftbottom, rightbottom;
    private int[] parentLocation;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiaoguo3);


        iv_center = findViewById(R.id.iv_center);
        iv0 = findViewById(R.id.iv0);
        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        iv3 = findViewById(R.id.iv3);

        lefttop = findViewById(R.id.lefttop);
        righttop = findViewById(R.id.righttop);
        leftbottom = findViewById(R.id.leftbottom);
        rightbottom = findViewById(R.id.rightbottom);



        Glide.with(this)
                .load(R.drawable.item1)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(iv_center);
        Glide.with(this)
                .load(R.drawable.item2)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(iv0);
        Glide.with(this)
                .load(R.drawable.item3)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(iv1);
        Glide.with(this)
                .load(R.drawable.item4)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(iv2);
        Glide.with(this)
                .load(R.drawable.item5)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(iv3);

        final ViewTreeObserver viewTreeObserver = iv_center.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {
                startvalue(iv0, 180, lefttop);
                startvalue(iv1, 0, righttop);
                startvalue(iv2, 270, leftbottom);
                startvalue(iv3, 90, rightbottom);
            }
        });


    }

    private void startvalue(final ImageView imageView, int startangle, final View endview) {
        //获取控件当前位置
        final int[] startLoc = new int[2];
        imageView.getLocationInWindow(startLoc);

        //获取被围绕控件的起始点
        int[] parentStart = new int[2];
        iv_center.getLocationInWindow(parentStart);


        //获取被围绕坐标的终点
        int[] parentEnd = new int[2];
        int width = iv_center.getWidth();
        int height = iv_center.getHeight();
        parentEnd[0] = parentStart[0] + width;
        parentEnd[1] = parentStart[1] + height;

        //构建椭圆
//        KLog.i((parentStart[0]-deviation)+"   " +(parentStart[1]-deviation)+"   "+(parentEnd[0]+deviation)+"   "+(parentEnd[1]+deviation));
        Path path = new Path();
        //这个是椭圆
//        RectF rectF = new RectF(parentStart[0]-120,parentStart[1]-220,parentEnd[0]+100,parentEnd[1]);//椭圆大小需自己调整
        //这个是 圆
        RectF rectF = new RectF(parentStart[0] - width * 4 / 11, parentStart[1] - height * 3 / 4, parentEnd[0] + width / 9, parentEnd[1] - height / 3 + 20);//椭圆大小需自己调整
        path.addArc(rectF, startangle, 360);

        //设置椭圆倾斜度数
        Matrix matrix = new Matrix();
//        matrix.setRotate(-14,(parentStart[0]+parentEnd[0])/2,(parentStart[1]+parentEnd[1])/2);
        matrix.setRotate(0, (parentStart[0] + parentEnd[0]) / 2, (parentStart[1] + parentEnd[1]) / 2);
        path.transform(matrix);

        //pathMeasure用来计算显示坐标
        final PathMeasure pathMeasure = new PathMeasure(path, true);

        //属性动画加载
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, pathMeasure.getLength());

        //设置动画时长
        valueAnimator.setDuration(10000);

        //加入差值器
        valueAnimator.setInterpolator(new LinearInterpolator());

        //设置无限次循环
        valueAnimator.setRepeatCount(0);

        final float[] mCurrentPosition = new float[2];

        //添加监听
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获取当前位置
                float value = (float) animation.getAnimatedValue();
                //boolean getPosTan(float distance, float[] pos, float[] tan) ：
                //传入一个距离distance(0<=distance<=getLength())，然后会计算当前距
                // 离的坐标点和切线，pos会自动填充上坐标
                pathMeasure.getPosTan(value, mCurrentPosition, null);
                //设置视图坐标
                imageView.setX(mCurrentPosition[0]);
                imageView.setY(mCurrentPosition[1]);

            }
        });
        valueAnimator.start();
    }
}