package com.sage.server.feature.article.database

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Table(name = "t_article")
@Entity
class ArticleEntity(
    @Id
    val id: Long,
    val title: String,
    val description: String? = null,
    @Column(name = "publish_time") val publishTime: LocalDateTime? = null,
    @Column(name = "author_id") val authorId: String? = null,
    @Column(name = "author_name") val authorName: String? = null,
    @Column(name = "gmt_create") var gmtCreate: LocalDateTime? = null,
    @Column(name = "gmt_modified") val gmtModified: LocalDateTime = LocalDateTime.now(),
    val url: String,
    val read: Boolean = false,
    @Column(name = "work_id") val workId: Int = -1
)
