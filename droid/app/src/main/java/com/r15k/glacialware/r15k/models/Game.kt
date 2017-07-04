package com.r15k.glacialware.r15k.models

/**
 * Created by Guille on 04/07/2017.
 */
class Game {
    var lPlayers : MutableList<Player>

    constructor() {
        this.lPlayers = mutableListOf()
    }

    constructor(lPlayers : MutableList<Player>) {
        this.lPlayers = lPlayers
    }
}