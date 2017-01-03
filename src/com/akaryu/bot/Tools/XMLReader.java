package com.akaryu.bot.Tools;

import com.akaryu.bot.Objects.Configuration;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by Nemvice on 03/01/2017.
 */
public class XMLReader {

    public static Configuration readConfigXML(String filename){

        Configuration base = null;

        try {
            File config = new File(filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(config);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :"
                    + doc.getDocumentElement().getNodeName());
            base = new Configuration("MjY1Njk3MTA5OTkzMzI0NTQ0.C0y5Sg.lPx1XfCImDEFU9AysQRzyoYoVI8");
            return base;
        }catch (Exception e){
            e.printStackTrace();
        }
        return base;
    }
}
