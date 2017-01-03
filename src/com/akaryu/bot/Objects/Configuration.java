package com.akaryu.bot.Objects;

/**
 * Created by Nemvice on 03/01/2017.
 */
public class Configuration {
    private String name;
    private String token;
    private String id;
    private User owner;

    public Configuration(String name, String token, String id, User owner) {
        this.name = name;
        this.token = token;
        this.id = id;
        this.owner = owner;
    }

    public Configuration(String token){
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }

    public String getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }
}
