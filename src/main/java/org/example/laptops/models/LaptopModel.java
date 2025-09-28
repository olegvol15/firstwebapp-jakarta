package org.example.laptops.models;

import java.util.List;

public class LaptopModel {
    private final String id;
    private final String name;
    private final String shortDesc;
    private final String thumbPath;
    private final List<String> gallery;

    public LaptopModel(String id, String name, String shortDesc, String thumbPath, List<String> gallery) {
        this.id = id; this.name = name; this.shortDesc = shortDesc; this.thumbPath = thumbPath; this.gallery = gallery;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getShortDesc() { return shortDesc; }
    public String getThumbPath() { return thumbPath; }
    public List<String> getGallery() { return gallery; }
}
