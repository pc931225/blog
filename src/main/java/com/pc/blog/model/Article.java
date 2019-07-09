package com.pc.blog.model;

import java.util.Date;

public class Article {
    private Integer id;

    private String tittle;

    private Integer classify;

    private Integer isTop;

    private Integer essences;

    private Date createTime;

    private String content;

    public Article(Integer id, String tittle, Integer classify, Integer isTop, Integer essences, Date createTime) {
        this.id = id;
        this.tittle = tittle;
        this.classify = classify;
        this.isTop = isTop;
        this.essences = essences;
        this.createTime = createTime;
    }

    public Article(Integer id, String tittle, Integer classify, Integer isTop, Integer essences, Date createTime, String content) {
        this.id = id;
        this.tittle = tittle;
        this.classify = classify;
        this.isTop = isTop;
        this.essences = essences;
        this.createTime = createTime;
        this.content = content;
    }

    public Article() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle == null ? null : tittle.trim();
    }

    public Integer getClassify() {
        return classify;
    }

    public void setClassify(Integer classify) {
        this.classify = classify;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getEssences() {
        return essences;
    }

    public void setEssences(Integer essences) {
        this.essences = essences;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}