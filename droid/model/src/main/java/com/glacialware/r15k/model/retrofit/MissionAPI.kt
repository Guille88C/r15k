package com.glacialware.r15k.model.retrofit

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Guille on 28/11/2017.
 */
interface MissionAPI {
    @GET("get_all_missions.php")
    fun getAll(): Call<GenericGetAllResponse<Mission>>
}