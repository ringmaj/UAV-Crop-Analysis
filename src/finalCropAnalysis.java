
import org.opencv.core.Mat;

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
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class finalCropAnalysis {
    
    
    Mat src,src_hsv,threshold_output, binary_image, cropped,src_black, original,display, binary;
    
boolean debug = true;
int thresh = 100;
int max_thresh = 255;
int HL = 0;
int HH = 255;
int SL = 0;
int SH = 255;
int VL = 0;
int VH = 255;


//void call()
//{
//	//turns the pixel values that are within the hsv ranges to white, then displays them.
//	inRange(src_hsv, Scalar(HL, SL, VL), Scalar(HH, SH, VH), threshold_output); 
//	namedWindow("output");
//	imshow("output", threshold_output);
//        Img
//        
//}
































}
