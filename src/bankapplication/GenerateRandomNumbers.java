package bankapplication;

import java.util.Random;

/**
 *
 * @author Abdulaziz Al-Alshaikh
 */
public class GenerateRandomNumbers {
    public static String randomNumbers(int numOfDigits)
    {
        Random rd = new Random();
        String digits = "";
        for (int i = 0; i < numOfDigits; i++) 
            digits += ""+ (rd.nextInt(9) + 1);
        
        return digits;
    } 
    
}
