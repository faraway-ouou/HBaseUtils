package com.winks.demo.view;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * 可折叠 Adapter
 * @param <K>
 * @param <T>
 */
public abstract class FoldBaseAdapter<K,T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    protected final static int TYPE_NORMAL = 0;//正常条目
    protected final static int TYPE_SEE_MORE = 1;//查看更多
    protected final static int TYPE_HIDE = 2;//收起
    private static final int TYPE_SHOW_LOOK_MORE_COUNT = 3;
    private static final int TYPE_SHOW_LOOK_MORE_COUNT_2 = 2;
    public boolean isOpen = false;
    private List<K> mData ;

    public void setOpen(boolean open) {
        isOpen = open;
        notifyDataSetChanged();
    }

    public Context mContext;
    public FoldBaseAdapter(List<K> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public void onBindViewHolder(@NonNull T holder, int position) {
        onBindView(holder,position);
    }

    protected abstract void onBindView(T holder, int position);

    @NonNull
    @Override
    public T onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return onBindViewHolder(parent,viewType);
    }

    protected abstract T onBindViewHolder(ViewGroup parent, int viewType);

    @Override
    public int getItemViewType(int position) {
        if (mData.size()<getShowMoreItemCount()[0]){
            return TYPE_NORMAL;
        }
        if (isOpen){
            if (position == mData.size()){
                return TYPE_HIDE;
            }else {
                return TYPE_NORMAL;
            }
        }else {
            if (position == getShowMoreItemCount()[1]){
                return TYPE_SEE_MORE;
            }else {
                return TYPE_NORMAL;
            }
        }
    }

    /**
     * 获取最多显示Item数
     * @return
     */
    protected  int[] getShowMoreItemCount(){
        return new int[]{TYPE_SHOW_LOOK_MORE_COUNT,TYPE_SHOW_LOOK_MORE_COUNT_2};
    };

    @Override
    public int getItemCount() {
        int mItemCount = 0;
        if (mData == null || mData.size() == 0) {
            mItemCount = 0;
        }
        if (mData.size() > getShowMoreItemCount()[0]) {
            //若现在是展开状态 条目数量需要+1 "收起"条目
            if (isOpen) {
                mItemCount =  mData.size() + 1;
            } else {
                mItemCount =  getShowMoreItemCount()[0];
            }
        } else if (mData.size() == getShowMoreItemCount()[0]) {
            if (isOpen) {
                mItemCount =  mData.size() + 1;
            } else {
                mItemCount = mData.size();
            }
        } else {
            mItemCount =  mData.size();
        }
        return mItemCount;
    }

}
