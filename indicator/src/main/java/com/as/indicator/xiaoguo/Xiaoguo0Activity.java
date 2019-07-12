package com.as.indicator.xiaoguo;

import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.as.indicator.R;
import com.as.indicator.adapter.Adapter0;
import com.as.indicator.adapter.MyPageAdapter;
import com.as.indicator.other_library.View0.ScrollingPagerIndicator;

import java.util.ArrayList;
import java.util.List;

public class Xiaoguo0Activity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiaoguo0);

        //https://github.com/TinkoffCreditSystems/ScrollingPagerIndicator  当前  小 - 大 - 小
        //https://github.com/intik/overflow-pager-indicator?utm_source=androidweekly.io&utm_medium=website    这个比上面的要细一些  小 中 大 中 小
        // https://github.com/hrskrs/InstaDotView?utm_source=androidweekly.io&utm_medium=website   更胜一筹
        /***************Vp***************/

        ViewPager vp = findViewById(R.id.vp);
        List<String> list = new ArrayList<String>() {
            {
                for (int i = 0; i < 30; i++) {
                    add(i + "");
                }
            }
        };

        MyPageAdapter myPageAdapter = new MyPageAdapter(list, this);
        vp.setAdapter(myPageAdapter);

        ScrollingPagerIndicator spi = findViewById(R.id.spi);
        spi.attachToPager(vp);

        RecyclerView rv = findViewById(R.id.rv);
        ScrollingPagerIndicator spi1 = findViewById(R.id.spi1);
        Adapter0 adapter0 = new Adapter0(R.layout.item0, list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv.setAdapter(adapter0);
        rv.setLayoutManager(linearLayoutManager);
        spi1.attachToRecyclerView(rv);


    }
}
