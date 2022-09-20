package com.momentum.learnkoindi

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.momentum.learnkoindi.repository.BaseRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainAndroidViewModel : AndroidViewModel, KoinComponent {

    private val baseRepository : BaseRepository by inject()
    private val liveHello : MutableLiveData<String> by lazy(LazyThreadSafetyMode.NONE, initializer = { MutableLiveData<String>() })

    constructor(application: Application) : super(application) {

    }

    fun sayHello() : LiveData<String> {
        try {
            liveHello.setValue("${baseRepository.giveHello()} \n from \n MainViewModel Instance \n $this \n and \n CustomRepository Instance \n ${baseRepository.giveRepository()}")
        } catch (ex : Exception) {
            liveHello.setValue("Error! ${ex.message}")
        }
        return liveHello
    }
}