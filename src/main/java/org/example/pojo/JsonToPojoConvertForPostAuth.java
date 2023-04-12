package org.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonToPojoConvertForPostAuth {
    @JsonProperty("username")
    public Object getUsername() {
        return this.username; }
    public void setUsername(Object username) {
        this.username = username; }
    Object username;
    @JsonProperty("password")
    public Object getPassword() {
        return this.password; }
    public void setPassword(Object password) {
        this.password = password; }
    Object password;
}
