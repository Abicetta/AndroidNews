package com.abicetta.androidnews;

public class Article {
    /**
     * Title
     */
    private String mTitle;
    /**
     * The text of the article
     */
    private String mArticle;
    /**
     * Date
     */
    private String mDate;
    /**
     * Section
     */
    private String mSection;
    /**
     * Website URL of the articles
     */
    private String mUrl;
    /**
     * Author of the articles
     */
    private String mAuthor;

    /**
     * Create a new Earthquake object. (the constructor)
     *
     * @param webTitle           is the title of the article
     * @param webPublicationDate is the date of the publication of the article
     * @param sectionName        is the name of the section of the article
     * @param webUrl             is the url for link to the Guardian page of the article
     * @param author             is the name of the author
     */
    public Article(String webTitle, String webPublicationDate, String webUrl, String sectionName, String author) {
        mTitle = webTitle;
        mDate = webPublicationDate;
        mUrl = webUrl;
        mSection = sectionName;
        mAuthor = author;
    }

    /**
     * Get the title
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Get the the date.
     */
    public String getDate() {
        return mDate;
    }

    /**
     * Returns the website URL to find the article.
     */
    public String getUrl() {
        return mUrl;
    }

    /**
     * Returns the section  of the article.
     */
    public String getSection() {
        return mSection;
    }

    /**
     * Returns the author of the article.
     */
    public String getAuthor() {
        return mAuthor;
    }
}