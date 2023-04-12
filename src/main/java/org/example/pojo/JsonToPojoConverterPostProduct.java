package org.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonToPojoConverterPostProduct {
    @JsonProperty("title")
    public Object getTitle() {
        return this.title; }
    public void setTitle(Object title) {
        this.title = title; }
    Object title;
    @JsonProperty("price")
    public Object getPrice() {
        return this.price; }
    public void setPrice(Object price) {
        this.price = price; }
    Object price;
}
