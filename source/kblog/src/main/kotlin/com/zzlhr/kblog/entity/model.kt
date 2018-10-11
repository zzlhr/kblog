package com.zzlhr.kblog.entity

import lombok.Data
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id


@Entity
data class Article(
        @Id
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
        val aid: Int,
        val articleClick: Int,
        val articleComment: Int,
        val articleZan: Int
)

@Entity
data class ArticleTag(
        @Id
        val atid: Int,
        val aid: Int,
        val tagContent: String
)