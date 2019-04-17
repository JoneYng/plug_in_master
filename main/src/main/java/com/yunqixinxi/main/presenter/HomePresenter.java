package com.yunqixinxi.main.presenter;

import com.yunqi.product.core.api.ApiService;
import com.yunqi.product.core.base.bean.BaseObj;
import com.yunqi.product.core.base.vp.observer.ModelService;
import com.yunqi.product.core.base.vp.presenter.BasePresenter;
import com.yunqi.product.core.bean.home.AncientPoetry;
import com.yunqi.product.core.net.common_callback.INetCallback;
import com.yunqi.product.core.params.RequestMapParams;
import com.yunqixinxi.main.contract.HomeContract;

import java.util.Map;

import io.reactivex.Observable;

/**
 * @author tome
 * @date 2019/1/28  15:05
 * @describe ${主页presenter}
 */
public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter{
    HomeContract.View view;

    public HomePresenter(HomeContract.View view) {
        this.view=view;
    }

    @Override
    public void getTestData() {
        RequestMapParams params = new RequestMapParams();
        final Map<String,String> map = params.build();

        addDisposable(ModelService.getRemoteData(true,view,new ModelService.SelectListener<AncientPoetry>() {
            @Override
            public Observable<BaseObj<AncientPoetry>> selectApi(ApiService service) {
                return service.getRanking();
            }
        },new INetCallback<AncientPoetry>() {
            @Override
            public void onSuccess(AncientPoetry result) {
                view.showHomeTestData(result);
            }


        }));
    }
}
