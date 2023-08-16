package com.example.emailconfiguration.model;

public class MailConfig {
    private int id;
    private String languages;
    private String pageSize;
    private String spam;
    private String signature;

    public MailConfig() {

    }

    public MailConfig(int id, String languages, String pageSize, String spam, String signature) {
        this.id = id;
        this.languages = languages;
        this.pageSize = pageSize;
        this.spam = spam;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getSpam() {
        return spam;
    }

    public void setSpam(String spam) {
        this.spam = spam;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
