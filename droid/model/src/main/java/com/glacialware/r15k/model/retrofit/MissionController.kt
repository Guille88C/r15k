package com.glacialware.r15k.model.retrofit

import com.glacialware.r15k.model.retrofit.di.DaggerRetrofitComponent
import com.glacialware.r15k.model.retrofit.di.RetrofitModule
import com.glacialware.r15k.model.retrofit.di.RetrofitComponent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

/**
* Created by Guille on 28/11/2017.
*/
class MissionController : Callback<GenericGetAllResponse<Mission>> {
    interface IMissionResponse {
        fun successResponse(response: GenericGetAllResponse<Mission>)
        fun errorResponse(error: String)
    }

    @field:[Inject]
    protected lateinit var retrofit: Retrofit

    private val serviceComponent: RetrofitComponent by lazy {
        DaggerRetrofitComponent
                .builder()
                .retrofitModule(RetrofitModule())
                .build()
    }

    private val api: MissionAPI
    private var response: IMissionResponse? = null

    constructor(response: IMissionResponse) {
        this.response = response
        this.serviceComponent.inject(this)
        this.api = retrofit.create(MissionAPI::class.java)
    }

    fun start() {
        val call = this.api.getAll()
        call.enqueue(this)
    }

    override fun onFailure(call: Call<GenericGetAllResponse<Mission>>?, t: Throwable?) {
        t?.printStackTrace()
    }

    override fun onResponse(call: Call<GenericGetAllResponse<Mission>>?, response: Response<GenericGetAllResponse<Mission>>?) {
        if (response != null && this.response != null) {
            if (response.isSuccessful && response.body() != null) {
                this.response?.successResponse(response.body()!!)
            }
            else {
                this.response?.errorResponse("__error")
            }
        }
    }
}