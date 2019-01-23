package com.swp.elasticsearch.model;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-22 2:17 PM
 */

@Document(indexName = "elasticsearch", type = "article")
//indexName索引名称 可以理解为数据库名 必须为小写 不然会报org.elasticsearch.indices.InvalidIndexNameException异常
//type类型 可以理解为表名
public class ArticleEntity implements Serializable {

    private Long id;

    // 作者信息
    private String writer;

    private String title;
    private String content;
    // 归属信息
    private Long admin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getAdmin() {
        return admin;
    }

    public void setAdmin(Long admin) {
        this.admin = admin;
    }
}
