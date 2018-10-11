package com.zzlhr.kblog.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/zzlhr/kblog/services/ArticleServiceImpl;", "Lcom/zzlhr/kblog/services/ArticleService;", "()V", "entityManager", "Ljavax/persistence/EntityManager;", "queryFactor", "Lcom/querydsl/jpa/impl/JPAQueryFactory;", "getArticleList", "", "keyword", "", "tag", "page", "", "pageSize", "kblog"})
@org.springframework.stereotype.Service()
public class ArticleServiceImpl implements com.zzlhr.kblog.services.ArticleService {
    @org.springframework.beans.factory.annotation.Autowired()
    private javax.persistence.EntityManager entityManager;
    private com.querydsl.jpa.impl.JPAQueryFactory queryFactor;
    
    @java.lang.Override()
    public void getArticleList(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    java.lang.String tag, long page, long pageSize) {
    }
    
    public ArticleServiceImpl() {
        super();
    }
}