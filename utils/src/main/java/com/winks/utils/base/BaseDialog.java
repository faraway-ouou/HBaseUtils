package com.winks.utils.base;

import android.content.Context;
import android.os.Bundle;
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
        changeDialogStyle();
        initView();
    }

    protected abstract int getLayoutId();
    protected abstract void initView();
    /**
     * 设置dialog居下占满屏幕
     */
    public void changeDialogStyle() {
        Window window = getWindow();
        window.setGravity(getGravity());
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.FILL_PARENT;
        lp.height = WindowManager.LayoutParams.FILL_PARENT;
        window.setAttributes(lp);
    }

    protected abstract int getGravity();
    @Override
    public void setOnDismissListener(@Nullable OnDismissListener listener) {
        super.setOnDismissListener(listener);
    }
}

