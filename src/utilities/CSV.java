/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author Abdulaziz Al-Alshaikh
 */
public class CSV {
    //This method reads data from a CSV file and returns a list of strings representing the data
    public static List<String []> read(String file) throws FileNotFoundException{
        List<String []> data = new LinkedList<String[]>();
        Scanner in = new Scanner(new File(file));
        while(in.hasNext()) {
            String dataRow = in.nextLine();
            String [] dataRecords = dataRow.split(",");
            data.add(dataRecords);
        }
        return data;
    }
    
}
