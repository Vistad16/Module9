package javaCore.module9.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.*;

public class ToJson {
    public static void main(String[] args) throws IOException {
        File file = new File("users.txt");
        if (file.exists()) { //check if file exist
            List<String> list = new ArrayList<>();
            InputStream fileInputStream = new FileInputStream(file); //read bytes from file

            Scanner scanner = new Scanner(fileInputStream); // read date from fileInputStream

            //add text line to collection list
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }

            //close scanner and file input
            fileInputStream.close();
            scanner.close();

            //create object
            List<Object> listObject = new ArrayList<>();
            for (int i = 1; i < list.size(); i++) { //ignore first text line
                String[] s = list.get(i).split(" "); //split name and age
                listObject.add(new Users(s[0], Integer.parseInt(s[1]))); // add object users to listObject
            }

            //change objects to json objects
            List<Object> jsonObject = new ArrayList<>();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            jsonObject.add(gson.toJson(listObject));

            fileWrite(jsonObject);

        } else
            throw new FileNotFoundException(); //trow exception if file not found
    }

    //write users in json file
    private static void fileWrite(List<Object> objects) {
        try (java.io.Writer fileWriter = new FileWriter("user.json")) {
            //object to string and write in file
            fileWriter.write((String) objects.get(0));

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("json file was created");
    }
}