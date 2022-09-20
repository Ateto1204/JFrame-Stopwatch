/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constructor_Practice;

/**
 *
 * @author Tony Su
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class JPanel1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Constructor constructor = new Constructor();
    }
    
}


class Constructor{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    public Constructor(){
        
        panel.setBounds(100, 100, 100, 100);
        panel.setBackground(Color.LIGHT_GRAY);
        
        frame.add(panel);
        frame.setSize(420, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        
    }
}