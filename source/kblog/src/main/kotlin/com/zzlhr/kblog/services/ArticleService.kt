package com.zzlhr.kblog.services

import com.querydsl.core.BooleanBuilder
import com.querydsl.jpa.impl.JPAQuery
import com.querydsl.jpa.impl.JPAQueryFactory
import com.zzlhr.kblog.entity.*
import com.zzlhr.kblog.exception.KBlogException
import com.zzlhr.kblog.exception.KBlogExceptionEnum
import com.zzlhr.kblog.vo.ArticleListVO
import com.zzlhr.kblog.vo.ArticleVO
import com.zzlhr.kblog.vo.Page
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

interface ArticleService {

    /**
     * 获取文章列表
     * @param keyword  文章关键字
     * @param tag      文章标签
     * @param page     页数
     * @param pageSize 每页数量
     */
    fun getArticleList(keyword: String, tag: String,
                       author: Int, status: Int,
                       page: Long, pageSize: Long): Page<ArticleListVO>



    fun getArticle(aid: Int): ArticleVO
}


@Service
class ArticleServiceImpl
@Autowired constructor(entityManager: EntityManager) : ArticleService {


    private final var queryFactor: JPAQueryFactory = JPAQueryFactory(entityManager)


    override fun getArticle(aid: Int): ArticleVO {
        val qArticle: QArticle = QArticle.article
        val qArticleInfo: QArticleInfo = QArticleInfo.articleInfo
        val qUser: QUser = QUser.user
        val qArticleTag: QArticleTag = QArticleTag.articleTag


        val article: ArticleVO =
                queryFactor
                        .select(Pbs.articleBean).from(qArticle)
                        .leftJoin(qArticleInfo)
                        .on(qArticle.aid.eq(qArticleInfo.aid))
                        .leftJoin(qUser)
                        .on(qArticle.articleAuthor.eq(qUser.uid))
                        .where(qArticle.aid.eq(aid))
                        .fetchOne() ?:
                throw KBlogException(KBlogExceptionEnum.ARTICLE_NOT_EXIST)


        // 循环获取文章id


        // 查询tag
        val articleTagQuery: JPAQuery<ArticleTag> =
                queryFactor
                        .selectFrom(qArticleTag)
                        .where(qArticleTag.aid.eq(article.aid))
        val articleTags = articleTagQuery.fetch()

        // 添加tag到文章vo对象
        for (tag in articleTags) {
            article.tags.add(tag.tagContent)
        }

        return article
    }

    override fun getArticleList(keyword: String,
                                tag: String,
                                author: Int,
                                status: Int,
                                page: Long,
                                pageSize: Long): Page<ArticleListVO> {
        val qArticle: QArticle = QArticle.article
        val qArticleInfo: QArticleInfo = QArticleInfo.articleInfo
        val qUser: QUser = QUser.user
        val qArticleTag: QArticleTag = QArticleTag.articleTag

        val builder = BooleanBuilder()

        if (!keyword.isEmpty()) {
            builder.and(qArticle.articleTitle.like("%$keyword%"))
        }
        if (!tag.isEmpty()) {
            builder.and(qArticle.articleTitle.like("%$keyword%"))
        }

        // if author is 0 this select operate not select author
//        if(author != 0){
//            builder.and(qArticle.articleAuthor.eq(author))
//        }
//
//        builder.and(qArticle.articleStatus.eq(status))


        val articleListQuery: JPAQuery<ArticleListVO> =
                queryFactor
                        .select(Pbs.articleListBean).from(qArticle)
                        .leftJoin(qArticleInfo)
                        .on(qArticle.aid.eq(qArticleInfo.aid))
                        .leftJoin(qUser)
                        .on(qArticle.articleAuthor.eq(qUser.uid))
                        .where(builder)
                        .offset((page - 1) * pageSize)
                        .limit(pageSize)

        val result: Page<ArticleListVO> =
                Page<ArticleListVO>().init(articleListQuery, pageSize)

        // 查询出来的文章列表
        val articleList: ArrayList<ArticleListVO> =
                articleListQuery.fetch() as ArrayList<ArticleListVO>


        // 循环获取文章id

        val articleIds = ArrayList<Int>()
        articleList.forEach {
            articleListVO -> articleIds.add(articleListVO.aid)
        }


        // 查询tag
        val articleTagQuery = queryFactor
                .selectFrom(qArticleTag)
                .where(qArticleTag.aid.`in`(articleIds))
        val articleTags = articleTagQuery.fetch()

        // 添加tag到文章vo对象
        for (article in articleList) {
            for (t in articleTags) {
                if (article.aid == t.aid) {
                    article.tags.add(t.tagContent)
                }
            }
        }
        result.arr = articleList

        return result

    }
}

