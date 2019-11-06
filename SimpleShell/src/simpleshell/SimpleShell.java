/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleshell;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author beni
 */
public class SimpleShell {

    public static void main(String[] args) throws IOException, InterruptedException{
       System.out.print(">");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        
        ProcessBuilder pB = new ProcessBuilder().inheritIO().command(input);
        pB.directory(new File("C:/SCHULE/TINF"));
        Process process=pB.start();
        
        System.out.println(process.getOutputStream());
        int exitCode = process.waitFor();
        assert exitCode == 0;
        System.exit(0);
        
    }
}
