package com.plcoding.translator_kmm.translate.data.local

import com.plcoding.translator_kmm.core.domain.util.CommonFlow
import com.plcoding.translator_kmm.core.domain.util.toCommonFlow
import com.plcoding.translator_kmm.translate.domain.history.HistoryDataSource
import com.plcoding.translator_kmm.translate.domain.history.HistoryItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.coroutines.CoroutineContext

class FakeHistoryDataSource: HistoryDataSource {

    private val _data = MutableStateFlow<List<HistoryItem>>(emptyList())

    override fun getHistory(context: CoroutineContext): CommonFlow<List<HistoryItem>> {
        return _data.toCommonFlow()
    }

    override suspend fun insertHistoryItem(item: HistoryItem) {
        _data.value += item
    }
}