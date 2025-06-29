package org.jrdemadara.bluecollar

import android.app.Application
import org.jrdemadara.bluecollar.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.dsl.module

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MainApplication)
            androidLogger()
            modules (
//                module {
//                    single { DatabaseDriverFactory(applicationContext) }
//                }
            )
        }
    }
}