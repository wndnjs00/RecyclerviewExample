## RecyclerView 구현
### 학습내용
1. **viewBinding** 사용
2. **RecyclerView** 구현
3. **람다식**을 사용하여 **아이템 클릭 이벤트** 구현
4. **싱글톤**을 사용하여 데이터 관리
5. key값을 **const val**값으로 지정하여 공통으로 사용하게끔 구현
6. **bundle**과 **확장함수**를 사용해서 데이터 전달</br></br>
---
4. 구현한것을 **MVVM패턴**을 사용해서 수정 **(observer pattern 사용)**</br>
   -> DataSource를 통해 받아왔던 데이터를 **ViewModel**로 받아오도록 수정
   -> LiveData는 아직 사용안함
