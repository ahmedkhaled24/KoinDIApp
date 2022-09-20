package com.momentum.learnkoindi

import android.app.Application
import com.momentum.learnkoindi.di.APIModule
import com.momentum.learnkoindi.di.DataModule
import com.momentum.learnkoindi.di.MyAppModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{

            // Koin Android logger
            androidLogger()

            // inject Android context
            androidContext(this@MyApp)

            // use properties from assets/koin.properties
            androidFileProperties()

            // use modules
            modules(listOf(
                MyAppModules.applicationModule,
                APIModule.apiModule,
                DataModule.dataModule
            ))
        }
    }
}