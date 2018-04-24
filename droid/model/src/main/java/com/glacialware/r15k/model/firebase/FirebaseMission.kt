package com.glacialware.r15k.model.firebase

data class FirebaseMission(
        var id : Int = 0,
        var title : String = "",
        var description : String = "",
        var image : String = "",
        var completed : Boolean = false)