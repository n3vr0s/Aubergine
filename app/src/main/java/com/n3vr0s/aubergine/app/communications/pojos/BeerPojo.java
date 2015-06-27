package com.n3vr0s.aubergine.app.communications.pojos;

public class BeerPojo {

    public String id;
    public String name;
    public String nameDisplay;
    public String description;
    public String abv;
    public String ibu;
    public int glasswareId;
    public int availableId;
    public int styleId;
    public String isOrganic;
    public Labels labels;
    public String status;
    public String statusDisplay;
    public String createDate;
    public String updateDate;
    public Glass glass;
    public Available available;
    public Style style;

    public static class Available {
        public int id;
        public String name;
        public String description;
    }


    public static class Category {
        public int id;
        public String name;
        public String createDate;

    }

    public static class Glass {
        public int id;
        public String name;
        public String createDate;
    }

    public static class Labels {
        public String icon;
        public String medium;
        public String large;
    }

    public static class Style {
        public int id;
        public int categoryId;
        public Category category;
        public String name;
        public String shortName;
        public String description;
        public String ibuMin;
        public String ibuMax;
        public String abvMin;
        public String abvMax;
        public String srmMin;
        public String srmMax;
        public String ogMin;
        public String fgMin;
        public String fgMax;
        public String createDate;
        public String updateDate;
    }

}