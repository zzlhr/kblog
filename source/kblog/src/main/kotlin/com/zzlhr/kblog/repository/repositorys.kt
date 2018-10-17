package com.zzlhr.kblog.repository

import com.zzlhr.kblog.entity.Article
import com.zzlhr.kblog.entity.ArticleTag
import com.zzlhr.kblog.entity.AuthCode
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository: JpaRepository<Article, Int>



@Repository
interface ArticleTagRepository: JpaRepository<ArticleTag, Int>



@Repository
interface AuthCodeRepository: JpaRepository<AuthCode, String>