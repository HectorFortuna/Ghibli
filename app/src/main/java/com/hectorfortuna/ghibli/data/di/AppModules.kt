package com.hectorfortuna.ghibli.data.di

import com.hectorfortuna.ghibli.data.remote.KtorRemoteDataSource
import com.hectorfortuna.ghibli.data.remote.RemoteDataSource
import com.hectorfortuna.ghibli.data.repository.MoviesRepository
import com.hectorfortuna.ghibli.data.repository.MoviesRepositoryImpl
import com.hectorfortuna.ghibli.ui.feature.MoviesViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single<RemoteDataSource> { KtorRemoteDataSource(get()) }
    single<MoviesRepository> { MoviesRepositoryImpl(get()) }
    viewModel { MoviesViewModel(get()) }
}

val networkModule = module {
    single {
        HttpClient(Android) {
            install(Logging) {
                logger = Logger.SIMPLE
            }
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                    })
            }
        }
    }
}