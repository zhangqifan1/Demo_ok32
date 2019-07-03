package com.as.indicator.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.as.indicator.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2019/7/1.
 * ---------------------------
 */
public class Adapter_image extends BaseQuickAdapter<Integer, BaseViewHolder> {

    public Adapter_image(int layoutResId, @Nullable List<Integer> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {

        ImageView image = helper.getView(R.id.image);
        image.setImageResource(item);

    }
}
