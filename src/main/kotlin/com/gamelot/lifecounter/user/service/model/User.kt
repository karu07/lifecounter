package com.gamelot.lifecounter.user.service.model

data class User(
    val name: String,
    val username : String,
    val email : String,
    val settings : GameSettings,
    val eventHistory : List<EventHistory>,
    val role : Role
){

}
