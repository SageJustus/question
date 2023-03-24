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
    val title: String
)
