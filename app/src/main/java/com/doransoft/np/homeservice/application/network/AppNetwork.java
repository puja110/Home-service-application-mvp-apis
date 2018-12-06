package com.doransoft.np.homeservice.application.network;

import com.doransoft.np.homeservice.application.network.ProductCategoriesDAO.ProductCategories;
import com.doransoft.np.homeservice.modules.login.pojo.LoginResponse;
import com.doransoft.np.homeservice.modules.main.fragments.more.moreResponse.FeaturedProducts;
import com.doransoft.np.homeservice.modules.register.pojo.RegisterResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface AppNetwork {

    @POST
    @FormUrlEncoded
    Observable<LoginResponse> requestLoginToServer(@Field("email") String email, @Field("password") String password, @Field("secretkey") String secretkey);

    @POST
    @FormUrlEncoded
    Observable<RegisterResponse> requestRegisterToServer(@Field("email") String email, @Field("password") String password, @Field("secretkey") String secretkey);

    @GET("categories")
    @FormUrlEncoded
    Observable<ProductCategories> getProductCategoryList(@Header(value = "securitykey") String securitykey);

    @GET("featured-products")
    @FormUrlEncoded
    Observable<FeaturedProducts> getFeaturedList(@Header(value = "securitykey") String securitykey);

}
