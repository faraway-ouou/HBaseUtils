package com.winks.demo.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.winks.demo.R;
import com.winks.utils.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PasInputActivity extends BaseActivity {
    @BindView(R.id.navigation_bar_layout_title)
    TextView mNavigationBarLayoutTitle;

    public static void startActivity(Activity activity, String data) {
        Intent intent = new Intent(activity, PasInputActivity.class);
        intent.putExtra(ExpandableActivity.PAGE_DATA, data);
        activity.startActivity(intent);
    }

    @Override
    protected void initView() {
        mNavigationBarLayoutTitle.setText(getIntent().getStringExtra(ExpandableActivity.PAGE_DATA));
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_pas_input;
    }

    @OnClick(R.id.navigation_bar_layout_back_box)
    public void onViewClicked() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
