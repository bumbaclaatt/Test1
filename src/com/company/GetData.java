package com.company;

import java.util.ArrayList;
import java.util.List;
//Этот класс считывает из массива строк данные о timestamp и ценах в два списка и возвращет их двумя разными методами
public class GetData {
    public static  List<Integer> getnumbersofcandle(int Width) throws Exception{
        List<List<String>> data = ReadFile.getdata();
        List<Integer> numbersofcandle = new ArrayList<Integer>();
        int lastrealnumber = (int)Integer.parseInt(data.get(0).get(1))/Width;
        int currentrealnumber;
        int number = 0;
        for (int i=0;i<=data.size()-1;i++ ){
            currentrealnumber = (int)Integer.parseInt(data.get(i).get(1))/Width;
            if (currentrealnumber == lastrealnumber){
                numbersofcandle.add(number);
            }
            else{
                number = number+1;
                numbersofcandle.add(number);
                lastrealnumber = (int)Integer.parseInt(data.get(i).get(1))/Width;
            }
        }
        return numbersofcandle;
    }
    public static  List<Float> getprice() throws Exception{
        List<List<String>> data = ReadFile.getdata();
        List<Float> price = new ArrayList<Float>();
        for (int i=0;i<=data.size()-1;i++ ){
            price.add(Float.parseFloat(data.get(i).get(2)));
        }
        return price;
    }
}
