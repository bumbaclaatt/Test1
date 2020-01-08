package com.company;

import java.util.List;

public class StrategyPROBOIfixedloss {

    public static void main(String[] args) throws Exception {
        Algorithm4.results(90,100,5);
    }

}
class Algorithm4{
    public static void results(int Width,int numberofPeriods,float Window) throws Exception {
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
            if (b<=0) {
                if (closes.get(i)<=(average-Window)) {
                    if (Window / 2 <= Math.abs(closes.get(i) - closes.get(i + 1))) {
                        partyield = closes.get(i) - closes.get(i + 1);
                        yield = yield + partyield;
                        System.out.println("Доход от сделки на понижение:" + partyield);
                    } else if (Window / 2 <= Math.abs(closes.get(i) - closes.get(i + 2))) {
                        partyield = closes.get(i) - closes.get(i + 2);
                        yield = yield + partyield;
                        System.out.println("Доход от сделки на понижение:" + partyield);
                    } else {
                        partyield = closes.get(i) - closes.get(i + 3);
                        yield = yield + partyield;
                        System.out.println("Доход от сделки на понижение:" + partyield);
                    }
                }
            }
            else {
                if ((average+Window)<=closes.get(i)){
                    if (Window / 2 <= Math.abs(closes.get(i) - closes.get(i + 1))) {
                        partyield = closes.get(i+1) - closes.get(i );
                        yield = yield + partyield;
                        System.out.println("Доход от сделки на повышение:" + partyield);
                    } else if (Window / 2 <= Math.abs(closes.get(i) - closes.get(i + 2))) {
                        partyield = closes.get(i+2) - closes.get(i);
                        yield = yield + partyield;
                        System.out.println("Доход от сделки на повышение:" + partyield);
                    } else {
                        partyield = closes.get(i+3) - closes.get(i);
                        yield = yield + partyield;
                        System.out.println("Доход от сделки на повышение:" + partyield);
                    }
                }

            }
        }
        System.out.println("Общий доход:"+ yield);
    }
}
