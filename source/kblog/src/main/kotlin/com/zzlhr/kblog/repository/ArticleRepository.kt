package com.zzlhr.kblog.repository

import com.zzlhr.kblog.entity.Article
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository: JpaRepository<Article, Int>