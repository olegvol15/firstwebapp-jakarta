package org.example.laptops.repo;

import org.example.laptops.models.*;

import java.util.List;
import java.util.Optional;

public class DataStore {
    private static final Manufacturer MANUFACTURER = new Manufacturer(
            "Lenovo", "Китай", "/images/logo.png", 77000,
            "Lenovo — міжнародний виробник ПК і ноутбуків. Відомі лінійки: ThinkPad, Legion, Yoga."
    );

    private static final List<NewsItem> NEWS = List.of(
            new NewsItem("n1", "Lenovo представила нову серію Legion",
                    "Ігрові ноутбуки з покращеним охолодженням та сучасними GPU.",
                    "/images/news1.jpg"),
            new NewsItem("n2", "Оновлення лінійки ThinkPad",
                    "Класичний дизайн, менша вага, триваліший час роботи від батареї.",
                    "/images/news2.jpg")
    );

    private static final List<LaptopModel> MODELS = List.of(
            new LaptopModel("m1", "Legion 5",
                    "Ігровий ноутбук з RTX та високою частотою екрана.",
                    "/images/m1-thumb.jpg",
                    List.of("/images/m1-1.jpg", "/images/m1-2.jpg", "/images/m1-3.jpg")),
            new LaptopModel("m2", "ThinkPad X1 Carbon",
                    "Легкий бізнес-ультрабук із карбоновим корпусом.",
                    "/images/m2-thumb.jpg",
                    List.of("/images/m2-1.jpg", "/images/m2-2.jpg"))
    );

    public static Manufacturer getManufacturer() { return MANUFACTURER; }
    public static List<NewsItem> getNews() { return NEWS; }
    public static List<LaptopModel> getModels() { return MODELS; }
    public static Optional<LaptopModel> findModel(String id) {
        return MODELS.stream().filter(m -> m.getId().equals(id)).findFirst();
    }
}

