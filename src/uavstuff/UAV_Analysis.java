//2015-09-15
package uavstuff;

import java.awt.image.BufferedImage;
import org.opencv.core.*;
import org.opencv.highgui.*;
import org.opencv.imgproc.Imgproc;
import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JCheckBoxMenuItem;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.WindowConstants;

public class UAV_Analysis {

    public void createWindow() {

        JFrame myFrame = new JFrame("UAV Analysis");
        myFrame.setSize(960, 650);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        menuBar = new JMenuBar();
        menu = new JMenu("A Menu");
        menuBar.add(menu);

//Build the first menu.
        menu = new JMenu("A Menu");

    }

    public void Analysis() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //Mat mat = Mat.eye( 3, 3, CvType.CV_8UC1 );
        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(converter);
        //System.out.println( "mat = " + mat.dump() );
        System.out.println(System.getProperty("user.dir"));
        Mat vineyard;
        String imagepath;

        try {

            System.out.println("Enter the exact path of the stiched image: ");
            imagepath = in.readLine();
            vineyard = Highgui.imread(imagepath);

            Mat re_vin = new Mat();
            Size sz = new Size(400, 400);
            Imgproc.resize(vineyard, re_vin, sz);

            Mat gray_vin = new Mat();
            Imgproc.cvtColor(re_vin, gray_vin, Imgproc.COLOR_RGB2GRAY);
            //System.out.println("re_vin has " + re_vin.channels() + " channels.");

            double total_pix = re_vin.rows() * re_vin.cols();
            double modify_count = 0;
            //System.out.println("Total Pixels: " + total_pix);

            for (int i = 0; i < re_vin.rows(); i++) {
                for (int j = 0; j < re_vin.cols(); j++) {
                    double[] rgb_values = re_vin.get(i, j);
                    double[] yellowfy = {0, 255, 255};
                    double[] whiteify = {255, 255, 255};
                    if (rgb_values[0] > 100 && rgb_values[1] > 100 && rgb_values[2] > 100) {
                        re_vin.put(i, j, yellowfy);
                        modify_count++;
                    }
                    if (rgb_values[0] < 50 && rgb_values[1] < 50 && rgb_values[2] < 50) {
                        re_vin.put(i, j, whiteify);
                    }
                }
            }

            //System.out.println("Modify count = " + modify_count);
            System.out.println("Bad Crop Percentage is: " + ((modify_count / total_pix) * 100) + "%.");

            for (int i = 0; i < vineyard.rows(); i++) {
                for (int j = 0; j < vineyard.cols(); j++) {
                    double[] rgb_values = vineyard.get(i, j);
                    double[] yellowfy = {0, 255, 255};
                    double[] whiteify = {255, 255, 255};
                    if (rgb_values[0] > 100 && rgb_values[1] > 100 && rgb_values[2] > 100) {
                        vineyard.put(i, j, yellowfy);
                    }
                    if (rgb_values[0] < 50 && rgb_values[1] < 50 && rgb_values[2] < 50) {
                        vineyard.put(i, j, whiteify);
                    }
                }
            }

            System.out.println("Enter the exact path of output image: ");
            imagepath = in.readLine();
            Highgui.imwrite(imagepath, vineyard);

            final BufferedImage image = ImageIO.read(new URL(
                    "C:\\Users\\Majok\\Desktop\\UAVStuff\\src\\uavstuff\\test_1.jpg"));

            Graphics g = image.getGraphics();
            g.setFont(g.getFont().deriveFont(30f));
            g.drawString("Hello World!", 100, 100);
            g.dispose();

            ImageIO.write(image, "png", new File("test.png"));

        } catch (IOException e) {
            System.out.println("Error: Could not open path.");
        }
    }

    public static void main(String[] args) {

        UAV_Analysis program = new UAV_Analysis();

        program.createWindow();
        program.Analysis();

    }

}
