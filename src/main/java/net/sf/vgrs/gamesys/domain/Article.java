package net.sf.vgrs.gamesys.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {
    private String url;
    private ArticleSource source;
    private String author;
    private String title;
    private Date publishedDate;
    private String description;
    private String content;

    public Article() {

    }

    public Article(String url, String author, String title, Date publishedDate, String description, String content) {
        this.url = url;
        this.source = source;
        this.author = author;
        this.title = title;
        this.publishedDate = publishedDate;
        this.description = description;
        this.content = content;
    }

    public Article(String url, ArticleSource source, String author, String title, Date publishedDate, String description, String content) {
        this.url = url;
        this.source = source;
        this.author = author;
        this.title = title;
        this.publishedDate = publishedDate;
        this.description = description;
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArticleSource getSource() {
        return source;
    }

    public void setSource(ArticleSource source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("publishedAt")
    public Date getPublishedDate() {
        return publishedDate;
    }

    @JsonProperty("publishedAt")
    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public Article clone() throws CloneNotSupportedException {
        return (Article) super.clone();
    }
}
