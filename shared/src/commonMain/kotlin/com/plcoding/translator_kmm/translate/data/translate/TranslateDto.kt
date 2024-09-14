package com.plcoding.translator_kmm.translate.data.translate

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class TranslateDto(
    @SerialName("q") val textToTranslate: String,
    @SerialName("source") val sourceLanguageCode: String,
    @SerialName("target") val targetLanguageCode: String
)
