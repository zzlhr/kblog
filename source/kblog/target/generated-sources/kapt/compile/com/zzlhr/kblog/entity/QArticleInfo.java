package com.zzlhr.kblog.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QArticleInfo is a Querydsl query type for ArticleInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QArticleInfo extends EntityPathBase<ArticleInfo> {

    private static final long serialVersionUID = -731701281L;

    public static final QArticleInfo articleInfo = new QArticleInfo("articleInfo");

    public final NumberPath<Integer> aid = createNumber("aid", Integer.class);

    public final NumberPath<Integer> articleClick = createNumber("articleClick", Integer.class);

    public final NumberPath<Integer> articleComment = createNumber("articleComment", Integer.class);

    public final NumberPath<Integer> articleZan = createNumber("articleZan", Integer.class);

    public QArticleInfo(String variable) {
        super(ArticleInfo.class, forVariable(variable));
    }

    public QArticleInfo(Path<ArticleInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArticleInfo(PathMetadata metadata) {
        super(ArticleInfo.class, metadata);
    }

}

