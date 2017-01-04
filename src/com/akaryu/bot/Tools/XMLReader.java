package com.akaryu.bot.Tools;

import com.akaryu.bot.Objects.Configuration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by Nemvice on 03/01/2017.
 */
public class XMLReader {

    public static Configuration readConfigXML(File configFile){

        Configuration base = null;

        String name;
        int discriminator;
        String token;
        String id;

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(configFile);
            doc.getDocumentElement().normalize();

            NodeList botList = doc.getElementsByTagName("bot");
            Element configList = (Element) botList.item(0);

            NodeList nameAttr = configList.getElementsByTagName("name");
            name = nameAttr.item(0).getFirstChild().getNodeValue();

            NodeList discrimAttr = configList.getElementsByTagName("discriminator");
            discriminator = Integer.parseInt(discrimAttr.item(0).getFirstChild().getNodeValue());

            NodeList tokenAttr = configList.getElementsByTagName("token");
            token = tokenAttr.item(0).getFirstChild().getNodeValue();

            NodeList idAttr = configList.getElementsByTagName("id");
            id = idAttr.item(0).getFirstChild().getNodeValue();

            System.out.println("Parsing : Name " + name + " | Discriminator " + discriminator + " | Token " + token + " | id " + id);
            base = new Configuration(name, discriminator, token, id);

//            base = new Configuration("MjY1Njk3MTA5OTkzMzI0NTQ0.C0y5Sg.lPx1XfCImDEFU9AysQRzyoYoVI8");
            return base;
        }catch (Exception e){
            e.printStackTrace();
        }
        return base;
    }
}
