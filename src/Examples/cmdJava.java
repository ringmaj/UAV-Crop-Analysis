/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Majok
 */

    
    import java.io.*;

public class cmdJava {

    
     public static void main(String[] args) throws IOException {
         
    // Execute command
    String command = "cmd /c start cmd.exe /K \"cd C:\\Users\\Majok\\Documents\\UAVStuff\\src\\Scripts && Analysis";
    Process child = Runtime.getRuntime().exec(command);


    // Get output stream to write from it
//    OutputStream out = child.getOutputStream();
//
//    out.write("cd C:/ /r/n".getBytes());
//    out.flush();
//    out.write("dir /r/n".getBytes());
//    out.close();
    
   

}
     
     
     
     
     
     
}