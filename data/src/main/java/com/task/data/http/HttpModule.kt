package com.task.data.http

import com.squareup.moshi.Moshi
import com.task.data.BuildConfig.BASE_URL
import com.task.data.dataservice.apiservice.StationsApiService
import com.task.data.dataservice.apiservice.UserApiService
import com.task.data.http.interceptor.HeaderInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private val qualifierJsonConverter = StringQualifier("qualifierJsonConverter")
private val qualifierHeaderInterceptor = StringQualifier("qualifierHeaderInterceptor")
private val qualifierLoggingInterceptor = StringQualifier("qualifierLoggingInterceptor")
private val qualifierRetrofitClient = StringQualifier("qualifierRetrofitClient")
private val qualifierOkHttpClient = StringQualifier("qualifierOkHttpClient")

internal val httpModule = module {
    /* Converter */
    single { Moshi.Builder().build() }
    factory<Converter.Factory>(qualifierJsonConverter) { MoshiConverterFactory.create() }

    /* Interceptors */
    factory<Interceptor>(qualifierHeaderInterceptor) { HeaderInterceptor() }
    factory<Interceptor>(qualifierLoggingInterceptor) {
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    /* Client */
    single(qualifierOkHttpClient) {
        OkHttpClient
            .Builder()
            .addInterceptor(get<Interceptor>(qualifierHeaderInterceptor))
            .addInterceptor(get<Interceptor>(qualifierLoggingInterceptor))
            .build()
    }
    single(qualifierRetrofitClient) {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get(qualifierOkHttpClient))
            .addConverterFactory(get(qualifierJsonConverter))
            .build()
    }

    /* Services */
    single { get<Retrofit>(qualifierRetrofitClient).create(UserApiService::class.java) }
    single { get<Retrofit>(qualifierRetrofitClient).create(StationsApiService::class.java) }
}