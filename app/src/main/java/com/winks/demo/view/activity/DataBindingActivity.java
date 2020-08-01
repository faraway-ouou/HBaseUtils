package com.winks.demo.view.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.winks.demo.R;
import com.winks.demo.bean.Feed;
import com.winks.demo.bean.News;
import com.winks.demo.databinding.ActivityDataBindingBinding;
import com.winks.demo.mvvm.NewsContract;
import com.winks.demo.mvvm.NewsPresenter;
import com.winks.demo.mvvm.NewsViewModel;
import com.winks.demo.request.base.RetrofitException;
import com.winks.demo.view.adapter.DataBindingAdapter;
import com.winks.demo.view.widget.TopNavigationBar;
import com.winks.utils.base.BaseMVPActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class DataBindingActivity extends AppCompatActivity implements TopNavigationBar.OnClick {

    RecyclerView mRecyclerView;
    private ActivityDataBindingBinding mDataBindingUtil;
    public List<News> mNewsList = new ArrayList<>();
    public DataBindingAdapter mDataBindingAdapter;
    private TopNavigationBar mTopNavigationBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QMUIStatusBarHelper.translucent(this);
        QMUIStatusBarHelper.setStatusBarLightMode(this);
        mDataBindingUtil = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        mRecyclerView = findViewById(R.id.data_binding_recycler_view);
        mTopNavigationBar = findViewById(R.id.data_binding_top_navigation_bar);
        mTopNavigationBar.setOnClick(this);
        NewsViewModel newsViewModel = new NewsViewModel(this);
        mDataBindingUtil.setViewModel(newsViewModel);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        mDataBindingAdapter = new DataBindingAdapter(mNewsList,this);
        mRecyclerView.setAdapter(mDataBindingAdapter);
        newsViewModel.loadNews();
    }

    @Override
    public void onBackClick(View view) {
        finish();
    }
}
