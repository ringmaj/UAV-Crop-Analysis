package uavstuff;

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.text.SimpleDateFormat;

/* ComboBoxDemo2.java requires no other files. */
public class comboBox extends JPanel
        implements ActionListener {

    static JFrame frame;
    JLabel result;
    String currentPattern;
   

    public comboBox() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        
         int fileCount=0;
         File dir1 = new File(".");
        File folder = new File(dir1.getAbsolutePath());
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
               // System.out.println("File " + listOfFiles[i].getName());
                fileCount++;

            } 
        }
       
        String []fileNames = new String[fileCount];
        for(int i = 0; i < fileCount; i++)
        {
            fileNames[i] = listOfFiles[i].getName();
        }
      
        
        

        currentPattern = fileNames[0];

        //Set up the UI for selecting a pattern.
        JLabel patternLabel1 = new JLabel("Select your stitched image");
        JLabel patternLabel2 = new JLabel("select one from the list:");
        
        
        for(int i = 0; i < fileCount; i++)
        {
        System.out.println(fileNames[i]);
        }
       

        JComboBox patternList = new JComboBox(fileNames);
        patternList.setEditable(true);
        patternList.addActionListener(this);

        //Create the UI for displaying result.
        JLabel resultLabel = new JLabel("Current Date/Time",
                JLabel.LEADING); //== LEFT
        result = new JLabel(" ");
        result.setForeground(Color.black);
        result.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        //Lay out everything.
        JPanel patternPanel = new JPanel();
        patternPanel.setLayout(new BoxLayout(patternPanel,
                BoxLayout.PAGE_AXIS));
        patternPanel.add(patternLabel1);
        patternPanel.add(patternLabel2);
        patternList.setAlignmentX(Component.LEFT_ALIGNMENT);
        patternPanel.add(patternList);

        JPanel resultPanel = new JPanel(new GridLayout(0, 1));
        resultPanel.add(resultLabel);
        resultPanel.add(result);

        patternPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        resultPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        add(patternPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(resultPanel);

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        
    } //constructor

    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        String newSelection = (String) cb.getSelectedItem();
        currentPattern = newSelection;
        
        System.out.println("Selected: "+newSelection);
        
    }

    /**
     * Formats and displays today's date.
     */
    
    

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ComboBoxDemo2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new comboBox();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
