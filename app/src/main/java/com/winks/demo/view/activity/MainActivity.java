package com.winks.demo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.winks.demo.R;
import com.winks.utils.base.BaseActivity;
import com.winks.utils.dialog.MessageDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    @BindView(R.id.navigation_bar_layout_back_box)
    RelativeLayout mNavigationBarLayoutBackBox;
    private long exitTime = 0;
    private MessageDialog mMessageDialog;

    private void initMsgDialog() {
        mMessageDialog = new MessageDialog.Builder(mContext)
                .setLeftText(getResources().getString(R.string.cancel))
                .setRightText(getResources().getString(R.string.confirm))
                .setContentText(getResources().getString(R.string.out_login_tag))
                .setLeftTextColor(R.color.colorBlue)
                .setRightTextColor(R.color.colorBlue)
                .addViewOnclick(new MessageDialog.OnClickListener() {
                    @Override
                    public void onConfirmClick(View view, AppCompatDialog dialog) {

                        dialog.dismiss();
                    }

                    @Override
                    public void onCancelClick(View view, AppCompatDialog dialog) {
                        dialog.dismiss();
                    }
                }).build();
    }

    @Override
    protected void initView() {
        initMsgDialog();
        mNavigationBarLayoutBackBox.setVisibility(View.INVISIBLE);
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(RecyclerView.VERTICAL);

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    /**
     * 在按一次退出程序
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                ToastUtils.showShort(getResources().getString(R.string.press_exit_again));
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @OnClick({R.id.mine_folding_btn, R.id.mine_input_pas_btn,R.id.mine_data_binding_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mine_folding_btn:
                ExpandableActivity.startActivity(this, getResources().getString(R.string.folding_case));
                break;
            case R.id.mine_input_pas_btn:
                PasInputActivity.startActivity(this, getResources().getString(R.string.input_pas));
                break;
            case R.id.mine_data_binding_btn:
                startActivity(new Intent(this,DataBindingActivity.class));
                break;
        }
    }
}
