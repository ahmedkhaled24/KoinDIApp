package com.momentum.learnkoindi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.momentum.learnkoindi.repository.BaseRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainViewModel : ViewModel(), KoinComponent {

    private val baseRepository : BaseRepository by inject()
    private val liveHello : MutableLiveData<String> by lazy(LazyThreadSafetyMode.NONE, initializer = { MutableLiveData<String>() })

    fun sayHello() : LiveData<String> {
        try {
            liveHello.setValue("${baseRepository.giveHello()} \n from \n MainViewModel Instance \n $this \n and \n CustomRepository Instance \n ${baseRepository.giveRepository()}")
        } catch (ex : Exception) {
            liveHello.setValue("Error! ${ex.message}")
        }
        return liveHello
    }
}