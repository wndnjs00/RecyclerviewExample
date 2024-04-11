package com.example.recyclerviewexample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerviewexample.data.DataSource
import com.example.recyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // lazy를 사용해서 뷰바인딩
    private val binding : ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

//    private val flowerAdapter : FlowersAdapter by lazy {
//        FlowersAdapter(flowerList = ArrayList())
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val dataSource = DataSource.getDataSoures().getFlowerList()     // 리스트 들고있음

        val flowerAdapter = FlowersAdapter(dataSource)
        binding.recyclerView.adapter = flowerAdapter

    }
}