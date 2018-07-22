package com.glacialware.r15k.model.retrofit

import com.glacialware.r15k.model.retrofit.di.RetrofitDependency
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

/**
* Created by Guille on 28/11/2017.
*/
class MissionController(private val response: IMissionResponse) : Callback<GenericGetAllResponse<Mission>> {
    interface IMissionResponse {
        fun successResponse(response: GenericGetAllResponse<Mission>)
        fun errorResponse(error: String)
    }

    private val retrofit: Retrofit = RetrofitDependency.provideRetrofitInstance()
    private val api: MissionAPI = retrofit.create(MissionAPI::class.java)

//    fun start() {
//        val call = this.api.getAll()
//        call.enqueue(this)
//    }

    override fun onFailure(call: Call<GenericGetAllResponse<Mission>>?, t: Throwable?) {
        t?.printStackTrace()
    }

    override fun onResponse(call: Call<GenericGetAllResponse<Mission>>?, response: Response<GenericGetAllResponse<Mission>>?) {
        if (response != null) {
            if (response.isSuccessful && response.body() != null) {
                this.response.successResponse(response.body()!!)
            }
            else {
                this.response.errorResponse("__error")
            }
        }
    }
}