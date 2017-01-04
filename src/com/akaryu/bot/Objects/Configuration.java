package com.akaryu.bot.Objects;

/**
 * Created by Nemvice on 03/01/2017.
 */
public class Configuration {
    private String name;
    private int discriminator;
    private String token;
    private String id;

    public Configuration(String name, int discriminator, String token, String id) {
        this.name = name;
        this.discriminator = discriminator;
        this.token = token;
        this.id = id;
    }

    public Configuration(String token){
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public int getDiscriminator() {
        return discriminator;
    }

    public String getToken() {
        return token;
    }

    public String getId() {
        return id;
    }
}
