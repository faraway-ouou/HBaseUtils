package com.winks.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.winks.demo.R;
import com.winks.utils.base.FoldBaseAdapter;

import java.util.List;

public class FoldAdapter extends FoldBaseAdapter<String,FoldAdapter.ViewHolder> implements View.OnClickListener {

    private static final String MORE_TAG_1 = "...等";
    private static final String MORE_TAG_2 = "个人觉得很赞";
    private String mMoreData ="";
    private List<String> mData;
    public FoldAdapter(List<String> mData, Context mContext) {
        super(mData, mContext);
        this.mData = mData;
        mMoreData = MORE_TAG_1+mData.size()+MORE_TAG_2;
    }

    public void setData(List<String> mData) {
        this.mData = mData;
        mMoreData = MORE_TAG_1+mData.size()+MORE_TAG_2;
        notifyDataSetChanged();
    }
    @Override
    public void onClick(View v) {
        isOpen = ((TextView)v).getText().toString().equals(mMoreData)==true?true:false;
        notifyDataSetChanged();
    }

    @Override
    protected void onBindView(ViewHolder holder, int position) {
        holder.mMore.setOnClickListener(this);
        if (getItemViewType(position) == TYPE_HIDE){
            //显示隐藏数据
            setMoreData(holder,mContext.getString(R.string.pack_up));
        }else if (getItemViewType(position) == TYPE_SEE_MORE){
            setMoreData(holder,mMoreData);
        }else {
        }
    }

    private void setMoreData(ViewHolder holder, String string) {
        holder.mHeadView.setVisibility(View.INVISIBLE);
        holder.mMore.setVisibility(View.VISIBLE);
        holder.mMore.setText(string);
    }

    @Override
    protected ViewHolder onBindViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_fold,parent,false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mMore;
        private final ImageView mHeadView;

        public ViewHolder(View view) {
            super(view);
            mMore = view.findViewById(R.id.item_fold_more);
            mHeadView = view.findViewById(R.id.item_fold_img);
        }
    }

    @Override
    protected int[] getShowMoreItemCount() {
        return new int[]{12,11};
    }
}
