package com.zzlhr.kblog.services

import com.querydsl.core.types.Projections
import com.querydsl.core.types.QBean
import com.zzlhr.kblog.entity.QArticle
import com.zzlhr.kblog.entity.QArticleInfo
import com.zzlhr.kblog.entity.QArticleTag
import com.zzlhr.kblog.entity.QUser
import com.zzlhr.kblog.vo.ArticleListVO
import com.zzlhr.kblog.vo.ArticleVO

object Pbs {
    private val qArticle = QArticle.article
    private val qArticleInfo = QArticleInfo.articleInfo
    private val qUser = QUser.user
    private val qArticleTag = QArticleTag.articleTag
    val articleListBean: QBean<ArticleListVO>
        get() = Projections.bean(
                ArticleListVO::class.java,
                qArticle.aid,
                qArticle.articleDescribe,
                qArticle.articleTitle,
                qArticle.articleStatus,
                qArticle.updateTime,
                qArticle.createTime,
                qArticleInfo.articleClick,
                qArticleInfo.articleComment.`as`("articleCommentNumber"),
                qArticleInfo.articleZan,
                qUser.username.`as`("articleAuthorName")
        )

    val articleBean: QBean<ArticleVO>
        get() = Projections.bean(
                ArticleVO::class.java,
                qArticle.aid,
                qArticle.articleDescribe,
                qArticle.articleTitle,
                qArticle.articleContentHtml,
                qArticle.articleContentMd,
                qArticle.articleStatus,
                qArticle.updateTime,
                qArticle.createTime,
                qArticleInfo.articleClick,
                qArticleInfo.articleComment.`as`("articleCommentNumber"),
                qArticleInfo.articleZan,
                qUser.username.`as`("articleAuthorName")
        )
}
