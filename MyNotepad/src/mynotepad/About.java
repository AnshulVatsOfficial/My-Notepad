/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mynotepad;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author avans
 */
public class About extends JFrame{
    
    public About(){
        setBounds(100, 100, 500, 400);
        setTitle("About My Notepad");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        ImageIcon myicon = new ImageIcon(getClass().getResource("notepad-icon.png"));
        setIconImage(myicon.getImage());
        
        setLayout(null);
        
        JLabel textLabel = new JLabel("<html>Notepad is a text editor, i.e., an app specialized in editing plain text. It can edit text files (bearing the \". txt\" filename extension)<br><br>This Notepad is created using JAVA, Java Swing and JAVA AWT on NetBeans IDE !<html>");
        textLabel.setBounds(10, 10, 450, 100);
        textLabel.setFont(new Font("Verdana", Font.BOLD, 13));
        add(textLabel);
        
        JLabel devName = new JLabel("<html>Developer<br>Anshul Vats<html>");
        devName.setBounds(400, 50, 70, 590);
        devName.setFont(new Font("Arial", Font.BOLD, 12));
        add(devName);
    }
    
    public static void main(String[] args){
        new About().setVisible(true);
    }
}
