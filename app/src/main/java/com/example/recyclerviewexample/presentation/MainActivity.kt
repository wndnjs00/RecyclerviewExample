package com.example.recyclerviewexample.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerviewexample.data.DataSource
import com.example.recyclerviewexample.data.Flower
import com.example.recyclerviewexample.data.flowerList
import com.example.recyclerviewexample.databinding.ActivityMainBinding
import com.example.recyclerviewexample.extension.launchActivity
import kotlinx.coroutines.flow.flow

class MainActivity : AppCompatActivity() {

    // lazy를 사용해서 뷰바인딩
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    private val flowersAdapter : FlowersAdapter by lazy {
        FlowersAdapter(flowerList()){ flower ->
            // 클릭 이벤트
            // 클릭했을때 FlowerDetailActivity로 이동하게끔
            adpaterOnClick(flower)
        }
    }


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(binding.root)

            val dataSource = DataSource.getDataSoures().getFlowerList()     // 리스트 들고있음

            // 어뎁터와 데이터리스트 연결
            flowersAdapter.flowerList = dataSource

            // 리사이클러뷰 레이아웃과 연결
            with(binding.recyclerView) {
                adapter = flowersAdapter
            }

        }


    // 클릭했을때 FlowerDetailActivity로 이동하게끔하는 함수 [ 1) 그냥 intent를 사용해서 넘기는 방법 ]
//    private fun adpaterOnClick(flower: Flower) {
//        val intent = Intent(this, FlowerDetailActivity()::class.java)
//           //FlowerDetailActivity로 데이터 전달
//        intent.putExtra(FlowerDetailActivity.EXTRA_FLOWER , flower.id)      // 키값:EXTRA_FLOWER, value값:flower.id      //intent.putExtra("FLOWER_ID", flower.id) 이런식으로도 사용가능
//        startActivity(intent)
//    }


       // 클릭했을때 FlowerDetailActivity로 이동하게끔하는 함수 [ 2) 확장함수로 intent를 만들어서 넘기는 방법 ]
        private fun adpaterOnClick(flower: Flower) {
            launchActivity<FlowerDetailActivity>(
                // FlowerDetailActivity로 데이터 전달
                FlowerDetailActivity.EXTRA_FLOWER to flower.id
            )
        }

    }
