package com.company;

public class StrategySummfixedloss {
    public static void main(String[] args) throws Exception {
        System.out.println("Общий доход итоговой стратегии:"+(Algorithm3.results(1000,100,1)+Algorithm4.results(50,15,2)));
    }
}
