package com.zzlhr.kblog.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QArticle is a Querydsl query type for Article
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QArticle extends EntityPathBase<Article> {

    private static final long serialVersionUID = -1420265583L;

    public static final QArticle article = new QArticle("article");

    public final NumberPath<Integer> aid = createNumber("aid", Integer.class);

    public final NumberPath<Integer> articleAuthor = createNumber("articleAuthor", Integer.class);

    public final StringPath articleContentHtml = createString("articleContentHtml");

    public final StringPath articleContentMd = createString("articleContentMd");

    public final StringPath articleDescribe = createString("articleDescribe");

    public final NumberPath<Integer> articleStatus = createNumber("articleStatus", Integer.class);

    public final StringPath articleTitle = createString("articleTitle");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public QArticle(String variable) {
        super(Article.class, forVariable(variable));
    }

    public QArticle(Path<Article> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArticle(PathMetadata metadata) {
        super(Article.class, metadata);
    }

}

