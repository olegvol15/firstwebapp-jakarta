package org.example.laptops.models;

public class Manufacturer {
    private final String name;
    private final String hqCountry;
    private final String logoPath; // /images/logo.png
    private final int employees;
    private final String about;

    public Manufacturer(String name, String hqCountry, String logoPath, int employees, String about) {
        this.name = name;
        this.hqCountry = hqCountry;
        this.logoPath = logoPath;
        this.employees = employees;
        this.about = about;
    }
    public String getName() { return name; }
    public String getHqCountry() { return hqCountry; }
    public String getLogoPath() { return logoPath; }
    public int getEmployees() { return employees; }
    public String getAbout() { return about; }
}

