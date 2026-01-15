package com.urlshortner.entity;

public final class URL {
    private final String longUrl;
    private final String shortUrl;
    private final Long uniqueId;
    private final Long expiryTime;

    public URL(String longUrl, String shortUrl, Long uniqueId, Long expiryTime) {
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
        this.uniqueId = uniqueId;
        this.expiryTime = expiryTime;
    }

    public String getLongUrl() {
        return longUrl;
    }


    public String getShortUrl() {
        return shortUrl;
    }

    public Long getUniqueId() {
        return uniqueId;
    }

    public boolean isExpired() {
        return expiryTime != null && System.currentTimeMillis() >= expiryTime;
    }
}