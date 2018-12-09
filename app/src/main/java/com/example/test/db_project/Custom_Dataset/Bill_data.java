package com.example.test.db_project.Custom_Dataset;

public class Bill_data {
    String name;
    String date;
    String type;
    String item;
    String amount;
    String price;

    public Bill_data(String name, String date, String type, String item, String amount, String price){
        this.name = name;
        this.date=date;
        this.type=type;
        this.item=item;
        this.amount=amount;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
