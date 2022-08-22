package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;


public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();

        try (FileInputStream stream = new FileInputStream(file)) {
            int ch;
            while ((ch = stream.read()) != -1) {
                stringBuilder.append((char) ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> res = Arrays.asList(stringBuilder.toString().split("\n"));

        String name = res.get(0).split("\\s+")[1];
        int age = Integer.parseInt(res.get(1).split("\\s+")[1]);
        String email = res.get(2).split("\\s+")[1];
        Long phone = Long.parseLong(res.get(3).split("\\s+")[1]);

        return new Profile(name, age, email, phone);
    }

}
