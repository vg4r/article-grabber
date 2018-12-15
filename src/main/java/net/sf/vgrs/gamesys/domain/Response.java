package net.sf.vgrs.gamesys.domain;

import java.util.List;

public class Response {

    public enum ResponseStatuses{
        OK("ok"),
        ERROR("error");

        private String value;

        ResponseStatuses(String value){
            this.value = value;
        }

        public String value(){
            return value;
        }

    }

    public Response(){
        this.status = ResponseStatuses.OK.value();
    }

    public Response(ResponseStatuses status){
        this.status = status.value();
    }

    public Response(String status){
        this.status = status;
    }

    private int totalResults;
    private String status;

    private List<Article> articles;

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
