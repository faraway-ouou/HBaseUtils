package com.winks.demo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    @Override
    protected void initView() {
        mNavigationBarLayoutBackBox.setVisibility(View.INVISIBLE);
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mList.add("案例");
        mList.add("仿支付密码输入框");
        MianAdapter adapter = new MianAdapter(R.layout.item_main, mList);
        adapter.setOnItemChildClickListener((adapter1, view, position) -> {
            switch (position) {
                case 1:
                    PasInputActivity.startActivity(MainActivity.this,mList.get(position));
                    break;
                default:
                    DemoActivity.startActivity(MainActivity.this,mList.get(position));
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


}
