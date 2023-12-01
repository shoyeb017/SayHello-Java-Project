package com.example.sayhello.view_manager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class number_generate {

    public String generate_number() throws IOException {

        String p = null;
        int t = 0;

        File infoFile2 = new File("src/main/resources/com/example/sayhello/file/number.txt");
        if (infoFile2.exists()) {
            Scanner sc = new Scanner(infoFile2);
            sc.useDelimiter("\n");
            String fn = sc.next();
            p = fn;
            sc.close();

            t= Integer.parseInt(p);
            FileWriter writer = new FileWriter(infoFile2);
            writer.write(t+1 + "\n");
            writer.close();
        }

        return p;
    }
}
