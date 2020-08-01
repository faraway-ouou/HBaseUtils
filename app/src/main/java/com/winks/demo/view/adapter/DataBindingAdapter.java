package com.winks.demo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.LogUtils;
import com.winks.demo.BR;
import com.winks.demo.R;
import com.winks.demo.bean.News;

import java.util.List;

public class DataBindingAdapter extends RecyclerView.Adapter {
    public List<News> mNewsList;
    public Context mContext;
    public DataBindingAdapter(List<News> mNewsList, Context mContext) {
        this.mNewsList = mNewsList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding itemNewsBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_data_binding, parent, false);
        return new ViewHolder(itemNewsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.mItemNewsBinding.setVariable(BR.news,mNewsList.get(position));
            viewHolder.mItemNewsBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding mItemNewsBinding;
        public ViewHolder(ViewDataBinding mItemNewsBinding) {
            super(mItemNewsBinding.getRoot());
            this.mItemNewsBinding = mItemNewsBinding;
        }
    }
}
