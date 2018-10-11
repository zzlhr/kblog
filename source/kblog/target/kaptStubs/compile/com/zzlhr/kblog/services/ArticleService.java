package com.zzlhr.kblog.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/zzlhr/kblog/services/ArticleService;", "", "getArticleList", "", "keyword", "", "tag", "page", "", "pageSize", "kblog"})
public abstract interface ArticleService {
    
    /**
     * * 获取文章列表
     *     * @param keyword  文章关键字
     *     * @param tag      文章标签
     *     * @param page     页数
     *     * @param pageSize 每页数量
     */
    public abstract void getArticleList(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    java.lang.String tag, long page, long pageSize);
}