package com.samuel.sisvita17.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.samuel.sisvita17.data.model.response.TestListResponse
import com.samuel.sisvita17.data.repository.TestRepository

class TestHomeViewModel: ViewModel()  {
    private val testRepository = TestRepository()
    private val _testsResult = MutableLiveData<TestListResponse?>()
    val testResult : LiveData<TestListResponse?> get() = _testsResult

    fun getTests(){
        testRepository.getTests {
            response ->
            _testsResult.postValue(response)
        }
    }

}