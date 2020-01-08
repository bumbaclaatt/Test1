package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//Этот класс преобразует данные о сделках в данные о свечах в зависимости от ширины Свечи и возвращает список цен закрытия
public class Candles {
    public static List<Float> getcloses(int Width) throws Exception {
        List<Integer> numbersofcandle = GetData.getnumbersofcandle(Width);
        List<Float> price = GetData.getprice();
        HashMap<Integer, Float> prices = new HashMap<>();
        List<Float> closes = new ArrayList<>();
        for(int i = 0; i<=numbersofcandle.size()-1;i++) {
        prices.put(numbersofcandle.get(i), price.get(i));
    }
        for(int i = 0; i<=prices.size()-1;i++) {
        closes.add(prices.get(i));
        }
        return closes;
}
}
