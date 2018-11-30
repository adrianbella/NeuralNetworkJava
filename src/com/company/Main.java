package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String[]> input = new ArrayList<>(38274);

        try{

            input = read();

        } catch (IOException e){
            e.printStackTrace();
        }
        catch (IllegalArgumentException ie){
            ie.printStackTrace();
        }
    }

    public static List<String[]> read() throws IOException {
        String[] str = null;
        List<String[]> strInput = new ArrayList<>();

        try (InputStreamReader instream = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(instream)){
                String in;

                while ((in = buffer.readLine()) != null) {

                    str = in.split("\t");
                    strInput.add(str);

                }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return strInput;
    }
}
