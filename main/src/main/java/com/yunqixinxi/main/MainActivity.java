package com.yunqixinxi.main;

import com.fec.yunmall.mall.R;
import com.yunqi.product.core.base.vp.activity.BaseActivity;
import com.yunqi.product.core.bean.home.TestRankingBean;
import com.yunqixinxi.main.contract.HomeContract;
import com.yunqixinxi.main.presenter.HomePresenter;

public class MainActivity extends BaseActivity<HomePresenter> implements HomeContract.View{

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
        mHomePresenter=new HomePresenter();

        //        mHomePresenter.getTestData();
    }

    @Override
    protected HomePresenter getPresenter() {
        return new HomePresenter();
    }

    @Override
    public void showHomeTestData(TestRankingBean.ObjBean data) {

    }
}
