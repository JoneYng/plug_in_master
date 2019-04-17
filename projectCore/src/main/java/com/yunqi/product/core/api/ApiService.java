package com.yunqi.product.core.api;


import com.yunqi.product.core.base.bean.BaseObj;
import com.yunqi.product.core.bean.home.AncientPoetry;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author tome
 * @date 2019/1/28  17:24
 * @describe ${API}
 */
public interface ApiService {
    /**
     * 测试
     * @return
     */
//    @FormUrlEncoded
//    @POST("recommendPoetry")
//    Observable<BaseObj<TestRankingBean>> getRanking(@FieldMap Map<String, String> map);

    @GET("recommendPoetry")
    Observable<BaseObj<AncientPoetry>> getRanking();


}
