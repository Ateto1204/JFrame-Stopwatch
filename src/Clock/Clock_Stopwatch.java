package Clock;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Clock_Stopwatch implements ActionListener{
    
    JFrame frame = new JFrame("Program_Stopwatch.java");
    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    JButton backButton = new JButton("BACK");
    JLabel timeLabel = new JLabel();
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    int milliseconds = 0;
    int page = 1;
    boolean started = false;
    private boolean visible;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);
    String milliseconds_string = String.format("%02d", milliseconds);
    
    Timer timer = new Timer(10, new ActionListener() {
    
        public void actionPerformed(ActionEvent e){
            
            elapsedTime += 10;
            hours = elapsedTime / 3600000;
            minutes = elapsedTime / 60000 % 60;
            seconds = elapsedTime / 1000 % 60;
            milliseconds = elapsedTime / 10 % 100;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            milliseconds_string = String.format("%02d", milliseconds);
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string + ":" + milliseconds_string);
            
        }
        
    });
    
    public Clock_Stopwatch(ActionListener e){
        
        // setBounds(int x, int y, int width, int weight)
        
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string + ":" + milliseconds_string);
        timeLabel.setBounds(50, 100, 300, 100);
        timeLabel.setFont(new Font("", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        
        startButton.setBounds(100, 200, 100, 50);
        startButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        
        resetButton.setBounds(200, 200, 100, 50);
        resetButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        
        backButton.setBounds(150, 250, 100, 50);
        backButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        backButton.setFocusable(false);
        backButton.addActionListener(e);
        
        frame.add(startButton);
        frame.add(resetButton);
        frame.add(backButton);
        frame.add(timeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
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
        
//        if(e.getSource() == backButton){
//            
//        }
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
    
    void setPosition(int x, int y){
        frame.setBounds(x, y, 420 ,420);
    }
}