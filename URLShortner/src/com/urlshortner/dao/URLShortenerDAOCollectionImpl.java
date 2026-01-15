package com.urlshortner.dao;

import com.urlshortner.entity.URL;
import com.urlshortner.exception.URLNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class URLShortenerDAOCollectionImpl implements URLShortenerDAO{
    private final AtomicLong uniqueIdGenerator = new AtomicLong(0);
    private final Map<String, URL> longUrlMap;
    private final Map<String, URL> shortUrlMap;
    public URLShortenerDAOCollectionImpl() {
        longUrlMap = new HashMap<>();
        shortUrlMap = new HashMap<>();
    }


    @Override
    public Long generateUniqueID() {
        return uniqueIdGenerator.getAndIncrement();
    }

    @Override
    public void saveURL(URL url) {
        longUrlMap.put(url.getLongUrl(), url);
        shortUrlMap.put(url.getShortUrl(), url);
    }

    @Override
    public boolean isLongUrlExists(String longUrl) {
        return longUrlMap.containsKey(longUrl);
    }

    public String getShortUrl(String longUrl) {
        URL url = longUrlMap.get(longUrl);
        if(url == null) {
            throw new URLNotFoundException("URL not found for : "+ longUrl);
        }
        return url.getShortUrl();
    }

    public String getLongUrl(String shortUrl) {
        URL url = shortUrlMap.get(shortUrl);
        if(url == null) {
            throw new URLNotFoundException("URL not found for : "+ url);
        }
        return url.getLongUrl();
    }
}