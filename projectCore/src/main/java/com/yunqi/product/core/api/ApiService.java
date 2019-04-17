package com.yunqi.product.core.api;

import com.yunqi.product.core.base.bean.BaseObj;
import com.yunqi.product.core.bean.home.TestRankingBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author tome
 * @date 2019/1/28  17:24
 * @describe ${API}
 */
public interface ApiService {
    /**
     * 测试
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("v6/v6_005")
    Observable<BaseObj<TestRankingBean>> getRanking(@FieldMap Map<String, String> map);


}
