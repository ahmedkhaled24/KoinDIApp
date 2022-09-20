package com.momentum.learnkoindi.di

import org.koin.dsl.module

/**
 * For API (Retrofit)
 * */
object APIModule {

    val apiModule = module {

        //fun provideApi(retrofit: Retrofit) = retrofit.create(GithubRepoApi::class.java)

        /*
        single {
            provideApi(get())
        }
        */
    }
}