/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uavstuff;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

class AFrame extends JFrame
{
   public AFrame()
  {

     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setTitle("Image view Demo with JScrollPane");

     ImageIcon image = new ImageIcon("C:\\Users\\Majok\\Documents\\UAVStuff\\src\\uavstuff\\Scripts\\Stitched Images\\largeStitch.jpg");
     JLabel label = new JLabel(image);
     JScrollPane scrollPane = new JScrollPane(label);
     scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
     add(scrollPane, BorderLayout.CENTER);
     pack();
  }

 public static void main(String[] args)
 {
    SwingUtilities.invokeLater(new Runnable() {

       @Override
       public void run() {
          new AFrame().setVisible(true);
       }
    });

  }
}