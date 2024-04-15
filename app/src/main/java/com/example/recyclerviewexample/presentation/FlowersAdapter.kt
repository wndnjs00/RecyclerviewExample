package com.example.recyclerviewexample.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.R
import com.example.recyclerviewexample.data.Flower
import com.example.recyclerviewexample.databinding.FlowerItemBinding

// 클릭 이벤트(onClick)
class FlowersAdapter(var flowerList : List<Flower>, private val onClick : (Flower) -> Unit) : RecyclerView.Adapter<FlowersAdapter.FlowerViewHolder>() {

//    var flowerList = listOf<Flower>()


    // 화면(레이아웃) 연결 (여기서 멀티뷰타입 설정가능)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.flower_item, parent,false)
        return FlowerViewHolder(FlowerItemBinding.bind(view), onClick)
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



    class FlowerViewHolder(private var binding: FlowerItemBinding, private val onClick : (Flower) -> Unit) : RecyclerView.ViewHolder(binding.root){
        private var currentFlower : Flower ?= null
        init {
            // 클릭 리스너
            itemView.setOnClickListener {
                currentFlower?.let {
                    onClick.invoke(it)
                }

            }
        }


        // 레이아웃과 데이터 연결
        fun bind(flower: Flower){
            currentFlower = flower

            binding.flowerText.text = flower.name
            binding.flowerImage.setImageResource(flower.image)
        }
    }


}