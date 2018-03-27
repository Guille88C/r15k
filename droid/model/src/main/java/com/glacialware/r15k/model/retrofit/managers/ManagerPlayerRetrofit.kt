package com.glacialware.r15k.model.retrofit.managers

import com.glacialware.r15k.model.retrofit.GenericGetAllResponse
import com.glacialware.r15k.model.retrofit.response.IPlayerResponse
import com.glacialware.r15k.model.retrofit.Player
import com.glacialware.r15k.model.retrofit.PlayerController

class ManagerPlayerRetrofit(private val mPlayerResponse: IPlayerResponse): IPlayerResponse {
    // ---- Attributes ----
    private val mPlayerController = PlayerController(this)
    // ---- END Attributes ----

    // ---- IPlayerResponse ----
    override fun successResponse(response: GenericGetAllResponse<Player>) {
        mPlayerResponse.successResponse(response)
    }

    override fun errorResponse(error: String) {
        mPlayerResponse.errorResponse(error)
    }
    // ---- END IPlayerResponse ----

    // ---- Public ----

    fun start() {
        mPlayerController.start()
    }
    // ---- END Public ----
}