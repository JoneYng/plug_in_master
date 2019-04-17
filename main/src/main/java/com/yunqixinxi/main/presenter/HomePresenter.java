package com.yunqixinxi.main.presenter;

import com.yunqi.product.core.api.ApiService;
import com.yunqi.product.core.base.bean.BaseObj;
import com.yunqi.product.core.base.vp.observer.ModelService;
import com.yunqi.product.core.base.vp.presenter.BasePresenter;
import com.yunqi.product.core.bean.home.TestRankingBean;
import com.yunqi.product.core.net.common_callback.INetCallback;
import com.yunqi.product.core.params.RequestMapParams;
import com.yunqi.product.core.util.L;
import com.yunqixinxi.main.contract.HomeContract;

import java.util.Map;

import io.reactivex.Observable;

/**
 * @author tome
 * @date 2019/1/28  15:05
 * @describe ${主页presenter}
 */
public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter{

    @Override
    public void getHomeListData() {

    }

    @Override
    public void getTestData() {
        RequestMapParams params = new RequestMapParams();
        final Map<String,String> map = params.build();

        addDisposable(ModelService.getRemoteData(true,mView,new ModelService.SelectListener<TestRankingBean>() {
            @Override
            public Observable<BaseObj<TestRankingBean>> selectApi(ApiService service) {
                return service.getRanking(map);
            }
        },new INetCallback<TestRankingBean>() {
            @Override
            public void onSuccess(TestRankingBean result) {
                if (BaseObj.STATE.equals(result.getState())){
                    L.d("okhttp:"+mView);
                    //mView.showNormal();
                    mView.showHomeTestData(result.getObj());
                }

            }
        }));
    }
}
