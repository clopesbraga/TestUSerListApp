package br.com.clb.testuserlistapp.di.application

import br.com.clb.testuserlistapp.appModule
import br.com.clb.testuserlistapp.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class UserApplication: android.app.Application(){

    override fun onCreate(){
        super.onCreate()

        GlobalContext.startKoin {
            androidContext(this@UserApplication)
            modules(viewModelModule,appModule)
        }

    }


}