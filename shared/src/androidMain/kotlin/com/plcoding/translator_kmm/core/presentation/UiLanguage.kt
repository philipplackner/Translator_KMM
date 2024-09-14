package com.plcoding.translator_kmm.core.presentation

import androidx.annotation.DrawableRes
import com.plcoding.translator_kmm.R
import com.plcoding.translator_kmm.core.domain.language.Language
import java.util.Locale

actual data class UiLanguage(
    @DrawableRes val drawableRes: Int,
    actual val language: Language
) {
    fun toLocale(): Locale? {
        return when(language) {
            Language.ENGLISH -> Locale.ENGLISH
            Language.CHINESE -> Locale.CHINESE
            Language.FRENCH -> Locale.FRENCH
            Language.GERMAN -> Locale.GERMAN
            Language.ITALIAN -> Locale.ITALIAN
            Language.JAPANESE -> Locale.JAPANESE
            Language.KOREAN -> Locale.KOREAN
            else -> null
        }
    }

    actual companion object {
        actual fun byCode(langCode: String): UiLanguage {
            return allLanguages.find { it.language.langCode == langCode }
                ?: throw IllegalArgumentException("Invalid or unsupported language code")
        }

        actual val allLanguages: List<UiLanguage>
            get() = Language.values().map { language ->
                UiLanguage(
                    language = language,
                    drawableRes = when(language) {
                        Language.ENGLISH -> R.drawable.english
                        Language.ARABIC -> R.drawable.arabic
                        Language.AZERBAIJANI -> R.drawable.azerbaijani
                        Language.CHINESE -> R.drawable.chinese
                        Language.CZECH -> R.drawable.czech
                        Language.DANISH -> R.drawable.danish
                        Language.DUTCH -> R.drawable.dutch
                        Language.FINNISH -> R.drawable.finnish
                        Language.FRENCH -> R.drawable.french
                        Language.GERMAN -> R.drawable.german
                        Language.GREEK -> R.drawable.greek
                        Language.HEBREW -> R.drawable.hebrew
                        Language.HINDI -> R.drawable.hindi
                        Language.HUNGARIAN -> R.drawable.hungarian
                        Language.INDONESIAN -> R.drawable.indonesian
                        Language.IRISH -> R.drawable.irish
                        Language.ITALIAN -> R.drawable.italian
                        Language.JAPANESE -> R.drawable.japanese
                        Language.KOREAN -> R.drawable.korean
                        Language.PERSIAN -> R.drawable.persian
                        Language.POLISH -> R.drawable.polish
                        Language.PORTUGUESE -> R.drawable.portuguese
                        Language.RUSSIAN -> R.drawable.russian
                        Language.SLOVAK -> R.drawable.slovak
                        Language.SPANISH -> R.drawable.spanish
                        Language.SWEDISH -> R.drawable.swedish
                        Language.TURKISH -> R.drawable.turkish
                        Language.UKRAINIAN -> R.drawable.ukrainian
                    }
                )
            }.sortedBy { it.language.langName }
    }
}