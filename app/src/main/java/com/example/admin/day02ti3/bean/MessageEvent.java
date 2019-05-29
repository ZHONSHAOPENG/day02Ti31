package com.example.admin.day02ti3.bean;

import java.util.ArrayList;

public class MessageEvent {
    private ArrayList<String> url;

    public ArrayList<String> getUrl() {
        return url;
    }

    public void setUrl(ArrayList<String> url) {
        this.url = url;
    }

    public MessageEvent() {

    }

    public MessageEvent(ArrayList<String> url) {

        this.url = url;
    }
}
