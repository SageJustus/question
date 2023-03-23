package com.sage.feature.article.service.impl

import com.sage.feature.article.service.IArticleService
import com.sage.server.feature.article.database.IArticleRepository
import org.springframework.beans.factory.annotation.Autowired

class ArticleServiceImpl: IArticleService {

    @Autowired
    private lateinit var articleRepository: IArticleRepository

    override fun get() {
        articleRepository.findAll()
    }


}
