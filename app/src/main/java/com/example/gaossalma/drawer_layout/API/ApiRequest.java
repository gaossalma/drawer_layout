package com.example.gaossalma.drawer_layout.API;

import com.example.gaossalma.drawer_layout.Model.ResponsModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by gaossalma on 4/25/2018.
 */

public interface ApiRequest {
    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponsModel> sendUser(@Field("fullname") String fullname,
                                @Field("e_mail") String e_mail,
                                @Field("username") String username,
                                @Field("gender") String gender,
                                @Field("country") String country,
                                @Field("language") String language,
                                @Field("birthday") String birthday,
                                @Field("phone_number") String phone_number,
                                @Field("password") String password);

    @FormUrlEncoded
    @POST("getcountry.php")
    Call<ResponsModel> getcountry(@Field("country") String country);

    @FormUrlEncoded
    @POST("getberita.php")
    Call<ResponsModel> getberita(
            String sjudul, @Field("judul") String judul,
            @Field("isi") String isi);

}
