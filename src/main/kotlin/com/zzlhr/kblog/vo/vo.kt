package com.zzlhr.kblog.vo

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.util.*
import kotlin.collections.ArrayList
import com.querydsl.jpa.impl.JPAQuery
import com.zzlhr.kblog.MarkdownConverter
import org.springframework.beans.factory.annotation.Autowired


class Page<T> {

    // 总页数
     var totalPage: Long = 0
    // 每页数量
     val pageSize: Long = 10
    // 当前页码
     var currentPage: Long = 0
    // 总条数
     var totalCount: Long = 0
    // 本页数量
     var currentNumber: Long = 0

     var arr: ArrayList<T> = ArrayList();

    fun init(totalCount: Long, currentPage: Long, arr: ArrayList<T>): Page<T> {
        this.currentPage = currentPage
        this.arr = arr
        this.totalCount = totalCount
        this.totalPage = totalCount / pageSize
        this.currentNumber = arr.size.toLong()
        if (totalCount % pageSize > 0) {
            this.totalPage += 1
        }
        return this
    }

    fun init(jpaQuery: JPAQuery<T>, pageSize: Long): Page<T> {
        this.arr = jpaQuery.fetch() as ArrayList<T>
        this.totalCount = jpaQuery.fetchCount()
        this.totalPage = totalCount / pageSize
        this.currentNumber = arr.size.toLong()
        if (totalCount % pageSize > 0) {
            this.totalPage += 1
        }
        return this
    }

    override fun toString(): String {
        return "Page(totalPage=$totalPage, pageSize=$pageSize, currentPage=$currentPage, totalCount=$totalCount, currentNumber=$currentNumber, arr=$arr)"
    }

}


class ArticleListVO {

    var aid: Int = 0
    var articleTitle: String = ""
    var articleAuthorName: String = ""
    var articleDescribe: String = ""
    var articleStatus: Int = 0
    var createTime: Date = Date(0)
    var updateTime: Date = Date(0)
    var articleClick: Int = 0
    var articleCommemtNumber: Int = 0
    var articleZan: Int = 0
    var tags: ArrayList<String> = ArrayList();

    override fun toString(): String {
        return "ArticleListVO(aid=$aid, articleTitle='$articleTitle', articleAuthorName='$articleAuthorName', articleDescribe='$articleDescribe', articleStatus=$articleStatus, createTime=$createTime, updateTime=$updateTime, articleClick=$articleClick, articleCommemtNumber=$articleCommemtNumber, articleZan=$articleZan, tags=$tags)"
    }
}

class ArticleVO {



    var aid: Int = 0
    var articleTitle: String = ""
    var articleAuthorName: String = ""
    var articleDescribe: String = ""
    var articleContentHtml: String = ""
    var articleContentMd: String = ""
    var articleStatus: Int = 0
    var createTime: Date = Date(0)
    var updateTime: Date = Date(0)
    var articleClick: Int = 0
    var articleCommemtNumber: Int = 0
    var articleZan: Int = 0
    var tags: ArrayList<String> = ArrayList();

    override fun toString(): String {
        return "ArticleVO(aid=$aid, articleTitle='$articleTitle', articleAuthorName='$articleAuthorName', articleDescribe='$articleDescribe', articleContentHtml='$articleContentHtml', articleContentMd='$articleContentMd', articleStatus=$articleStatus, createTime=$createTime, updateTime=$updateTime, articleClick=$articleClick, articleCommemtNumber=$articleCommemtNumber, articleZan=$articleZan, tags=$tags)"
    }


}