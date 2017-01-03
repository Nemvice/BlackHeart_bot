package com.akaryu.bot.Objects;

/**
 * Created by Nemvice on 03/01/2017.
 */
public class User {
    private int id;
    private String username;
    private int discriminator;
    private String avatar;
    private String email;

    public User(int id, String username, int discriminator, String avatar, String email) {
        this.id = id;
        this.username = username;
        this.discriminator = discriminator;
        this.avatar = avatar;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getDiscriminator() {
        return discriminator;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getEmail() {
        return email;
    }
}
