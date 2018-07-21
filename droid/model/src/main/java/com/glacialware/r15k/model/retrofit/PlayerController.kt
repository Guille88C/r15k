package com.glacialware.r15k.model.retrofit

import com.glacialware.r15k.model.retrofit.di.RetrofitDependency
import com.glacialware.r15k.model.retrofit.interfaces.IPlayerResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

/**
* Created by Guille on 28/11/2017.
*/
class PlayerController(private val response: IPlayerResponse) : Callback<GenericGetAllResponse<Player>> {

    private val retrofit: Retrofit = RetrofitDependency.provideRetrofitInstance()
    private val api: PlayerAPI = retrofit.create(PlayerAPI::class.java)

    fun start() {
        val call = this.api.getAll()
        call.enqueue(this)
    }

    override fun onFailure(call: Call<GenericGetAllResponse<Player>>?, t: Throwable?) {
        t?.printStackTrace()
    }

    override fun onResponse(call: Call<GenericGetAllResponse<Player>>?, response: Response<GenericGetAllResponse<Player>>?) {
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