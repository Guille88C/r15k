package com.r15k.glacialware.r15k.models

/**
 * Created by Guille on 04/07/2017.
 */
class Mission {
    var id : Int get set
    var title : String get set
    var description : String get set
    var image : String get set
    var completed : Boolean get set
    var idPlayer : Int get set

    constructor() {
        this.id = 0
        this.title = ""
        this.description = ""
        this.image = ""
        this.completed = false
        this.idPlayer = -1
    }

    constructor(id : Int, title : String, description : String, image : String, completed : Boolean, idPlayer : Int) {
        this.id = id
        this.title = title
        this.description = description
        this.image = image
        this.completed = completed
        this.idPlayer = idPlayer
    }

}