package com.mmu.fracgoal;

public class Videos {

    public String videoName, videoUri;

    public Videos(){

    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(String videoUri) {
        this.videoUri = videoUri;
    }

    public Videos(String videoName, String videoUri) {
        this.videoName = videoName;
        this.videoUri = videoUri;
    }
}

