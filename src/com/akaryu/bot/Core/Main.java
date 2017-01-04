package com.akaryu.bot.Core;

import com.akaryu.bot.Objects.Configuration;
import com.akaryu.bot.Objects.Window;
import com.akaryu.bot.Tools.XMLReader;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.util.Scanner;

/**
 * Created by Nemvice on 03/01/2017.
 */
public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Veulliez indiquer le token du bot");
        }

        Window window = new Window();

    }
}
