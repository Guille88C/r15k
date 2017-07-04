package com.r15k.glacialware.r15k.models

/**
 * Created by Guille on 04/07/2017.
 */
class Player {
    var id : Int get set
    var nick : String get set
    var lMissions : MutableList<Mission> get set

    constructor() {
        this.id = 0
        this.nick = ""
        this.lMissions = mutableListOf()
    }

    constructor(id : Int, nick : String, lMissions : MutableList<Mission>) {
        this.id = id
        this.nick = nick
        this.lMissions = lMissions
    }
}