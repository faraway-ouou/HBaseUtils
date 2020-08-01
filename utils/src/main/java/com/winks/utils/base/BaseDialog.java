package com.winks.utils.base;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;

import com.winks.utils.R;

import butterknife.ButterKnife;


public abstract class BaseDialog extends AppCompatDialog {
    public Context mContext;

    public BaseDialog(@NonNull Context context) {
        this(context, R.style.base_dialog_style);
        this.mContext = context;
    }

    public BaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.mContext = context;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        onDialogStyle();
        initView();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    public void onDialogStyle() {
        Window window = getWindow();
        window.setGravity(gravity());
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = width();
        lp.height = height();
        window.setAttributes(lp);
    }

    protected int height() {
        return WindowManager.LayoutParams.FILL_PARENT;
    }
    protected int width() {
        return WindowManager.LayoutParams.FILL_PARENT;
    }

    protected int gravity() {
        return Gravity.CENTER;
    }

    @Override
    public void setOnDismissListener(@Nullable OnDismissListener listener) {
        super.setOnDismissListener(listener);
    }
}

