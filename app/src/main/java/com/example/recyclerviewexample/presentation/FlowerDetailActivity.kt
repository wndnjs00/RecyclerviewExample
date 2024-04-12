package com.example.recyclerviewexample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerviewexample.data.DataSource
import com.example.recyclerviewexample.extension.extraNotNull

class FlowerDetailActivity : AppCompatActivity() {


    // bundle을 사용해서 map형태로 넘길것이기 때문에, extra_flower를 키값으로 지정해주기
    companion object{
        const val EXTRA_FLOWER : String = "extra_flower"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1) intent를 사용해서 넘긴부분을 받는방법
        // 공유해서 쓰기로한 EXTRA_FLOWER 키값을 받아옴
        val value = intent.extras?.getLong(EXTRA_FLOWER)
        val flower = value?.let {
            DataSource().getFlowerForId(it)
        }
        // flower.id 이런식으로 id값을 가져와서 뿌려주면 끝!
    }

}