package com.marand.presentation

import androidx.annotation.CallSuper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class AbstractViewModel<T> : ViewModel() {
    private val disposables: CompositeDisposable = CompositeDisposable()

    abstract val stateObservable: MutableLiveData<T>

    protected open fun publishState(state: T) {
        stateObservable.postValue(state)
    }

    protected fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    private fun clearDisposables() {
        if (disposables.isDisposed.not())
            disposables.clear()
    }

    @CallSuper
    override fun onCleared() {
        super.onCleared()
        clearDisposables()
    }
}