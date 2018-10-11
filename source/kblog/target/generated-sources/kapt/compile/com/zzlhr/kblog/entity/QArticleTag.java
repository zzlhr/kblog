package com.zzlhr.kblog.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QArticleTag is a Querydsl query type for ArticleTag
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QArticleTag extends EntityPathBase<ArticleTag> {

    private static final long serialVersionUID = -1409066423L;

    public static final QArticleTag articleTag = new QArticleTag("articleTag");

    public final NumberPath<Integer> aid = createNumber("aid", Integer.class);

    public final NumberPath<Integer> atid = createNumber("atid", Integer.class);

    public final StringPath tagContent = createString("tagContent");

    public QArticleTag(String variable) {
        super(ArticleTag.class, forVariable(variable));
    }

    public QArticleTag(Path<ArticleTag> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArticleTag(PathMetadata metadata) {
        super(ArticleTag.class, metadata);
    }

}

