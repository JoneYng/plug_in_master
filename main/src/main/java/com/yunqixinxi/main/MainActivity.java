package com.yunqixinxi.main;

import com.fec.yunmall.mall.R;
import com.yunqi.product.core.base.vp.activity.BaseActivity;
import com.yunqixinxi.main.contract.MainContract;
import com.yunqixinxi.main.presenter.HomePresenter;

public class MainActivity extends BaseActivity<HomePresenter> implements MainContract.View{

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

    }

    @Override
    protected HomePresenter getPresenter() {
        return new HomePresenter();
    }
}
