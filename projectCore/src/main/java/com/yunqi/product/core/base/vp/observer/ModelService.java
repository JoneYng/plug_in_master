package com.yunqi.product.core.base.vp.observer;

import com.yunqi.product.core.net.HttpHelper;
import com.yunqi.product.core.net.common_callback.INetCallback;
import com.yunqi.product.core.api.ApiService;
import com.yunqi.product.core.base.bean.BaseObj;
import com.yunqi.product.core.base.vp.inter.IView;
import com.yunqi.product.core.util.L;
import com.yunqi.product.core.util.RxUtils;
import io.reactivex.Observable;

/**
 * @author tome
 * @date 2019/1/28  17:26
 * @describe ${TODO}
 */
public class ModelService{
    private ModelService mModelService;

    /**
     * 获取api的回调
     * @param <T>
     */
    public interface SelectListener<T> {
        Observable<BaseObj<T>> selectApi(ApiService service);
    }

    public ModelService(ModelService modelService) {
        mModelService = modelService;

    }

    public static <T> BaseObserver<BaseObj<T>> getRemoteData(boolean isShowHUD, final IView mView, SelectListener<T> select, final INetCallback<T> callback) {
        //设置不同的BaseUrl
        return select.selectApi(HttpHelper.getDefault()
                                        .create(ApiService.class))
                     .compose(RxUtils.<BaseObj<T>>rxSchedulerHelper())
                     //.compose(RxUtils.handleResult())
                     .subscribeWith(new BaseObserver<BaseObj<T>>(mView, isShowHUD) {
                                        @Override
                                        public void onNext(BaseObj<T> result) {
                                            L.d("获取message", ":" + result.getMessage());
                                            if (BaseObj.SUCCESS.equals(result.getCode())) {
                                                callback.onSuccess(result.getData());
                                            } else {
                                                mView.showRequestError(result.getMessage(), result.getCode());
                                            }
                                        }
                                    }
                     );
    }
}
