package com.example.recyclerviewexample.data

// 데이터를 관리하는 클래스(싱글톤)
// 얘를 아무리 많이 호출해도 인스턴스가 하나씩 호출됨(똑같은 인스턴스를 반환함)
class DataSource {
    companion object{
        private var INSTANCE : DataSource? = null

        fun getDataSoures() : DataSource{
            // DatoSource::class 객체에 lock을 걸어 한번에 한 스레드에서만 실행 되도록 함
            return synchronized(DataSource::class) {
                // 싱글톤 객체를 한번 호출하고 없으면 DataSource반환, 있으면 생성된 인스턴스 반환
                val newInstance = INSTANCE ?: DataSource()
                INSTANCE = newInstance
                newInstance
            }
        }
    }


    // MVVM패턴에서 Model에 해당한다고 볼 수 있음
    fun getFlowerList() : List<Flower>{
        // 만들어놓은 데이터클래스 리턴
        return flowerList()
    }



    // 1) 그냥 intent를 사용하는 방법
    // id값을 매칭
    fun getFlowerForId(id : Long) : Flower{
        flowerList().let{
            return it.first{it.id == id}
        }
    }


}