package com.akaryu.bot.Core;

import com.akaryu.bot.Objects.Configuration;
import com.akaryu.bot.Tools.XMLReader;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

/**
 * Created by Nemvice on 03/01/2017.
 */
public class Main {


    private JDA jda;

    private boolean stop = false;

    Main() {
        try {
            Configuration base = XMLReader.readConfigXML("./resources/bot_auth.xml");
            System.out.println(base.getToken());
            jda = new JDABuilder(AccountType.BOT).setToken(base.getToken()).setBulkDeleteSplittingEnabled(false).buildBlocking();
        }catch (LoginException ex) {
            ex.printStackTrace();
            System.out.println("Une erreur est survenue veulliez verifier le token ou votre connection internet");
            return;
        }catch(InterruptedException ex) {
            ex.printStackTrace();
            System.out.println("Une erreur est survenue veulliez verifier le token ou votre connection internet");
            return;
        } catch (RateLimitedException ex){
            ex.printStackTrace();
            System.out.println("Une erreur est survenue veulliez verifier le token ou votre connection internet");
            return;
        }
        System.out.println("Connecte avec: " + jda.getSelfUser().getName());
        int i;
        System.out.println("Le bot est autorisé sur " + (i = jda.getGuilds().size()) + " serveur" + (i > 1 ? "s" : ""));
        while (!stop) {
            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.next();
            if (cmd.equalsIgnoreCase("stop")) {
                jda.shutdown(true);
                stop = true;
            }
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Veulliez indiquer le token du bot");
        }
        new Main();
    }
}
