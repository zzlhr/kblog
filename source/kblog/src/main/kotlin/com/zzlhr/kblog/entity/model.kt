package com.zzlhr.kblog.entity

import java.util.*
import javax.persistence.*


@Entity
data class Article(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val aid: Int,
        val articleTitle: String,
        val articleDescribe: String,
        val articleContentHtml: String,
        val articleContentMd: String,
        val articleAuthor: Int,
        val articleStatus: Int,
        @Column(insertable = false, updatable = false)
        val createTime: Date,
        @Column(insertable = false, updatable = false)
        val updateTime: Date
)


@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val uid: Int,
        val loginName: String,
        val username: String,
        val password: String,
        val token: String,
        val headerUrl: String,
        val createTime: Date,
        val updateTime: Date,
        val lastLoginIp: String,
        val lastLoginAddress: String,
        val status: Int,
        val admin: Int,
        val type: Int
)

@Entity
data class ArticleInfo(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val aid: Int,
        val articleClick: Int,
        val articleComment: Int,
        val articleZan: Int
)

@Entity
data class ArticleTag(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val atid: Int,
        val aid: Int,
        val tagContent: String
)