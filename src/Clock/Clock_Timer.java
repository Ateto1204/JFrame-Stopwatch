/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clock;

/**
 *
 * @author Tony Su
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;

public class Clock_Timer implements ActionListener{
    
    JFrame frame = new JFrame("Program_Timer");
    JLabel label = new JLabel();
   
    String time = LocalDate.now().toString();
    String year = Integer.toString(LocalDate.now().getYear());
    String month = LocalDate.now().getMonth().toString().substring(0, 3);
    String week = LocalDate.now().getDayOfWeek().toString();
//    String date = LocalDate.now();
    
    Clock_Timer(int x, int y){
        
        label.setText(time);
        label.setFont(new Font("Ink Free", Font.PLAIN, 25));
        label.setBounds(100, 100, 200, 100);
        label.setBorder(BorderFactory.createBevelBorder(2/1));
        label.setOpaque(true);
        label.setHorizontalAlignment(JTextField.CENTER);
        
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(x, y, 420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
}
