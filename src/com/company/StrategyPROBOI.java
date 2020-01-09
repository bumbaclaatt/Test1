package com.company;

import java.util.List;

public class StrategyPROBOI {
    public static void main(String[] args) throws Exception {
    Algorithm2.results(9,10,0.05f);
}

}
class Algorithm2{
    public static Float results(int Width,int numberofPeriods,float Window) throws Exception {
        Float a;
        Float b;
        Float average;
        Float yield = Float.valueOf(0);
        Float partyield;
        int StartCandle = numberofPeriods;
        List<Float> closes = Candles.getcloses(Width);
        int LastCandle = closes.size()- 4;
        for (int i = StartCandle;i<=LastCandle;i++){
            b = Parameters.getb(numberofPeriods,i,Width,closes);
            a = Parameters.geta(numberofPeriods,i,Width,closes);
            average = a + b*i;
            if (b<=0){
                if (closes.get(i)<=(average-Window)){
                    partyield = closes.get(i) - closes.get(i+3);
                    yield = yield + partyield;
                    System.out.println("Доход от сделки на понижение:"+ partyield);
                }
            }
            else {
                if ( (average+Window)<=closes.get(i)){
                    partyield = closes.get(i+3)- closes.get(i);
                    yield = yield + partyield;
                    System.out.println("Доход от сделки на повышение:"+ partyield);
                }

            }
        }
        System.out.println("Общий доход:"+ yield);
        return yield;
    }
}