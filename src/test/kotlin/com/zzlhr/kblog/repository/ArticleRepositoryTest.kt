package com.zzlhr.kblog.repository

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest
class ArticleRepositoryTest {

    @Autowired lateinit var repository: ArticleRepository;

    @Test
    fun findById(){
        println(repository.findAll())
    }

}