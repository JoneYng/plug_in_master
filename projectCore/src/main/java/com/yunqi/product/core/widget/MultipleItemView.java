package com.yunqi.product.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yunqi.product.core.R;
import com.yunqi.product.core.util.PxUtils;

import butterknife.ButterKnife;

/**
 * @author zhouxiang
 * @package com.yunqi.product.core.widget
 * @fileName MultipleItemView
 * @date or  2019/4/19 下午4:33
 * @describe TODO
 */
public class MultipleItemView extends LinearLayout {

    RelativeLayout rlLayout;
    ImageView ivLeft;

    TextView tvLeft;

    ImageView ivRight;

    TextView tvRight;

    EditText edtText;

    LinearLayout layout;

    LinearLayout content;

    View topLine;

    View bottomLine;

    private int leftTextColor = Color.BLACK;
    private int rightTextColor = Color.GRAY;
    private int leftIconResource = R.mipmap.ic_launcher;
    private int rightIconResource = R.mipmap.icon_more;
    private String leftText = "";
    private String rightTex = "";
    private boolean showTopLine = true;
    private boolean showBottomLine = true;
    private boolean showLeftIcon = true;
    private boolean showRightIcon = true;
    private boolean showEditText = false;

    public MultipleItemView(Context context) {
        this(context, null);
    }

    public MultipleItemView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public MultipleItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View contentView= LayoutInflater.from(getContext()).inflate(R.layout.layout_multiple_item, this);
        ButterKnife.bind(this,contentView);

        rlLayout=(RelativeLayout)findViewById(R.id.rl_layout);
        ivLeft=(ImageView)findViewById(R.id.iv_left);
        tvLeft=(TextView)findViewById(R.id.tv_left);
        ivRight=(ImageView)findViewById(R.id.iv_right);
        tvRight=(TextView)findViewById(R.id.tv_right);
        edtText=(EditText)findViewById(R.id.edt_text);
        layout=(LinearLayout)findViewById(R.id.ll_right);
        content=(LinearLayout)findViewById(R.id.rl_content);
        topLine=(View)findViewById(R.id.line_top);
        bottomLine=(View)findViewById(R.id.line_bottom);



        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MultipleItemView);
        leftTextColor = a.getColor(R.styleable.MultipleItemView_leftTextColor, leftTextColor);
        rightTextColor = a.getColor(R.styleable.MultipleItemView_rightTextColor, rightTextColor);
        leftIconResource = a.getResourceId(R.styleable.MultipleItemView_leftIcon, leftIconResource);
        rightIconResource = a.getResourceId(R.styleable.MultipleItemView_rightIcon, rightIconResource);
        leftText = a.getString(R.styleable.MultipleItemView_leftText);
        rightTex = a.getString(R.styleable.MultipleItemView_rightText);
        showTopLine = a.getBoolean(R.styleable.MultipleItemView_showTopLine, showTopLine);
        showBottomLine = a.getBoolean(R.styleable.MultipleItemView_showBottomLine, showBottomLine);
        showLeftIcon = a.getBoolean(R.styleable.MultipleItemView_showLeftIcon, showLeftIcon);
        showRightIcon = a.getBoolean(R.styleable.MultipleItemView_showRightIcon, showRightIcon);
        showEditText = a.getBoolean(R.styleable.MultipleItemView_showEdtText, showEditText);
        a.recycle();
        init();
    }

    private void init() {

        setLeftIconResource(leftIconResource);
        setRightIconResource(rightIconResource);
        setLeftText(leftText);
        setRightText(rightTex);
        setShowLeftIcon(showLeftIcon);
        setShowRightIcon(showRightIcon);
        setShowTopLine(showTopLine);
        setShowBottomLine(showBottomLine);
        setShowEditText(showEditText);
        tvLeft.setTextColor(leftTextColor);
        edtText.setTextColor(rightTextColor);
        tvRight.setTextColor(rightTextColor);

        //如果手动设置了背景 则赋值给layout 否则设置默认颜色
        Drawable background = getBackground();
        if (background != null) {
            rlLayout.setBackground(background);
        } else {
            rlLayout.setBackgroundColor(Color.WHITE);
        }
    }

    /**
     * 设置是否显示EditText
     *
     * @param show text
     * @return MultifunctionalItemView
     */
    public MultipleItemView setShowEditText(boolean show) {
        if (show) {
            edtText.setVisibility(VISIBLE);
            tvRight.setVisibility(GONE);
        }
        return this;
    }

    /**
     * 设置上面线是否显示
     *
     * @param show text
     * @return MultifunctionalItemView
     */
    public MultipleItemView setShowTopLine(boolean show) {
        topLine.setVisibility(show ? VISIBLE : GONE);
        return this;
    }

    /**
     * 设置下面线是否显示
     *
     * @param show text
     * @return MultifunctionalItemView
     */
    public MultipleItemView setShowBottomLine(boolean show) {
        bottomLine.setVisibility(show ? VISIBLE : GONE);
        return this;
    }

    /**
     * 设置左边文字
     *
     * @param text text
     * @return MultifunctionalItemView
     */
    public MultipleItemView setLeftText(String text) {
        tvLeft.setText(text);
        return this;
    }

    /**
     * 设置左边文字颜色
     *
     * @param color 颜色
     * @return MultifunctionalItemView
     */
    public MultipleItemView setLeftTextColorResource(int color) {
        tvLeft.setTextColor(getResources().getColor(color));
        return this;
    }

    /**
     * 设置左边文字大小
     *
     * @param size 大小
     * @return MultifunctionalItemView
     */
    public MultipleItemView setLeftTextSize(int size) {
        tvLeft.setTextSize(size);
        return this;
    }

    /**
     * 设置右边文字
     *
     * @param text text
     * @return MultifunctionalItemView
     */
    public MultipleItemView setRightText(String text) {
        tvRight.setText(text);
        edtText.setText(text);
        return this;
    }

    /**
     * 设置右边文字颜色
     *
     * @param color 颜色
     * @return MultifunctionalItemView
     */
    public MultipleItemView setRightTextColorResource(int color) {
        tvRight.setTextColor(getResources().getColor(color));
        edtText.setTextColor(getResources().getColor(color));
        return this;
    }

    /**
     * 设置右边文字大小
     *
     * @param size 大小
     * @return MultifunctionalItemView
     */
    public MultipleItemView setRightTextSize(int size) {
        tvRight.setTextSize(size);
        edtText.setTextScaleX(size);
        return this;
    }

    /**
     * 设置左边Icon Margin
     *
     * @param left   左
     * @param top    上
     * @param right  右
     * @param bottom 下
     * @return MultifunctionalItemView
     */
    public MultipleItemView setLeftIconMargin(int left, int top, int right, int bottom) {
        LayoutParams layoutParams = (LayoutParams) ivLeft.getLayoutParams();
        layoutParams.setMargins(PxUtils.dp2px(getContext(), left), PxUtils.dp2px(getContext(), top),
                PxUtils.dp2px(getContext(), right), PxUtils.dp2px(getContext(), bottom));
        return this;
    }

    /**
     * 设置右边Icon Margin
     *
     * @param left   左
     * @param top    上
     * @param right  右
     * @param bottom 下
     * @return MultifunctionalItemView
     */
    public MultipleItemView setRightIconMargin(int left, int top, int right, int bottom) {
        LayoutParams layoutParams = (LayoutParams) ivRight.getLayoutParams();
        layoutParams.setMargins(PxUtils.dp2px(getContext(), left), PxUtils.dp2px(getContext(), top),
                PxUtils.dp2px(getContext(), right), PxUtils.dp2px(getContext(), bottom));
        return this;
    }


    /**
     * 是否显示左边图标
     *
     * @param show show
     * @return MultifunctionalItemView
     */
    public MultipleItemView setShowLeftIcon(boolean show) {
        ivLeft.setVisibility(show ? VISIBLE : GONE);
        return this;
    }

    /**
     * 设置左边图标图片
     *
     * @param resId 资源ID
     * @return MultifunctionalItemView
     */
    public MultipleItemView setLeftIconResource(int resId) {
        this.ivLeft.setBackgroundResource(resId);
        return this;
    }

    /**
     * 设置左边图标大小
     *
     * @param width  宽
     * @param height 高
     * @return MultifunctionalItemView
     */
    public MultipleItemView setLeftIconSize(int width, int height) {
        LayoutParams lp = new LayoutParams(PxUtils.dp2px(getContext(), width),
                PxUtils.dp2px(getContext(), height));
        lp.setMargins(0, 0, 4, 0);
        ivLeft.setLayoutParams(lp);
        return this;
    }


    /**
     * 是否显示右边图标
     *
     * @param show show
     * @return MultifunctionalItemView
     */
    public MultipleItemView setShowRightIcon(boolean show) {
        ivRight.setVisibility(show ? VISIBLE : GONE);
        return this;
    }

    /**
     * 设置右边图标资源
     *
     * @param resId 资源ID
     * @return MultifunctionalItemView
     */
    public MultipleItemView setRightIconResource(int resId) {
        this.ivRight.setBackgroundResource(resId);
        return this;
    }

    /**
     * 设置右边图标大小
     *
     * @param width  宽
     * @param height 高
     * @return MultifunctionalItemView
     */
    public MultipleItemView setRightIconSize(int width, int height) {
        ivRight.setLayoutParams(new LayoutParams(PxUtils.dp2px(getContext(), width),
                PxUtils.dp2px(getContext(), height)));
        return this;
    }

    /**
     * 设置父窗体 padding
     *
     * @param left   左
     * @param top    上
     * @param right  右
     * @param bottom 下
     * @return MultifunctionalItemView
     */
    public MultipleItemView setContentPadding(int left, int top, int right, int bottom) {
        content.setPadding(PxUtils.dp2px(getContext(), left), PxUtils.dp2px(getContext(), top),
                PxUtils.dp2px(getContext(), right), PxUtils.dp2px(getContext(), bottom));
        return this;
    }

    /**
     * 设置父窗体 padding
     *
     * @param padding padding
     * @return MultifunctionalItemView
     */
    public MultipleItemView setContentPadding(int padding) {
        return setContentPadding(padding, padding, padding, padding);
    }

    /**
     * 设置右边View
     *
     * @param view view
     * @return MultifunctionalItemView
     */
    public MultipleItemView setRightView(View view) {
        this.layout.removeAllViews();
        this.layout.addView(view);
        return this;
    }

    /**
     * 当在输入模式下 返回输入框的值
     *
     * @return String
     */
    public String getRightTex() {
        return edtText.getText().toString().trim();
    }
}
