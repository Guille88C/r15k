package com.glacialware.r15k.model.retrofit

/**
 * Created by Guille on 28/11/2017.
 */
data class GenericGetAllResponse<out T>(
    val code: Int,
    val message: String,
    val values: List<T>
) where T: BaseEntity