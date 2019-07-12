package com.as.indicator.xiaoguo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.as.indicator.R;
import com.as.indicator.adapter.MyPageAdapter;
import com.as.indicator.other_library.View2.ViewPagerIndicator;

import java.util.ArrayList;
import java.util.List;

public class Xiaoguo2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiaoguo2);

        List<String> list = new ArrayList<String>() {
            {
                for (int i = 0; i < 30; i++) {
                    add(i + "");
                }
            }
        };
        ViewPagerIndicator indicator_default = findViewById(R.id.indicator_default);
        ViewPagerIndicator indicator_circle  = findViewById(R.id.indicator_circle);
        ViewPagerIndicator indicator_line    = findViewById(R.id.indicator_line);
        ViewPagerIndicator indicator_circle_line = findViewById(R.id.indicator_circle_line);
        ViewPagerIndicator indicator_bezier  = findViewById(R.id.indicator_bezier);
        ViewPagerIndicator indicator_spring  = findViewById(R.id.indicator_spring);


        ViewPager vp = findViewById(R.id.vp);


        MyPageAdapter myPageAdapter = new MyPageAdapter(list, this);
        vp.setAdapter(myPageAdapter);

        indicator_default.setViewPager(vp,4);

        indicator_circle.setViewPager(vp,5);
        indicator_circle.setDistance(100);

        indicator_line.setViewPager(vp,6);
        indicator_circle_line.setViewPager(vp,7);

        indicator_bezier.setViewPager(vp,6);
        indicator_bezier.setDistance(160);

        indicator_spring.setViewPager(vp,5);
        indicator_spring.setDistance(160);


    }
}
