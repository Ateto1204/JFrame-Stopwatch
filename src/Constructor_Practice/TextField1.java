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

// Reference Link : 
// https://www.javatpoint.com/java-jtextfield
// https://stackoverflow.com/questions/11927963/get-input-from-jframe

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.InputMismatchException;

public class TextField1 implements ActionListener{

    /**
     * @param args the command line arguments
     */
    
    JTextField inputHour, inputMinute, inputSecond;
    JLabel label;
    JFrame frame;
    JButton cancelButton, startButton;
    
    private int hour, minute, second, total;
    private boolean started, init;
    
    
    Timer timer = new Timer(1000, new ActionListener(){
        public void actionPerformed(ActionEvent e){
            
//            total -= 1;
            second = total % 60;
            minute = total/60 % 60;
            hour = total / 3600;
            label.setText(String.format("%02d:%02d:%02d", hour, minute, second));
            total -= 1;
            if(total <= 0){
                timer.stop();
                label.setText("Timer Up!!");
                started = false;
                init = false;
            }
            
        }
    });
    
    TextField1(){
        
        label = new JLabel("Input the time: ");
        label.setBounds(100, 50, 200, 50);
        label.setBorder(BorderFactory.createBevelBorder(1));
        label.setOpaque(true);
        label.setHorizontalAlignment(JTextField.CENTER);
        
        inputHour = new JTextField("00");
        inputHour.setBounds(50, 150, 100, 50);
        
        inputMinute = new JTextField("00");
        inputMinute.setBounds(150, 150, 100, 50);
        
        inputSecond = new JTextField("00");
        inputSecond.setBounds(250, 150, 100, 50);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(75, 200, 100, 50);
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);
        
        startButton = new JButton("Start");
        startButton.setBounds(225, 200, 100, 50);
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        
        frame = new JFrame("Exercise1");
        frame.add(label);
        frame.add(inputHour);
        frame.add(inputMinute);
        frame.add(inputSecond);
        frame.add(cancelButton);
        frame.add(startButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new TextField1();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == startButton){
            if(!started){
                started = true;
                try{
                    if(!init){
                        init = true;
                        total = getTime(inputHour)*3600 + getTime(inputMinute)*60 + getTime(inputSecond);
                    }
                    if(total > 0){
                        startButton.setText("Pause");
                        if(!init){
                            label.setText(String.format("%02d:%02d:%02d", getTime(inputHour), getTime(inputMinute), getTime(inputSecond)));
                        }
                        timer.start();
                    }else{
                        label.setText("0 is valid!");
                    }
                }catch(Exception ex){
                    label.setText("Please input correct format only with number!!");
                    System.out.println("Please input correct time format!!");
                }
            }else{
                started = false;
                startButton.setText("Start");
                timer.stop();
            }
        }
    }
    public int getTime(JTextField field){
        return Integer.parseInt(field.getText());
    }
}