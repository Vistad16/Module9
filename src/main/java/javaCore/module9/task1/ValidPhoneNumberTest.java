package javaCore.module9.task1;

import java.io.File;
import java.io.IOException;

/*
987-123-4567 valid
123 456 7890
(123) 456-7890 valid
*/

public class ValidPhoneNumberTest {
    public static void main(String[] args) throws IOException {
        ValidPhoneNumber validPhoneNumber = new ValidPhoneNumber();
        File file = new File("file.txt");
        validPhoneNumber.validationCheck(file);
    }
}