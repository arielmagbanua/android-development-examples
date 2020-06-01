package com.arielmagbanua.androiddemos;

public class Meme {
    private String name;
    private String imageFileName;

    public Meme(String name, String imageFileName) {
        this.name = name;
        this.imageFileName = imageFileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }
}
