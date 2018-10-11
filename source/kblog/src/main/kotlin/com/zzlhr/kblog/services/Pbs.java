package com.zzlhr.kblog.services;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;
import com.zzlhr.kblog.entity.QArticle;
import com.zzlhr.kblog.entity.QArticleInfo;
import com.zzlhr.kblog.entity.QArticleTag;
import com.zzlhr.kblog.entity.QUser;
import com.zzlhr.kblog.vo.ArticleListVO;
import com.zzlhr.kblog.vo.ArticleVO;

public class Pbs {
    private static QArticle qArticle = QArticle.article;
    private static QArticleInfo qArticleInfo = QArticleInfo.articleInfo;
    private static QUser qUser = QUser.user;
    private static QArticleTag qArticleTag = QArticleTag.articleTag;
    public static QBean<ArticleListVO> getArticleListBean(){
        return Projections.bean(
                ArticleListVO.class,
                qArticle.aid,
                qArticle.articleDescribe,
                qArticle.articleTitle,
                qArticle.articleStatus,
                qArticle.updateTime,
                qArticle.createTime,
                qArticleInfo.articleClick,
                qArticleInfo.articleComment.as("articleCommentNumber"),
                qArticleInfo.articleZan,
                qUser.username.as("articleAuthorName")
        );
    }

    public static QBean<ArticleVO> getArticleBean(){
        return Projections.bean(
                ArticleVO.class,
                qArticle.aid,
                qArticle.articleDescribe,
                qArticle.articleTitle,
                qArticle.articleContentHtml,
                qArticle.articleContentMd,
                qArticle.articleStatus,
                qArticle.updateTime,
                qArticle.createTime,
                qArticleInfo.articleClick,
                qArticleInfo.articleComment.as("articleCommentNumber"),
                qArticleInfo.articleZan,
                qUser.username.as("articleAuthorName")
        );
    }
}
