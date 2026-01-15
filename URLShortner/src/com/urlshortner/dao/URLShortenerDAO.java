package com.urlshortner.dao;

import com.urlshortner.entity.URL;

public interface URLShortenerDAO {
    Long generateUniqueID();
    void saveURL(URL url);
    boolean isLongUrlExists(String longUrl);
    String getShortUrl(String longUrl);
    URL getActualURL(String shortUrl);
}