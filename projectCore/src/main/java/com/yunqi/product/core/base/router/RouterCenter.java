package com.yunqi.product.core.base.router;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;
import com.yunqi.product.core.base.vp.activity.BaseActivity;
import com.yunqi.product.core.base.vp.fragment.BaseFragment;

/**
 * @author zhouxiang
 * @date 2019/1/28  14:17
 * @describe ${路由中心}
 */
public class RouterCenter {

    /**
     * 根据path返回Fragment
     *
     * @param path path
     * @return fragment
     */
    public static BaseFragment getFragment(String path) {
        return (BaseFragment) ARouter.getInstance()
                .build(path)
                .navigation();

    }



    /**
     *
     */
    public static Fragment toUser() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouterPath.USER).navigation();
        if (fragment == null){
            fragment = new Fragment();
        }
        return fragment ;
    }

    /**
     * 根据path返回Activity
     *
     * @param path path
     * @return Activity
     */
    public static BaseActivity getActivity(String path) {
        return (BaseActivity) ARouter.getInstance()
                .build(path)
                .navigation();
    }


}
