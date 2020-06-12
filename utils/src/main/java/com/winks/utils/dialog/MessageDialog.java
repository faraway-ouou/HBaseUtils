package com.winks.utils.dialog;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;

import com.winks.utils.R;

/**
 * 消息类型对话框
 */
public class MessageDialog extends AppCompatDialog {
    private Context mContext;
    private int mGravity = Gravity.CENTER;
    private String mContentText;
    private String mLeftText = "";
    private String mRightText = "";
    private int mLeftTextColor = R.color.colorGray;
    private int mRightTextColor = R.color.colorBlue;
    private OnClickListener listener;
    private View mView;

    private void init(Builder builder) {
        this.mContext = builder.mContext;
        this.mGravity = builder.mGravity;
        this.mContentText = builder.mContentText;
        this.listener = builder.listener;
        this.mLeftText = builder.mLeftText;
        this.mRightText = builder.mRightText;
        this.mLeftTextColor = builder.mLeftTextColor;
        this.mRightTextColor = builder.mRightTextColor;
    }

    public MessageDialog(Builder builder) {
        this(builder, builder.mContext);
        init(builder);
    }

    public MessageDialog(Builder builder, @NonNull Context context) {
        this(builder, context, R.style.base_dialog_style);
        init(builder);
    }

    public MessageDialog(Builder builder, @NonNull Context context, int themeResId) {
        super(context, themeResId);
        init(builder);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = LayoutInflater.from(mContext).inflate(R.layout.dialog_message,null);
        setContentView(mView);
        changeDialogStyle();
        TextView mContentTextView = findViewById(R.id.dialog_message_desc_tv);
        Button cancelBtn = findViewById(R.id.dialog_message_cancel_btn);
        Button confirmBtn = findViewById(R.id.dialog_message_confirm);
        if (!mLeftText.equals("")) {
            cancelBtn.setText(mLeftText);
        }
        if (!mRightText.equals("")) {
            confirmBtn.setText(mRightText);
        }
        cancelBtn.setOnClickListener(v -> {
            if (listener != null) {
                listener.onCancelClick(v, this);
            }
        });
        confirmBtn.setOnClickListener(v -> {
            if (listener != null) {
                listener.onConfirmClick(v, this);
            }
        });
        mContentTextView.setText(mContentText);
        cancelBtn.setTextColor(mContext.getResources().getColor(mLeftTextColor));
        confirmBtn.setTextColor(mContext.getResources().getColor(mRightTextColor));
    }

    /**
     * 设置dialog居下占满屏幕
     */
    public void changeDialogStyle() {
        Window window = getWindow();
        window.setGravity(mGravity);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.FILL_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
    }

    public static final class Builder {
        private Context mContext;
        private int mGravity;
        private String mContentText;
        private OnClickListener listener;
        private String mLeftText;
        private String mRightText;
        private int mLeftTextColor;
        private int mRightTextColor;

        public Builder setLeftTextColor(int mLeftTextColor) {
            this.mLeftTextColor = mLeftTextColor;
            return this;
        }

        public Builder setRightTextColor(int mRightTextColor) {
            this.mRightTextColor = mRightTextColor;
            return this;
        }

        public Builder setLeftText(String mLeftText) {
            this.mLeftText = mLeftText;
            return this;
        }

        public Builder setRightText(String mRightText) {
            this.mRightText = mRightText;
            return this;
        }

        public Builder setContentText(String mContentText) {
            this.mContentText = mContentText;
            return this;
        }

        public Builder setGravity(int mGravity) {
            this.mGravity = mGravity;
            return this;
        }

        public Builder(Context mContext) {
            this.mContext = mContext;
        }

        public Builder addViewOnclick(OnClickListener listener) {
            this.listener = listener;
            return this;
        }

        public MessageDialog build() {
            return new MessageDialog(this);
        }
    }

    public interface OnClickListener {
        void onConfirmClick(View view, AppCompatDialog dialog);

        void onCancelClick(View view, AppCompatDialog dialog);
    }
}
