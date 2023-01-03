package tn.esprit.retrofit_trying6.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import tn.esprit.retrofit_trying6.model.LoginResult
import java.util.HashMap

interface RetrofitInterface {

    @Headers("Content-Type:application/json")
    @POST("/user/login")
    fun executeLogin(@Body map: HashMap<String?, String?>?): Call<LoginResult?>?

    @Headers("Content-Type:application/json")
    @POST("/user/signup")
    fun executeSignup(@Body map: HashMap<String?, String?>?): Call<Void?>?

    @Headers("Content-Type:application/json")
    @POST("/suivi/add")
    fun executeSuivre(@Body map: HashMap<String?, String?>?): Call<Void?>?

    @Headers("Content-Type:application/json")
    @POST("question/add")
    fun executeQuestion(@Body map: HashMap<String?, String?>?): Call<Void?>?

    @Headers("Content-Type:application/json")
    @POST("aime/jaime")
    fun executeJaime(@Body map: HashMap<String?, String?>?): Call<Void?>?

    @Headers("Content-Type:application/json")
    @POST("/c/coment")
    fun executeComment(@Body map: HashMap<String?, String?>?): Call<Void?>?

    @Headers("Content-Type:application/json")
    @POST("/image/addimg")
    fun executeimage(@Body map: HashMap<String?, String?>?): Call<Void?>?

    @Headers("Content-Type:application/json")
    @POST("/Dislike/add")
    fun executeDislike(@Body map: HashMap<String?, String?>?): Call<Void?>?

    @Headers("Content-Type:application/json")
    @POST("/Dislike/delete")
    fun executeDislikeDelete(@Body map: HashMap<String?, String?>?): Call<Void?>?

    @Headers("Content-Type:application/json")
    @POST("aime/delete")
    fun executelikeDelete(@Body map: HashMap<String?, String?>?): Call<Void?>?




}