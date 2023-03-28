package org.example.utils.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonToPojoConvertForVehicle {
    @JsonProperty("number")
    public Object getNumber() {
        return this.number; }
    public void setNumber(Object number) {
        this.number = number; }
    Object number;
    @JsonProperty("type")
    public Object getType() {
        return this.type; }
    public void setType(Object type) {
        this.type = type; }
    Object type;
    @JsonProperty("vendorId")
    public Object getVendorId() {
        return this.vendorId; }
    public void setVendorId(Object vendorId) {
        this.vendorId = vendorId; }
    Object vendorId;
    @JsonProperty("storeId")
    public Object getStoreId() {
        return this.storeId; }
    public void setStoreId(Object storeId) {
        this.storeId = storeId; }
    Object storeId;
}
