package com.example.recyclerview2;

public class ContactModel {
    int img;
    String name, number;

    public ContactModel(int img, String name, String number) {
        this.name = name;
        this.number = number;
        this.img = img;
    }

    public ContactModel(String name, String number){
        this.name = name;
        this.number = number;
    }
}