package com.sage.feature.article.api

import com.sage.feature.article.service.IArticleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/article")
class ArticleController {

    @Autowired
    private lateinit var articleService: IArticleService

    @GetMapping("/1")
    fun get(){
        return articleService.get()
    }

}
