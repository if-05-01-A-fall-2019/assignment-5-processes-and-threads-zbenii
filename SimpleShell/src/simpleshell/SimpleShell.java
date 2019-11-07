/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleshell;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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

        String[] trimmedInput=input.trim().split("&");
        for (int i = 0; i < trimmedInput.length; i++) {
            runShell(trimmedInput[i]);
        }
        
    }

    static void runShell(String command) throws IOException,InterruptedException{
        Process p=new ProcessBuilder().inheritIO().command("bash", "-c",command).start();
        InputStream stream=p.getInputStream();

        int x= stream.read();
        while(x != -1) {
            System.out.print((char) x);
            x = stream.read();
        }

        int exitCode=p.waitFor();
        assert exitCode == 0;
    }


}
