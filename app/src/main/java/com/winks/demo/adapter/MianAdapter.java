package com.winks.demo.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.winks.demo.R;

import java.util.List;

public class MianAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public MianAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        helper.setText(R.id.item_main_tv,item).addOnClickListener(R.id.item_main_box);
    }
}
