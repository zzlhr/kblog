package com.zzlhr.kblog.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -587088112L;

    public static final QUser user = new QUser("user");

    public final NumberPath<Integer> admin = createNumber("admin", Integer.class);

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath headerUrl = createString("headerUrl");

    public final StringPath lastLoginAddress = createString("lastLoginAddress");

    public final StringPath lastLoginIp = createString("lastLoginIp");

    public final StringPath loginName = createString("loginName");

    public final StringPath password = createString("password");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath token = createString("token");

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public final NumberPath<Integer> uid = createNumber("uid", Integer.class);

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public final StringPath username = createString("username");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

