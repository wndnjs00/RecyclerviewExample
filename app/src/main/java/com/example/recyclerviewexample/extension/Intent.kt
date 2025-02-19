package com.example.recyclerviewexample.extension

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.core.os.bundleOf

// Intent를 확장함수로 뽑아서 사용 (모든 엑티비티에서 사용가능하도록)
// Intent를 확장함수로 뽑아서 사용하면 intent할때마다 intent코드 하나하나 안써줘도됨

// inline함수를 사용하면 선언시점에 바로 실행 -> 성능 좀더 좋음
// Any -> 어떤 타입이든 와도된다
inline fun <reified T : Any> newIntent(context : Context) : Intent =
    // Intent(this, FlowerDetailActivity()::class.java) 이거에 해당하는 부분
    Intent(context, T::class.java)


// startActivity하는 부분도 확장함수로 빼기 (launchActivity 명은 자유롭게 설정가능)
inline fun <reified T : Any> Context.launchActivity(
    // key, value값 / key값은 String, value값은 어떤타입이든 올수있도록)
    vararg pairs: Pair<String, Any?>){
    val intent = newIntent<T>(this)
    intent.putExtras(bundleOf(*pairs))
    startActivity(intent)
}


// 2) 데이터 받아오는 부분도 확장함수로 빼기
inline fun <reified T : Any> Activity.extraNotNull(key : String, default : T ?= null) = lazy {
    // intent.extras?.getLong(EXTRA_FLOWER) ?: 0    이거에 해당하는 부분
    val value = intent?.extras?.getLong(key)

    // requireNotNull는 null이 아님을 보장하는 함수
    // value가 제네릭타입이 T이면 value리턴, 아니면 default리턴
    requireNotNull(if (value is T) value else default) { key }
}
