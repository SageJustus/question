package com.sage.feature.article.service

import com.sage.server.feature.article.database.ArticleEntity
import org.springframework.stereotype.Service

interface IArticleService {


    fun get(): ArticleEntity?

}
