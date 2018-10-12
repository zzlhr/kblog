package com.zzlhr.kblog.services

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest
class ArticleRepositoryTest {

    @Autowired
    lateinit var service: ArticleService;

    @Test
    fun findById(){
//        println(service.getArticleList("","",1, 10))
    }

}