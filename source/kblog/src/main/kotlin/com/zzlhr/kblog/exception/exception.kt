package com.zzlhr.kblog.exception

import java.lang.RuntimeException


class KBlogException(e: KBlogExceptionEnum): RuntimeException(e.msg_)


enum class KBlogExceptionEnum(code: Int, msg: String){
    ARTICLE_NOT_EXIST(10000, "文章不存在"),

    ;

    val code_: Int = code
    val msg_: String = msg

}