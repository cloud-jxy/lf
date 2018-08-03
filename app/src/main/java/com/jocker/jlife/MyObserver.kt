package com.jocker.jlife

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

abstract class MyObserver<T>:Observer<T> {
    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
    }

}