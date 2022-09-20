package com.momentum.learnkoindi.di

import android.app.Application
import com.momentum.learnkoindi.repository.BaseRepository
import com.momentum.learnkoindi.repository.CustomRepository
import com.momentum.learnkoindi.MainAndroidViewModel
import com.momentum.learnkoindi.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object MyAppModules {

    val applicationModule: Module = module {

        single<BaseRepository> {
            provideCustomRepository()
        }

        viewModel {
            provideMainViewModel(get<BaseRepository>())
        }

        viewModel {
            provideMainAndroidViewModel(get<Application>(), get<BaseRepository>())
        }
    }


    private fun provideCustomRepository(): CustomRepository = CustomRepository()

    private fun provideMainViewModel(baseRepository: BaseRepository): MainViewModel = MainViewModel()

    private fun provideMainAndroidViewModel(
        application: Application,
        baseRepository: BaseRepository
    ): MainAndroidViewModel = MainAndroidViewModel(application)

}