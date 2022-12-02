package com.plcoding.translator_kmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform