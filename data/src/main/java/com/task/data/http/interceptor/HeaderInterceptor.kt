package com.task.data.http.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .method(originalRequest.method, originalRequest.body)
            .apply {
//                addHeader() FIXME add headers here
            }
            .build()
        return chain.proceed(requestBuilder)
    }
}