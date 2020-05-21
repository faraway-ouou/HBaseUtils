package com.winks.utils.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDialog;

import com.winks.utils.R;

public class LoadingDialog extends AppCompatDialog {
    private Context mContext;
    private String mContentStr;
    private boolean isShow = true;

    public LoadingDialog(Builder builder) {
        this(builder,builder.mContext);
        init(builder);
    }

    public LoadingDialog(Builder builder, Context context) {
        super(context, R.style.base_dialog_style);
        init(builder);
    }


    public LoadingDialog(Builder builder, Context context, int theme) {
        super(context, theme);
        init(builder);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);
        TextView mMessagTextView = findViewById(R.id.dialog_loading_tv);
        mMessagTextView.setText(mContentStr);
        mMessagTextView.setVisibility(isShow == true? View.VISIBLE:View.GONE);
    }

    private void init(Builder builder) {
        this.mContext = builder.mContext;
        this.mContentStr = builder.mContentStr;
        this.isShow = builder.isShow;
    }

    public static final class Builder {
        private Context mContext;
        private String mContentStr;
        private boolean isShow;

        public Builder(Context mContext) {
            this.mContext = mContext;
        }

        public Builder setMessage(String mContentStr) {
            this.mContentStr = mContentStr;
            return this;
        }

        public Builder setShowMessage(boolean isShow) {
            this.isShow = isShow;
            return this;
        }
        public LoadingDialog build() {
            return new LoadingDialog(this);
        }

    }

}
