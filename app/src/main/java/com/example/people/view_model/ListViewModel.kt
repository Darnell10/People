package com.example.people.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.people.model.PeopleApiService
import com.example.people.model.UserResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel : ViewModel() {

    private val peopleApiService = PeopleApiService()
    private val disposable = CompositeDisposable()

    val peeps = MutableLiveData<List<UserResponse>>()
    val peepsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {

        fetchFromRemote()
    }

    private fun fetchFromRemote() {
        loading.value = true
        disposable.add(
            peopleApiService.getPeeps()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<UserResponse>>() {
                    override fun onSuccess(userList: List<UserResponse>) {
                        peeps.value = userList
                        peepsLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        peepsLoadError.value = true
                        loading.value = false
                        e.printStackTrace()
                    }

                })

        )

    }


    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}