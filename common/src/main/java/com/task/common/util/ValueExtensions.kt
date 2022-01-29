package com.task.common.util

import java.util.*

val String.Companion.EMPTY: String
    get() = ""

val String.Companion.NEW_LINE: String
    get() = "\n"

val String.Companion.SPACE: String
    get() = " "

val String.Companion.SEPARATOR: String
    get() = ":"

val String.Companion.RANDOM: String
    get() = UUID.randomUUID().toString()

fun Int?.isGreaterThan(other: Int?) =
    this != null && other != null && this > other

fun Int?.isLessThan(other: Int?) =
    this != null && other != null && this < other