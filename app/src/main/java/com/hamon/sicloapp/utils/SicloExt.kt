package com.hamon.sicloapp.utils

import com.hamon.sicloapp.models.SicloClass

fun Map<String, List<SicloClass>>.getKeysAndValues(): Pair<MutableList<String>, MutableList<List<SicloClass>>>{
    val keyList = mutableListOf<String>()
    val valueList = mutableListOf<List<SicloClass>>()
    this.forEach { (key, value) ->
        keyList.add(key)
        valueList.add(value)
    }
    return Pair(keyList,valueList)
}