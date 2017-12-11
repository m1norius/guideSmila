package com.minorius.smilaguide.retrofit.news;

import com.minorius.smilaguide.retrofit.news.pojo.Description;
import com.minorius.smilaguide.retrofit.news.pojo.News;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by minorius on 08.09.2017.
 */

public interface ApiNewsService {

    @GET("news/by_id/{id}")
    Observable<Description> loadNewsById(@Path("id") int id);

    @GET("news/all")
    Observable<List<News>> loadNewsAll(@Query("date") String date);

    @GET("news/region")
    Observable<List<News>> loadNewsRegion(@Query("region") String region, @Query("date") String date);

}
