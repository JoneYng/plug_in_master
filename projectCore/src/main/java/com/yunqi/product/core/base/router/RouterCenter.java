package com.yunqi.product.core.base.router;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author tome
 * @date 2019/1/28  14:17
 * @describe ${路由中心}
 */
public class RouterCenter {

    public static Activity toMain() {
        Activity fragment = (Activity) ARouter.getInstance().build(RouterPath.MAIN).navigation();
        if (fragment == null) {
            fragment = new Activity();
        }
        return fragment;
    }


}
