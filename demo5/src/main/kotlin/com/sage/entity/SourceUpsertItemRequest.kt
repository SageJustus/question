package com.sage.entity

data class SourceUpsertItemRequest(
    val title: String = "",
    val id: Long? = null,
    val category: List<Int> = mutableListOf(),
    val tag: List<Int> = mutableListOf(),
    val description: String = "",
    val walled: Boolean = false,
    val favicon: Long? = null,
    val cover: Long? = null,
    val top: Boolean = false,
    val pid: Long = 0,
    val urls: List<SourceUpsertItemRequestUrl> = mutableListOf()
)

data class SourceUpsertItemRequestUrl(
    val title: String,
    val url: String,
    val main: Boolean
)
