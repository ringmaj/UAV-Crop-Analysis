import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainClass extends JFrame {
  public static void main(String[] args) {
    new MainClass();
  }

  public MainClass() {
    this.setTitle("Picture Application");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel1 = new JPanel();
    ImageIcon pic = new ImageIcon("C:\\Users\\Majok\\Documents\\UAVStuff\\src\\Images\\output.jpg");
    panel1.add(new JLabel(pic));
    this.add(panel1);
    this.pack();
    this.setVisible(true);
    
    //get current directory
    File dir1 = new File (".");
System.out.println("current directory: " + dir1.getAbsolutePath());
  }
}