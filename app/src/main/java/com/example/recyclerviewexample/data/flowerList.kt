package com.example.recyclerviewexample.data

import com.example.recyclerviewexample.R

fun flowerList() : ArrayList<Flower> {
    return arrayListOf(
        Flower(
            id = 1,
            name = "daffodil",
            image = R.drawable.daffodil,
            description = "This is daffodil"
        ),
        Flower(
            id = 2,
            name = "dahlia",
            image = R.drawable.dahlia,
            description = "This is dahlia"
        ),
        Flower(
            id = 3,
            name = "daisy",
            image = R.drawable.daisy,
            description = "This is daisy"
        ),
        Flower(
            id = 4,
            name = "freesia",
            image = R.drawable.freesia,
            description = "This is freesia"
        )
    )
}