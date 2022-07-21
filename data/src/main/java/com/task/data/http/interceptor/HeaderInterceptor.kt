package com.task.data.http.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .method(originalRequest.method, originalRequest.body)
            .apply {
                addHeader("Authorization","d0c9b1ec-06bd-11ed-b697-0242ac130002-d0c9b250-06bd-11ed-b697-0242ac130002")
            }
            .build()
        return chain.proceed(requestBuilder)
    }
}