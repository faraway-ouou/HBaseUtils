package com.winks.demo.view.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.winks.demo.R;
import com.winks.demo.adapter.MianAdapter;
import com.winks.utils.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    @BindView(R.id.main_recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.navigation_bar_layout_back_box)
    RelativeLayout mNavigationBarLayoutBackBox;
    private List<String> mList = new ArrayList<>();
    private long exitTime = 0;

    @Override
    protected void initView() {
        mNavigationBarLayoutBackBox.setVisibility(View.INVISIBLE);
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mList.add("案例");
        mList.add("仿支付密码输入框");
        MianAdapter adapter = new MianAdapter(R.layout.item_main, mList);
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
        adapter.setOnItemChildClickListener((adapter1, view, position) -> {
            switch (position) {
                case 1:
                    PasInputActivity.startActivity(MainActivity.this, mList.get(position));
                    break;
                default:
                    DemoActivity.startActivity(MainActivity.this, mList.get(position));
                    break;

            }
        });
        mRecyclerView.setAdapter(adapter);
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

    @OnClick(R.id.main_btn)
    public void onViewClicked() {
        LogUtils.e("点击："+TimeUtils.millis2String(System.currentTimeMillis()));
    }
}
