package com.example.chatlayout

class MessageModule {

    var message:String? = null
    var senderId:Int? = null

    constructor(){}

    constructor(message:String, senderId:Int){

        this.message = message
        this.senderId = senderId

    }
}