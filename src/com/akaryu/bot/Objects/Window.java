package com.akaryu.bot.Objects;

import com.akaryu.bot.Core.Connection;
import com.akaryu.bot.Tools.XMLReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Nemvice on 03/01/2017.
 */
public class Window extends JFrame {

    private JTextField jtf = new JTextField("Enter Token");
    private JLabel label = new JLabel("Token");

    private File configFile;
    private Connection connection;

    public Window(){
        this.setTitle("Black Heart Bot");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setLayout(new BorderLayout());

        //Add content to the window.
        final FileChooser chooser;
        this.getContentPane().add(chooser = new FileChooser(), BorderLayout.CENTER);

        final JButton btnConnect = new JButton("Connect");
        btnConnect.setActionCommand("connect");
        btnConnect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if("connect".equals(e.getActionCommand())){
                    try {
                        configFile = chooser.getChooseFile();
                        connection = Connection.getInstance();
                        connection.connect(configFile);

                        //change to disconnect button
                        btnConnect.setActionCommand("disconnect");
                        btnConnect.setText("Disconnect");
                    }catch (FileNotFoundException ex){
                        JOptionPane.showMessageDialog(btnConnect.getParent(),
                                ex.getMessage(),
                                "Error File",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }else if("disconnect".equals(e.getActionCommand())){
                    connection.disconnect();
                    btnConnect.setActionCommand("connect");
                    btnConnect.setText("Connect");
                }
            }
        });

        this.getContentPane().add(btnConnect, BorderLayout.SOUTH);

        //Display the window.
        this.pack();
        this.setVisible(true);
    }

}
