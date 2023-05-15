package com.sage.mapper

import java.time.LocalDateTime

data class SourceItemEntity(
    val id: Long? = null,
    val title: String? = "",
    val description: String = "",
    val gmtCreate: LocalDateTime? = null,
    val gmtModified: LocalDateTime? = null,
    val deleted: Boolean = false,
    val walled: Boolean = false,
    val favicon: Long? = null,
    val cover: Long? = null,
    val top: Boolean = false,
    val pid: Long? = null,
    val dislikeCount: Int = 0,
    val likeCount: Int = 0,
    val viewCount: Int = 0,
    val favoriteCount: Int = 0,
    val repostCount: Int = 0,
    val commentCount: Int = 0,
    val rate: Int = 0
)
