
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
import javax.swing.border.Border;

class Clock_Clock implements ActionListener{
    
    // FIELD
    JFrame frame = new JFrame("Clock");
    JLabel timeLabel = new JLabel();
    private int page = 0;
    
    // Clock_Field
    JButton stopwatchButton = new JButton("Stopwatch");
    String hour = String.format("%02d", LocalDateTime.now().getHour());
    String minute = String.format("%02d", LocalDateTime.now().getMinute());
    String second = String.format("%02d", LocalDateTime.now().getSecond());
    
    // Stopwatch_Field
    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    
    private int elapsedTime = 0;
    int milliseconds = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    private boolean started = false;
    String milliseconds_string = String.format("%02d", milliseconds);
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);
    
    // Timer_Field
    JButton timerButton = new JButton("Timer");
    JTextField inputHour = new JTextField();
    JTextField inputMinute = new JTextField();
    JTextField inputSecond = new JTextField();
    JButton cancelButton = new JButton("Cancel");
    int timerHour, timerMinute, timerSecond, timerTotal;
    boolean timerStarted, timerInit;
    
    // Alarm_Field
    JButton alarmButton = new JButton("Alarm");
    
    // Watch
    JButton watchButton = new JButton("Watch");
    
    Timer timer = new Timer(10, new ActionListener() {
        
        public void actionPerformed(ActionEvent e){
            
            elapsedTime += 16;
            hours = elapsedTime / 3600000;
            minutes = elapsedTime / 60000 % 60;
            seconds = elapsedTime / 1000 % 60;
            milliseconds = elapsedTime / 10 % 100;
            
        }
                
    });
    
    Clock_Clock(){
        
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string + ":" + milliseconds_string);
        timeLabel.setBounds(50, 100, 345, 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        
        
        setButton(stopwatchButton, 250, 400, 110, 50, true);
        
        setButton(watchButton, 80, 400, 110, 50, true);
        setButton(startButton, 100, 200, 100, 50, false);
        setButton(resetButton, 245, 200, 100, 50, false);
        
        setButton(timerButton, 110, 410, 110, 50, true);
        
        setButton(alarmButton, 220, 410, 110, 50, true);
        
        frame.add(stopwatchButton);
//        frame.add(timerButton);
//        frame.add(alarmButton);
        frame.add(watchButton);
        frame.add(timeLabel);
        frame.add(startButton);
        frame.add(resetButton);
        frame.add(new JLabel(new ImageIcon("clock.png")));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(450, 150, 455, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        
        while(true){
            if(page == 0){
                clock();
            }else if(page == 1){
                stopwatch();
            }
        }
        
    }
    
    public void setButton(JButton button, int x, int y, int width, int height, boolean visible){
        
        button.setBounds(x, y, width, height);
        button.setBackground(Color.WHITE);
        button.setFont(new Font("", Font.PLAIN, 12));
        button.setFocusable(false);
        button.addActionListener(this);
        button.setVisible(visible);
//        button.setBorder(new RoundBtn(30));
        
    }
    
    public void addButton(JButton button){
        button.setVisible(true);
    }
    
    public void removeButton(JButton button){
        button.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == stopwatchButton){
            page = 1;
            addButton(watchButton);
            addButton(startButton);
            addButton(resetButton);
        }
        
        if(e.getSource() == watchButton){
            page = 0;
            removeButton(startButton);
            removeButton(resetButton);
            addButton(stopwatchButton);
        }
        
        if(e.getSource() == startButton){
            if(!started){
                started = true;
                startButton.setText("STOP");
                start();
            }else{
                started = false;
                startButton.setText("START");
                stop();
            }
        }
        
        if(e.getSource() == resetButton){
            started = false;
            startButton.setText("START");
            reset();
        }
        
    }
    
    void start(){
        timer.start();
    }
    
    void stop(){
        timer.stop();
    }
    
    void reset(){
        
        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        milliseconds = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        milliseconds_string = String.format("%02d", milliseconds);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string + ":" + milliseconds_string);
    
    }
    
    public void clock(){
        
        String hour = String.format("%02d", LocalDateTime.now().getHour());
        String minute = String.format("%02d", LocalDateTime.now().getMinute());
        String second = String.format("%02d", LocalDateTime.now().getSecond());
        timeLabel.setText(hour + ":" + minute + ":" + second);
    
    }
    
    public void stopwatch(){

        milliseconds_string = String.format("%02d", milliseconds);
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string + ":" + milliseconds_string);

    }
    
}

class RoundBtn implements Border 
{
    private int r;
    RoundBtn(int r) {
        this.r = r;
    }
    public Insets getBorderInsets(Component c) {
        return new Insets(this.r+1, this.r+1, this.r+2, this.r);
    }
    public boolean isBorderOpaque() {
        return true;
    }
    public void paintBorder(Component c, Graphics g, int x, int y, 
    int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, r, r);
    }
}
