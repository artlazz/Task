package com.task.data.model

data class LoginDto(
    val sha1: String? = null,
    val password: String? = null,
    val salt: String? = null,
    val sha256: String? = null,
    val uuid: String? = null,
    val username: String? = null,
    val md5: String? = null
)
