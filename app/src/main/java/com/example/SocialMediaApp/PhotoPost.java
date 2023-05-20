package com.example.SocialMediaApp;

public class PhotoPost {
    private int logo;
    private String name,typeOf;

    public PhotoPost(int logo, String name, String typeOf) {
        this.logo = logo;
        this.name = name;
        this.typeOf = typeOf;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(String typeOf) {
        this.typeOf = typeOf;
    }
}
