package com.pawcommunity

import java.io.Serializable

data class Animal(
    val name : String,
    val type : String,
    val age : Int,
    val photoUri : String
) : Serializable