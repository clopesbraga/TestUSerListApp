package br.com.clb.testuserlistapp

import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { UserRepository(androidApplication()) }
}

val viewModelModule = module {

    viewModel { CreateUserViewModel(androidApplication(),get()) }
    viewModel { DetailUserViewModel (androidApplication(),get()) }
    viewModel { ListUserViewModel(androidApplication(),get()) }
    viewModel { ListDesativeUserViewModel(androidApplication(),get()) }

}
