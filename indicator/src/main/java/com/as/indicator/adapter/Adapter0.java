package com.as.indicator.adapter;


import androidx.annotation.Nullable;

import com.as.indicator.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2019/7/1.
 * ---------------------------
 */
public class Adapter0 extends BaseQuickAdapter<String, BaseViewHolder> {

    public Adapter0(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv0, item);
    }
}
