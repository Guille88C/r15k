package com.glacialware.r15k.model.retrofit

interface IPlayerResponse {
    fun successResponse(response: GenericGetAllResponse<Player>)
    fun errorResponse(error: String)
}