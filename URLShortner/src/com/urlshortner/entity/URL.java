package com.urlshortner.entity;

public class URL {
    private String longUrl;
    private String shortUrl;
    private Long uniqueId;

    public URL(String longUrl, String shortUrl, Long uniqueId) {
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
        this.uniqueId = uniqueId;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Long uniqueId) {
        this.uniqueId = uniqueId;
    }
}