/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uavstuff;

/**
 *
 * @author Majok
 */
import javax.swing.*;
import java.awt.*;
import static java.awt.Color.GREEN;
import java.awt.event.*;
class BackgroundColorJFrame extends JFrame
{
 public BackgroundColorJFrame()
 {
 setTitle("Background Color for JFrame");
 setSize(400,400);
 setLocationRelativeTo(null);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setVisible(true);
 
  // Get the container and set the background
 getContentPane().setBackground(Color.lightGray);
 }
 public static void main(String args[])
 {
 new BackgroundColorJFrame();
 }
}