//2015-09-15

package uavstuff;

import org.opencv.core.*;
import org.opencv.highgui.*;
import org.opencv.imgproc.Imgproc;
import java.io.*;



public class UAVStuff2 {
	
	static String path;
	static Mat image;
	static Mat cropped;
	static Mat binary_image;
	static Mat threshold_output;
	
	public static double calcThresh(Mat m){
		Scalar add;
		int size = 0;
		System.out.println("Calculating Threshold (Step 2 of 4)");
		for(int i=0; i < m.rows(); i++){
			for(int j=0; i<m.cols(); j++){
				if(binary_image.get(i, j)[0] >= 1){
					size++;
				}
			}
		}
		double avg = 0;
		add = Core.sumElems(m);
		avg = add.val[0]/size;
		return avg;
	}
	
	public static void crop(){
		
	}

	public static void analyze(){
		Mat image, gray = null, binary = null;
		double thresh;
		image = cropped;
		
		Imgproc.cvtColor(image, gray, Imgproc.COLOR_RGB2GRAY);
		thresh = calcThresh(gray);
		thresh += (thresh*0.15);
		Imgproc.threshold(gray, binary, thresh, 255, Imgproc.THRESH_BINARY);
		
		Highgui.imwrite(path + "image.jpg", image);
		Highgui.imwrite(path + "gray.jpg", gray);
		Highgui.imwrite(path + "binary.jpg", binary);
	}
	
	public static void showBad(){
		Mat binary = Highgui.imread(path + "binary.jpg");
		Mat output = image;
		
		for(int i=0; i<binary.rows(); i++){
			for(int j=0; j<binary.cols(); j++){
				if(binary.get(i, j)[0] > 250){
					byte[] data = {0, (byte)255, (byte)255};
					output.put(i, j, data);
				}
			}
		}
		Highgui.imwrite(path + "final_image.jpg", output);
	}
	
    public static void main(String[] args) {

        System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	    InputStreamReader converter = new InputStreamReader(System.in);
	    BufferedReader in = new BufferedReader(converter);
        System.out.println(System.getProperty("user.dir")); 
        Mat src, src_hsv = null;
        String imagepath;
      
      
        	
	        System.out.println("Enter the exact path of the stiched image: ");
                imagepath = "C:\\Users\\Majok\\Documents\\UAVStuff\\src\\Scripts\\Stitched Images\\farmTest.jpg";
                System.out.println("IMAGE PATH: "+imagepath);
		    //imagepath = in.readLine();
	        src = Highgui.imread(imagepath);
	        Imgproc.cvtColor(src, src_hsv, Imgproc.COLOR_BGR2HSV);
	      
	        int HL = 2;
	        int HH = 42;
	        int SL = 17;
	        int SH = 69;
	        int VL = 94;
	        int VH = 178;
	        
	        Core.inRange(src_hsv, new Scalar(HL, SL, VL), new Scalar(HH, SH, VH), threshold_output);
		    Highgui.imwrite("BinaryImage.jpg", threshold_output);
	        crop();
	        analyze();
	        showBad();
	        
       
    }
}
