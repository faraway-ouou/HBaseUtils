package com.winks.demo.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ConvertUtils;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.winks.demo.R;
import com.winks.demo.adapter.FoldAdapter;
import com.winks.demo.view.widget.ExpandableTextView;
import com.winks.utils.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DemoActivity extends BaseActivity {
    public static final String PAGE_DATA = "page_data";
    @BindView(R.id.demo_recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.demo_expandable_text_view)
    ExpandableTextView mExpandableTextView;
    @BindView(R.id.navigation_bar_layout_title)
    TextView mNavigationBarLayoutTitle;

    public static void startActivity(Activity activity, String s) {
        Intent intent = new Intent(activity, DemoActivity.class);
        intent.putExtra(DemoActivity.PAGE_DATA, s);
        activity.startActivity(intent);
    }

    private String string = "茫茫的长白大山，浩瀚的原始森林，大山脚下，原始森林环抱中散落着几十户人家的" +
            "一个小山村，茅草房，对面炕，烟筒立在屋后边。在村东头有一个独立的房子，那就是青年点，" +
            "窗前有一道小溪流过。学子在这里吃饭，由这里出发每天随社员去地里干活。干的活要么上山伐" +
            "树，抬树，要么砍柳树毛子开荒种地。在山里，可听那吆呵声：“顺山倒了！”放树谨防回头棒！" +
            "树上的枯枝打到别的树上再蹦回来，这回头棒打人最厉害。";

    @Override
    protected void initView() {
        mNavigationBarLayoutTitle.setText(getIntent().getStringExtra(DemoActivity.PAGE_DATA));
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(mContext);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        mRecyclerView.setLayoutManager(layoutManager);
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        FoldAdapter mFoldAdapter = new FoldAdapter(list, mContext);
        mRecyclerView.setAdapter(mFoldAdapter);
        mExpandableTextView.setMaxLines(3);
        mExpandableTextView.initWidth(ConvertUtils.dp2px(200));
        mExpandableTextView.setCloseText(string);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_demo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.navigation_bar_layout_back_box)
    public void onViewClicked() {
        finish();
    }
}
