package com.task.data.di

import com.task.common.model.error.ErrorResponse
import com.task.common.model.user.User
import com.task.data.mapper.ToUserModelMapper
import com.task.data.mapper.base.BaseMapper
import com.task.data.mapper.error.RequestExceptionToBaseErrorMapper
import com.task.data.model.response.UserResponse
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

internal val toErrorResponseMapperQualifier = StringQualifier("toErrorResponseMapperQualifier")
internal val toUserMapperQualifier = StringQualifier("toUserMapperQualifier")

internal val mappersModule = module {
    single<BaseMapper<Throwable, ErrorResponse>>(toErrorResponseMapperQualifier) {
        RequestExceptionToBaseErrorMapper()
    }
    single<BaseMapper<UserResponse, User>>(toUserMapperQualifier) {
        ToUserModelMapper()
    }
}