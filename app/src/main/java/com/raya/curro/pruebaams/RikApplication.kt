package com.raya.curro.pruebaams

import android.app.Application
import com.raya.curro.pruebaams.di.domainModule
import com.raya.curro.pruebaams.di.networkModule
import com.raya.curro.pruebaams.di.repositoryModule
import com.raya.curro.pruebaams.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class RikApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@RikApplication)
            modules(listOf(uiModule, networkModule, repositoryModule, domainModule))
        }

    }

}