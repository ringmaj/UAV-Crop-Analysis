/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Majok
 */

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.image.BufferedImage;
import org.opencv.core.*;
import org.opencv.highgui.*;
import org.opencv.imgproc.Imgproc;
import java.io.*;
import java.net.URL;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Translation {
   //Sets up variables that will be used later in the program.
Mat src, src_hsv, threshold_output, binary_image, cropped, src_black, original, display, binary;
String file_image = "largeStitch.jpg";  //Directs the program to a stitched image of a crop field.
boolean configuration = true;  		       //Set to true if you want to configure the hsv thresholds.
boolean showProgress = true;				   //Set to true if you want the percentages displayed.
int percent = 0;
int thresh = 100;
int max_thresh = 255;
String answer;
 
//HSV thresholds used to determine if pixel values are within certain HSV ranges.
int HL = 0;
int HH = 255;
int SL = 0;
int SH = 255;
int VL = 0;
int VH = 255;

void message()
{
	System.out.println("Would you like to configure the HSV threshold");
	System.out.println("for the image? (Y/N)");
        
        Scanner input = new Scanner(System.in);
	answer = input.next();
	if ((answer == "Y") || (answer == "y"))
	{
		configuration = true;
		System.out.println("WHEN CONFIGURING, ADJUST THE TASKBARS TO WHERE THE FIELD PORTION");
		System.out.println("IS WHITE");
	}
	else
	{
		configuration = false;
	}

////	cout << "Would you like to show progress";
////	cout << "for the image? (Y/N)";
////	cin >> answer;
////	if ((answer[0] == 'Y') || (answer[0] == 'y'))
//	{
//		showProgress = true;
//	}
//	else
//	{
//		showProgress = false;
//	}









































}
    
}
