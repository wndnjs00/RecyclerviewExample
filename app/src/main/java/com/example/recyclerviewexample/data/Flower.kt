package com.example.recyclerviewexample.data

import androidx.annotation.DrawableRes

data class Flower(
    val id : Long,
    val name : String,
    @DrawableRes
    val image : Int,
    val description : String
)
