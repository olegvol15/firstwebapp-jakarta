package org.example.laptops.models;

public class NewsItem {
    private final String id;
    private final String title;
    private final String summary;
    private final String imagePath; // /images/news1.jpg

    public NewsItem(String id, String title, String summary, String imagePath) {
        this.id = id; this.title = title; this.summary = summary; this.imagePath = imagePath;
    }
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getSummary() { return summary; }
    public String getImagePath() { return imagePath; }
}

