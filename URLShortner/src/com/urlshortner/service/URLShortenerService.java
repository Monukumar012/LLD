package com.urlshortner.service;

import com.urlshortner.dao.URLShortenerDAO;
import com.urlshortner.entity.URL;
import com.urlshortner.exception.SystemExceptionWithUserMessage;
import com.urlshortner.util.Base62;


public class URLShortenerService {
    private final URLShortenerDAO urlShortenerDAO;
    public URLShortenerService(URLShortenerDAO urlShortenerDAO) {
        this.urlShortenerDAO = urlShortenerDAO;
    }
    public String generateShortURL(String longUrl) {
        if(longUrl == null || longUrl.isBlank()) {
            throw new IllegalArgumentException("Long URL cannot be empty");
        }
        if(urlShortenerDAO.isLongUrlExists(longUrl)) {
            return urlShortenerDAO.getShortUrl(longUrl);
        }
        Long uniqueId = urlShortenerDAO.generateUniqueID();
        String shortUrl = Base62.encode(uniqueId);
        URL url = new URL(longUrl, shortUrl, uniqueId);
        urlShortenerDAO.saveURL(url);
        return shortUrl;
    }

    public String getActualURL(String shortUrl) {
        return urlShortenerDAO.getLongUrl(shortUrl);
    }
}