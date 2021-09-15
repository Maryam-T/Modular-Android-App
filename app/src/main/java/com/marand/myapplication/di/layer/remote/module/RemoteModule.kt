package com.marand.myapplication.di.layer.remote.module

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.marand.myapplication.BuildConfig
import com.marand.myapplication.di.layer.remote.qualifier.ConnectivityCheckerInterceptorQualifier
import com.marand.myapplication.di.layer.remote.qualifier.KeyInterceptorQualifier
import com.marand.myapplication.di.layer.remote.qualifier.LoggingInterceptorQualifier
import com.marand.myapplication.util.ConnectivityChecker
import com.marand.myapplication.util.HeaderQueryUtil
import com.marand.myapplication.util.NoConnectivityException
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import javax.inject.Singleton

@Module
object RemoteModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    @LoggingInterceptorQualifier
    fun provideLoggingInterceptor(): Interceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else HttpLoggingInterceptor.Level.NONE
    }

    @Provides
    @Singleton
    @ConnectivityCheckerInterceptorQualifier
    //Checks connectivity before the every call shoots onto the network
    fun provideInternetConnectivityInterceptor(connectivityChecker: ConnectivityChecker): Interceptor =
        // This is NOT a SAM interface
        // https://kotlinlang.org/docs/fun-interfaces.html
        Interceptor {
//            if (!connectivityChecker.isNetworkActive()) throw NoConnectivityException()
            it.proceed(it.request())
        }

    //Intercepts each request and adds required auth keys to the header
    @Provides
    @Singleton
    @KeyInterceptorQualifier
    fun provideKeyInterceptor(): Interceptor = Interceptor.invoke { chain ->
        val request = HeaderQueryUtil.addSecretQueryParams(
            chain.request(),
            BuildConfig.API_KEY
        )
        chain.proceed(request)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @LoggingInterceptorQualifier loggingInterceptor: Interceptor,
        @KeyInterceptorQualifier keyInterceptor: Interceptor,
        @ConnectivityCheckerInterceptorQualifier connectivityInterceptor: Interceptor
    ): OkHttpClient =
        OkHttpClient().newBuilder().apply {
            addInterceptor(keyInterceptor)
            addInterceptor(connectivityInterceptor)
            addInterceptor(loggingInterceptor)
        }.build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
}
