package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Bean {
	public static void main(String[] args) throws Exception {
		String path = "E://123.xml";
        File file = new File(path);
        if(!file.exists()){
            file.getParentFile().mkdirs();          
        }
        file.createNewFile();
 
        // write
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("xxxaffdf");
        bw.flush();
        bw.close();
        fw.close();
 
        // read
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String str = br.readLine();
        System.out.println(str);
    }



}
