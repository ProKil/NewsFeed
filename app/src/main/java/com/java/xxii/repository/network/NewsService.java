/*
 * Copyright (c) 2016 咖枯 <java201313@163.com | 3772304@qq.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.java.xxii.repository.network;

import com.java.xxii.mvp.entity.GirlData;
import com.java.xxii.mvp.entity.NewsDetail;
import com.java.xxii.mvp.entity.NewsSummary;
import com.java.xxii.mvp.entity.NewsSummaryRetrieve;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * @author 咖枯
 * @version 1.0 2016/5/24
 */
public interface NewsService {
//    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    @GET("action/query/latest")
    Observable<NewsSummaryRetrieve> getNewsList(
            @Header("Cache-Control") String cacheControl,
             @Query("category") int id);
//            @@Path("type") String type,Path("startPage") int startPage);

    //@GET("nc/article/{postId}/full.html")
    @GET("action/query/detail")
    Observable<Map<String, NewsDetail>> getNewDetail(
            @Header("Cache-Control") String cacheControl,
            @Query("newsId") String newsId);

    @GET
    Observable<ResponseBody> getNewsBodyHtmlPhoto(
            @Url String photoPath);
    //@Url，它允许我们直接传入一个请求的URL。这样以来我们可以将上一个请求的获得的url直接传入进来，baseUrl将被无视
    // baseUrl 需要符合标准，为空、""、或不合法将会报错

    @GET("data/福利/{size}/{page}")
    Observable<GirlData> getPhotoList(
            @Path("size") int size,
            @Path("page") int page);
}
