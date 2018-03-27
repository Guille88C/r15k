package com.glacialware.r15k.model.retrofit

import com.glacialware.r15k.model.retrofit.di.DaggerGeneralComponent
import com.glacialware.r15k.model.retrofit.di.GeneralComponent
import com.glacialware.r15k.model.retrofit.di.ServiceModule
import com.glacialware.r15k.model.retrofit.response.IPlayerResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

/**
* Created by Guille on 28/11/2017.
*/
class PlayerController(response: IPlayerResponse) : Callback<GenericGetAllResponse<Player>> {
    @field:[Inject]
    lateinit var retrofit: Retrofit

    private val serviceComponent: GeneralComponent by lazy {
        DaggerGeneralComponent
                .builder()
                .serviceModule(ServiceModule())
                .build()
    }

    private val api: PlayerAPI
    private var response: IPlayerResponse? = response

    fun start() {
        val call = this.api.getAll()
        call.enqueue(this)
    }

    override fun onFailure(call: Call<GenericGetAllResponse<Player>>?, t: Throwable?) {
        t?.printStackTrace()
    }

    override fun onResponse(call: Call<GenericGetAllResponse<Player>>?, response: Response<GenericGetAllResponse<Player>>?) {
        if (response != null && this.response != null) {
            if (response.isSuccessful && response.body() != null) {
                this.response?.successResponse(response.body()!!)
            }
            else {
                this.response?.errorResponse("__error")
            }
        }
    }

    init {
        this.serviceComponent.inject(this)
        this.api = retrofit.create(PlayerAPI::class.java)
    }

}