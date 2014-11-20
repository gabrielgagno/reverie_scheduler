package reverie.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Dell on 11/9/2014.
 */
public abstract class TestData {
    public static void testReadInput(){
        String fileDir = "src/resources/testinputs";
        try {
            Scanner readLine = new Scanner(new File(fileDir));
            while(readLine.hasNext()){
                StringTokenizer tok = new StringTokenizer(readLine.nextLine(), " ");
                while(tok.hasMoreTokens()){
                    System.out.println(tok.nextToken());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
