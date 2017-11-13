package com.glacialware.r15k.view.entities

/**
 * Created by Guille on 04/07/2017.
 */
class Player {
    var id : Int get set
    var nick : String get set
    var lMissions : MutableList<Mission> get set
    var isDead : Boolean get set

    constructor() {
        this.id = 0
        this.nick = ""
        this.lMissions = mutableListOf()
        this.isDead = false
    }

    constructor(id : Int, nick : String, lMissions : MutableList<Mission>, isDead : Boolean) {
        this.id = id
        this.nick = nick
        this.lMissions = lMissions
        this.isDead = isDead
    }
}