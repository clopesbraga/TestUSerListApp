package br.com.clb.testuserlistapp

import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { UserRepository(androidApplication()) }
}

val viewModelModule = module {

    viewModel { CreateUserViewModel(get()) }
    viewModel { DetailUserViewModel (get()) }
    viewModel { ListUserViewModel(get()) }
    viewModel { ListDesativeUserViewModel(get()) }

}
