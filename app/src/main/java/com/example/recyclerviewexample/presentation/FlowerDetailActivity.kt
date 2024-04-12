package com.example.recyclerviewexample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerviewexample.data.DataSource
import com.example.recyclerviewexample.data.flowerList
import com.example.recyclerviewexample.databinding.ActivityFlowerDetailBinding
import com.example.recyclerviewexample.databinding.ActivityMainBinding
import com.example.recyclerviewexample.extension.extraNotNull
import kotlinx.coroutines.flow.flow

class FlowerDetailActivity : AppCompatActivity() {

    // lazy를 사용해서 뷰바인딩
    private val binding: ActivityFlowerDetailBinding by lazy {
        ActivityFlowerDetailBinding.inflate(layoutInflater)
    }

    // bundle을 사용해서 map형태로 넘길것이기 때문에, extra_flower를 키값으로 지정해주기
    companion object{
        const val EXTRA_FLOWER : String = "extra_flower"
    }

    // 2) 확장함수로 넘긴 데이터를 받아오는 방법 -> key값 받아오기
    //  key값의 타입은 Long타입이고, EXTRA_FLOWER 이 키값을 받아온다
    private val flower by extraNotNull<Long>(EXTRA_FLOWER)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 1) intent를 사용해서 넘긴부분을 받는방법
        // 공유해서 쓰기로한 EXTRA_FLOWER 키값을 받아옴
//        val flowerId = intent.extras?.getLong(EXTRA_FLOWER) ?: 0
//        val flowerData = DataSource.getDataSoures().getFlowerForId(flowerId)
//
//        // 값을 가져와서 레이아웃에 뿌려주면 끝!
//        binding.flowerDetailName.text = flowerData.name
//        binding.flowerDetailImage.setImageResource(flowerData.image)
//        binding.flowerDetailDescription.text = flowerData.description


        // 2) 확장함수로 넘긴 데이터를 받아오는 방법
        val flowerData = DataSource().getFlowerForId(flower)

        // 값을 가져와서 레이아웃에 뿌려주면 끝!
        binding.flowerDetailName.text = flowerData.name
        binding.flowerDetailImage.setImageResource(flowerData.image)
        binding.flowerDetailDescription.text = flowerData.description


    }

}