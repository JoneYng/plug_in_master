package com.yunqixinxi.main;

import android.view.View;
import android.widget.TextView;

import com.yunqi.product.core.base.vp.activity.BaseActivity;
import com.yunqi.product.core.bean.home.AncientPoetry;
import com.yunqixinxi.main.contract.HomeContract;
import com.yunqixinxi.main.presenter.HomePresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<HomePresenter> implements HomeContract.View {

    @BindView(R2.id.tv_main_text_view)
    TextView tvMainTextView;

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity_main;
    }

    HomePresenter mHomePresenter;

    @Override
    protected void initView() {
    }

    @Override
    protected void initListenerAddData() {
        mHomePresenter = new HomePresenter(this);
    }

    @Override
    protected HomePresenter getPresenter() {
        return mHomePresenter;
    }

    @Override
    public void showHomeTestData(AncientPoetry data) {
        tvMainTextView.setText(data.getContent());
    }


    @OnClick({R2.id.tv_main_text_view, R2.id.btn_test})
    public void onViewClicked(View view) {
        if (view.getId() == R.id.btn_test) {
            mHomePresenter.getTestData();
        }

    }
}
