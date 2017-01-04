package com.akaryu.bot.Core;

import com.akaryu.bot.Objects.Configuration;
import com.akaryu.bot.Tools.XMLReader;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.util.Scanner;

/**
 * Created by Nemvice on 04/01/2017.
 */
public class Connection {

    private static Connection instance;

    private JDA jda;
    private boolean stop = false;

    private Configuration configuration;

    public static Connection getInstance() {
        if(instance == null){
            instance = new Connection();
        }
        return instance;
    }

    public void connect(File configFile){
        configuration = XMLReader.readConfigXML(configFile);
        try {
            System.out.println(configuration.getToken());
            jda = new JDABuilder(AccountType.BOT).setToken(configuration.getToken()).setBulkDeleteSplittingEnabled(false).buildBlocking();
        }catch (LoginException ex) {
            ex.printStackTrace();
            System.out.println("Une erreur est survenue veuillez verifier le token ou votre connection internet");
            return;
        }catch(InterruptedException ex) {
            ex.printStackTrace();
            System.out.println("Une erreur est survenue veuillez verifier le token ou votre connection internet");
            return;
        } catch (RateLimitedException ex){
            ex.printStackTrace();
            System.out.println("Une erreur est survenue veuillez verifier le token ou votre connection internet");
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
}
