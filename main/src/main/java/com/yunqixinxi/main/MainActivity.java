package com.yunqixinxi.main;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.yunqi.product.core.base.router.RouterCenter;
import com.yunqi.product.core.base.vp.activity.BaseActivity;
import com.yunqi.product.core.bean.home.AncientPoetry;
import com.yunqixinxi.main.contract.HomeContract;
import com.yunqixinxi.main.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

public class MainActivity extends BaseActivity<HomePresenter> implements HomeContract.View {

    private NavigationController mController;
    @BindView(R2.id.main_pager)
    FrameLayout        mainPager;
    @BindView(R2.id.main_tab)
    PageNavigationView mainTab;

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity_main;
    }

    /**
     * 存放切换Fragment
     */
    private List<Fragment> mFragmentList = new ArrayList<>();

    HomePresenter mHomePresenter;


    @Override
    protected void initView() {

        mainTab.setBackgroundColor(Color.argb(100, 246, 246, 246));
        mController = mainTab.material()
                .addItem(R.mipmap.home_icon_select, "首页", getResources().getColor(R.color.colorPrimary))
                .addItem(R.mipmap.home_icon_select, "首页", getResources().getColor(R.color.colorPrimary))
                .addItem(R.mipmap.home_icon_select, "首页", getResources().getColor(R.color.colorPrimary))
                .addItem(R.mipmap.home_icon_select, "我的", getResources().getColor(R.color.colorPrimary))
                .build();
        changeFragment(0);
        mController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                changeFragment(index);
            }

            @Override
            public void onRepeat(int index) {

            }
        });
    }


    /**
     * Fragment 发生改变
     *
     */
    public void changeFragment(int index) {
        hideFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment;
            if (index==0) {
                fragment =new Fragment();
            } else if (index==1) {
                fragment = new Fragment();
            } else if (index==2) {
                fragment = new Fragment();
            } else {
                fragment = RouterCenter.toUser();
            }
            mFragmentList.add(fragment);
            transaction.add(R.id.main_pager, fragment);
        transaction.commitAllowingStateLoss();
    }


    /**
     * 隐藏所有Fragment
     */
    private void hideFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (Fragment f : mFragmentList) {
            transaction.hide(f);
        }
        transaction.commit();

    }


    @Override
    protected void initListenerAddData() {
        mHomePresenter = new HomePresenter(this);
    }

    @Override
    protected HomePresenter getPresenter() {
        return new HomePresenter(this);
    }

    @Override
    public void showHomeTestData(AncientPoetry data) {

    }

}
