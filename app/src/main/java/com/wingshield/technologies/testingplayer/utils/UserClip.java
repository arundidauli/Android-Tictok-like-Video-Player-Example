package com.wingshield.technologies.testingplayer.utils;

public class UserClip {
    public String name;
    public String city;
    public String hobbies;
    private String thumb_url, Video_url;

    public UserClip(String name, String city, String hobbies, String thumb_url, String video_url) {
        this.name = name;
        this.city = city;
        this.hobbies = hobbies;
        this.thumb_url = thumb_url;
        Video_url = video_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public String getVideo_url() {
        return Video_url;
    }

    public void setVideo_url(String video_url) {
        Video_url = video_url;
    }
}
