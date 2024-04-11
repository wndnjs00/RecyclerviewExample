package com.example.recyclerviewexample.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.data.Flower
import com.example.recyclerviewexample.databinding.FlowerItemBinding

class FlowersAdapter(private val flowerList: List<Flower>) : RecyclerView.Adapter<FlowersAdapter.FlowerViewHolder>() {


    // 화면(레이아웃) 연결
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        val view = FlowerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FlowerViewHolder(view)
    }

    // 데이터 연결
    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        // bind함수에 있는 함수를 가져와서 데이터 뿌려줌
        holder.bind(flowerList[position])
    }


    // 아이템 개수 리턴
    override fun getItemCount(): Int {
        return flowerList.size
    }



    class FlowerViewHolder(private var binding: FlowerItemBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            // 클릭 리스너 달아줄거임
        }

        // 레이아웃과 데이터 연결
        fun bind(flower: Flower){
            binding.flowerText.text = flower.name
            binding.flowerImage.setImageResource(flower.image)
        }
    }


}