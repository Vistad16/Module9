package javaCore.module9.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidPhoneNumber {

    public void validationCheck(File file) throws IOException {
        if (file.exists()) { //check, if file exist
            InputStream fileInputStream = new FileInputStream(file); //read bytes from file

            Scanner scanner = new Scanner(fileInputStream); // read date from fileInputStream

            List<String> validNumbers = new ArrayList<>(); //created collection

            while (scanner.hasNextLine()) {//adding strings matching pattern
                String checkString = scanner.nextLine(); //write a string from a file to a variable
                //Pattern "(xxx) xxx-xxxx", "xxx-xxx-xxxx"
                Pattern p = Pattern.compile("(?:\\(\\d{3}\\) |\\d{3}[-]*)\\d{3}[-]*\\d{4}");
                if (p.matcher(checkString).matches()) { //check for pattern matching
                    validNumbers.add(checkString); //add valid string
                }
            }

            fileInputStream.close(); //FileInputStream close
            scanner.close(); //scanner close

            for (String a : validNumbers) { // output valid collection
                System.out.println(a);
            }
        } else {
            throw new FileNotFoundException(); // throw when file not found
        }

    }

}