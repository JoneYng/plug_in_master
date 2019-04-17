package com.yunqi.product.core.util;

import android.content.Context;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chao.qu at 2017/10/20
 * @author quchao
 */

public class RxUtils  {

    /**
    * 统一线程处理
     *  @param <T> 指定的泛型类型
     * @return ObservableTransformer
      */
    public static <T> ObservableTransformer<T, T> rxSchedulerHelper(){
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())               //指定网络请求在IO线程
                        .unsubscribeOn(Schedulers.io())//一般我们在视图消亡后，无需RxJava再执行，可以直接取消订阅
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };    //显示数据在主线程

    }

    /**
     * 统一返回结果处理
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
     */
    //public static <T> ObservableTransformer<BaseResponse<T>, T> handleResult() {
    //    return httpResponseObservable ->
    //        httpResponseObservable.flatMap((Function<BaseResponse<T>, Observable<T>>) baseResponse -> {
    //            if(baseResponse.getErrorCode() == BaseResponse.SUCCESS
    //                && baseResponse.getData() != null
    //                && NetUtils.isNetworkConnected()) {
    //                return createData(baseResponse.getData());
    //            } else {
    //                //return Observable.error(new OtherException());
    //                return null;
    //            }
    //        });
    //}

    //lambda写法
    public static <T> ObservableTransformer<T, T> rxSchedulerHelper(Context mContext) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())                //指定网络请求在IO线程
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                LogUtil.d("显示数据" + Thread.currentThread().getName());
                                //ProgressManage.getInstance().showHUD(mContext);  //显示加载进度条
                            }
                        }).subscribeOn(AndroidSchedulers.mainThread()) //显示进度条在主线程
                        .observeOn(AndroidSchedulers.mainThread())     //显示数据在主线程
                        .doFinally(new Action() {
                            @Override
                            public void run() throws Exception {
                                //ProgressManage.getInstance().dismissHUD(); //隐藏进度条
                                LogUtil.d("隐藏数据" + Thread.currentThread().getName());
                            }
                        });
            }
        };
    }

    /**
     * 得到 Observable
     * @param <T> 指定的泛型类型
     * @return Observable
     */
    public static <T> Observable<T> createData(final T t) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });
    }


}
