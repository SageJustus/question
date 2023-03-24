package com.sage.server.feature.article.database

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IArticleRepository: JpaRepository<ArticleEntity, Long> {

}
