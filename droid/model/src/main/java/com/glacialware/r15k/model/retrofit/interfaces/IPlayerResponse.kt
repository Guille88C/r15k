package com.glacialware.r15k.model.retrofit.interfaces

import com.glacialware.r15k.model.retrofit.GenericGetAllResponse
import com.glacialware.r15k.model.retrofit.Player

interface IPlayerResponse {
    fun successResponse(response: GenericGetAllResponse<Player>)
    fun errorResponse(error: String)
}