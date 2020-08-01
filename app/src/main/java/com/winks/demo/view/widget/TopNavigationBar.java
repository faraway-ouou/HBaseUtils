package com.winks.demo.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.LogUtils;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.winks.demo.R;

/**
 * 标题栏
 */
public class TopNavigationBar extends LinearLayout implements View.OnClickListener {

    private static final int TITLE_CENTER = 0;
    private static final int TITLE_LEFT = 1;
    private static final int TITLE_RIGHT = 2;
    private static final int TITLE_CENTER_VERTICAL = 3;
    private static final int TITLE_CENTER_HORIZONTAL = 4;
    private static final int TITLE_CENTER_LEFT = 5;
    private static final int TITLE_CENTER_RIGHT = 6;
    private View mTopView;
    private boolean mTopViewVisible;
    public Context mContext;
    private Integer mTopViewHeight;
    private RelativeLayout mNavLeftBox;
    private ImageView mNavLeftImg;
    private RelativeLayout mNavRightBox;
    private TextView mNavTitleText;
    private OnClick onClick = null;
    public TopNavigationBar(Context context) {
        super(context, null);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View.inflate(mContext, R.layout.layout_top_navigation_bar, this);
        mTopView = findViewById(R.id.top_navigation_bar_view);
        mNavLeftBox = findViewById(R.id.top_navigation_bar_left_box);
        mNavLeftImg = findViewById(R.id.top_navigation_bar_back_img);
        mNavRightBox = findViewById(R.id.top_navigation_bar_right_box);
        mNavTitleText = findViewById(R.id.top_navigation_bar_title);
        addOnClickListener();
    }

    private void addOnClickListener() {
        if (mNavLeftBox!=null){
            mNavLeftBox.setOnClickListener(this::onClick);
        }
    }

    public TopNavigationBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
        this.mContext = context;
        initView();
        initViewStyle(attrs);
    }

    private void initViewStyle(AttributeSet attrs) {
        TypedArray attributes = mContext.obtainStyledAttributes(attrs, R.styleable.top_navigation_bar);
        setTopViewStyle(attributes);
        setNavLeftBoxStyle(attributes);
        setNavRightBoxStyle(attributes);
        setNavLeftImgStyle(attributes);
        setNavTitleStyle(attributes);
    }

    /**
     * 设置 标题样式
     * @param attributes
     */
    private void setNavTitleStyle(TypedArray attributes) {
        int mTitleGravity = attributes.getInt(R.styleable.top_navigation_bar_titleGravity, 0);
        int mTitleSize = (int) attributes.getDimension(R.styleable.top_navigation_bar_titleSize, (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 18, getResources().getDisplayMetrics()));
        int mTitleColor = attributes.getColor(R.styleable.top_navigation_bar_titleColor,Color.BLACK);
        String mTitle = attributes.getString(R.styleable.top_navigation_bar_title);
        if (mNavTitleText != null) {
            mNavTitleText.setText(mTitle);
            mNavTitleText.setTextSize(mTitleSize);
            mNavTitleText.setTextColor(mTitleColor);
            mNavTitleText.setText(mTitle);
            switch (mTitleGravity) {
                case TITLE_CENTER:
                    mNavTitleText.setGravity(Gravity.CENTER);
                    break;
                case TITLE_LEFT:
                    mNavTitleText.setGravity(Gravity.LEFT);
                    break;
                case TITLE_RIGHT:
                    mNavTitleText.setGravity(Gravity.RIGHT);
                    break;
                case TITLE_CENTER_VERTICAL:
                    mNavTitleText.setGravity(Gravity.CENTER_VERTICAL);
                    break;
                case TITLE_CENTER_HORIZONTAL:
                    mNavTitleText.setGravity(Gravity.CENTER_HORIZONTAL);
                    break;
                case TITLE_CENTER_LEFT:
                    mNavTitleText.setGravity(Gravity.CENTER|Gravity.LEFT);
                    break;
                case TITLE_CENTER_RIGHT:
                    mNavTitleText.setGravity(Gravity.CENTER|Gravity.RIGHT);
                    break;
            }
        }
    }

    private void setNavRightBoxStyle(TypedArray attributes) {
        int mLeftBoxPaddingTop = attributes.getInteger(R.styleable.top_navigation_bar_rightBoxPaddingTop, 0);
        int mLeftBoxPaddingBottom = attributes.getInteger(R.styleable.top_navigation_bar_rightBoxPaddingBottom, 0);
        int mLeftBoxPaddingLeft = attributes.getInteger(R.styleable.top_navigation_bar_rightBoxPaddingLeft, 0);
        int mLeftBoxPaddingRight = attributes.getInteger(R.styleable.top_navigation_bar_rightBoxPaddingRight, 0);
        if (mNavRightBox != null) {
            mNavRightBox.setPadding(mLeftBoxPaddingLeft, mLeftBoxPaddingTop, mLeftBoxPaddingRight, mLeftBoxPaddingBottom);
        }

    }

    /**
     * 设置左边图片样式
     *
     * @param attributes
     */
    private void setNavLeftImgStyle(TypedArray attributes) {
        int mDrawableId = attributes.getResourceId(R.styleable.top_navigation_bar_leftImageSrc, R.mipmap.ic_nav_bar_black_back);
        int mHeight = (int) attributes.getDimension(R.styleable.top_navigation_bar_leftImageHeight, ConvertUtils.dp2px(22));
        int mWidth = (int) attributes.getDimension(R.styleable.top_navigation_bar_leftImageWidth, ConvertUtils.dp2px(22));
        if (mNavLeftImg != null) {
            mNavLeftImg.setImageDrawable(mContext.getDrawable(mDrawableId));
            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) mNavLeftImg.getLayoutParams();
            lp.width = mWidth;
            lp.height = mHeight;
            mNavLeftImg.setLayoutParams(lp);
        }
    }

    /**
     * 设置左边Box样式
     *
     * @param attributes
     */
    private void setNavLeftBoxStyle(TypedArray attributes) {
        int mLeftBoxPaddingTop = attributes.getInteger(R.styleable.top_navigation_bar_leftBoxPaddingTop, 10);
        int mLeftBoxPaddingBottom = attributes.getInteger(R.styleable.top_navigation_bar_leftBoxPaddingBottom, 10);
        int mLeftBoxPaddingLeft = attributes.getInteger(R.styleable.top_navigation_bar_leftBoxPaddingLeft, 10);
        int mLeftBoxPaddingRight = attributes.getInteger(R.styleable.top_navigation_bar_leftBoxPaddingRight, 10);
        if (mNavLeftBox != null) {
            mNavLeftBox.setPadding(mLeftBoxPaddingLeft, mLeftBoxPaddingTop, mLeftBoxPaddingRight, mLeftBoxPaddingBottom);
        }
    }

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    /**
     * 设置top view 样式
     *
     * @param attributes
     */
    private void setTopViewStyle(TypedArray attributes) {
        mTopViewVisible = attributes.getBoolean(R.styleable.top_navigation_bar_topViewVisible, true);
        mTopViewHeight = attributes.getInteger(R.styleable.top_navigation_bar_topViewHeight, -1);
        int mTopViewColor = attributes.getColor(R.styleable.top_navigation_bar_topViewColor, Color.BLACK);
        if (mTopView != null) {
            mTopView.setVisibility(mTopViewVisible == true ? VISIBLE : GONE);
            ViewGroup.LayoutParams lp = mTopView.getLayoutParams();
            lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
            lp.height = mTopViewHeight == -1 ? QMUIStatusBarHelper.getStatusbarHeight(mContext) : mTopViewHeight;
            mTopView.setLayoutParams(lp);
            mTopView.setBackgroundColor(mTopViewColor);
        }

    }

    public TopNavigationBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
        initViewStyle(attrs);
    }

    @Override
    public void onClick(View v) {
        if (onClick == null){return;}
        switch (v.getId()){
            case R.id.top_navigation_bar_left_box:
                onClick.onBackClick(v);
                break;
        }
    }

    public interface OnClick{
        void onBackClick(View view);
    }
}
