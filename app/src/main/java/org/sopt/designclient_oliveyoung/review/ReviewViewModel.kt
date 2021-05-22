package org.sopt.designclient_oliveyoung.review

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReviewViewModel : ViewModel() {
    private val _likeCount = MutableLiveData<Int>(66)
    val likeCount : LiveData<Int>
        get() = _likeCount

    fun plusLikeCount(){
        _likeCount.value = likeCount.value?.plus(1)
    }

    fun minusLikeCount(){
        _likeCount.value = likeCount.value?.minus(1)
    }
}