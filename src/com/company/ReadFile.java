package com.company;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Этот класс считывает наш документ(BTC-USD.csv) в список строк и возвращает его

public class ReadFile {
    public static List<List<String>> getdata() throws Exception {
        List<List<String>> data = new ArrayList<List<String>>();
        try (CSVReader csvReader = new CSVReader(new FileReader("BTC-USD1.csv"))) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                data.add(Arrays.asList(values));
            }
        }
        return data;
    }

}
