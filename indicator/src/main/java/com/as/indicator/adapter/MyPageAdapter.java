package com.as.indicator.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.as.indicator.R;

import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2019/7/1.
 * ---------------------------
 */
public class MyPageAdapter extends PagerAdapter {
    private List<String> list;
    private Context mContext;

    public MyPageAdapter(List<String> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = View.inflate(mContext, R.layout.item0, null);

        container.addView(view);
        TextView tv0 = view.findViewById(R.id.tv0);
        tv0.setText(list.get(position));

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
