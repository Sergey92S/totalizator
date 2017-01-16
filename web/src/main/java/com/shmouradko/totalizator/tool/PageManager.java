package com.shmouradko.totalizator.tool;

import java.util.ResourceBundle;

/**
 * Created by Revotech on 13.12.2016.
 */
public class PageManager {
    public volatile static PageManager instance;
    private static ResourceBundle bundle;

    public static final String BUNDLE_NAME = "page";

    // #PAGES
    public static final String PATH_PAGE_RATE = "PATH_PAGE_RATE";
    public static final String PATH_PAGE_MATCH = "PATH_PAGE_MATCH";
    public static final String PATH_PAGE_COMPETITION = "PATH_PAGE_COMPETITION";
    public static final String PATH_PAGE_COMPETITION_USER = "PATH_PAGE_COMPETITION_USER";
    public static final String PATH_PAGE_COMPETITION_ADMIN = "PATH_PAGE_COMPETITION_ADMIN";
    public static final String PATH_PAGE_MATCH_USER = "PATH_PAGE_MATCH_USER";

    public static PageManager getInstance() {
        if (instance == null) {
            synchronized (PageManager.class) {
                if (instance == null) {
                    instance = new PageManager();
                    bundle = ResourceBundle.getBundle(BUNDLE_NAME);
                }
            }
        }
        return instance;
    }

    public String getProperty(String key) {
        return bundle.getString(key);
    }
}
