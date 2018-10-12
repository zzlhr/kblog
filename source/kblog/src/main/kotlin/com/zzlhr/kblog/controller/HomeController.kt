package com.zzlhr.kblog.controller

import com.zzlhr.kblog.MarkdownConverter
import com.zzlhr.kblog.services.ArticleService
import com.zzlhr.kblog.vo.ArticleListVO
import com.zzlhr.kblog.vo.ArticleVO
import com.zzlhr.kblog.vo.Page
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@Controller
class HomeController {
    private var markdownConverter: MarkdownConverter? = null


    private final var articleService: ArticleService? = null;

    @Autowired
    fun HomeController(articleService: ArticleService, markdownConverter:MarkdownConverter){
        this.articleService = articleService;
        this.markdownConverter = markdownConverter

    }


    @GetMapping("/index.html")
    fun index(model: Model): String{
        val articleList:Page<ArticleListVO> =
                articleService!!.getArticleList("", "",0,0,1, 10);
        model["articles"] = articleList;
        return "index"
    }


    @GetMapping("/search.html")
    fun search(keyword: String, model: Model): String{
        val articleList:Page<ArticleListVO> =
                articleService!!.getArticleList(keyword, "",0,0,1, 10);
        model["articles"] = articleList;
        return "index"
    }

    @GetMapping("/article/{aid:.+}")
    fun article(@PathVariable aid:String, model: Model): String{
        println(aid)
        val id: Int = (aid.split(".")[0]).toInt()
        println(id)
        val article: ArticleVO = articleService!!.getArticle(id)
        article.articleContentMd = markdownConverter!!.invoke(article.articleContentMd)
        model["article"] = article
        return "article"
    }

}