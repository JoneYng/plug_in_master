package com.yunqixinxi.mode_user.runAlone.contract;

import com.yunqi.product.core.base.vp.inter.IPresenter;
import com.yunqi.product.core.base.vp.inter.IView;
import com.yunqi.product.core.bean.home.AncientPoetry;

/**
 * @Created by zhou .
 * @时间 2018/5/4 11:15
 * @描述 ${TODO}
 */

public interface UserContract {

    interface View extends IView{
        void showHomeTestData(AncientPoetry data);
    }

    interface Presenter extends IPresenter<View>{
        void getTestData();
    }
}
