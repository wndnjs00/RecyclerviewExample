package com.example.recyclerviewexample.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerviewexample.data.DataSource
import com.example.recyclerviewexample.data.Flower

// viewModel 상속받음
class FlowerViewModel(dataSource : DataSource) : ViewModel() {

    // 1) data list observing을 사용하는 방법 (LiveData 없이)

    val flowerData = dataSource.getFlowerList()

    // FlowerDetailActivity에서 DataSoure이용해서 표현했던부분을 viewModel로 사용하기위해 만드는 함수
    // dataSoure에는 이미 데이터가 있으니깐 또 파라미터로 받아올필요 없고, 바로 id값을 파라미터로 넘겨주먄됨
    fun getFlowerForId(id : Long) : Flower{
        return flowerData.get(id.toInt())
    }

}


// viewModel 생성
class FlowerViewModelFactory : ViewModelProvider.Factory{

    // 어떤 뷰모델이 와도 가능하게끔 (데이터타입도 어떤 데이터타입이든지 가능하도록)
    // T -> Generic 타입을 사용하여 어떤타입의 viewModel이든 생성가능하도록
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        // modelClass(FlowerViewModel)가 유효한지 검사 (값이 있는지 체크)
        // 즉, FlowerViewModel::class.java가 modelClass와 동일한 클래스인지를 검사
        if (modelClass.isAssignableFrom(FlowerViewModel::class.java)){
            // 값이 있다면, FlowerViewModel객체를 생성 / 이때, FlowerViewModel은 dataSource를 인자로 받아 초기화된다
            // FlowerViewModel을 제네릭T타입으로 바꿔주겠다
            return FlowerViewModel(dataSource = DataSource.getDataSoures()) as T
        }
        // 값이 없을때
        throw IllegalAccessException("Unknown ViewModel Class")
    }
}

// 이렇게하면 Activity에서 ViewModel을 사용할 수 있도록 세팅된것!