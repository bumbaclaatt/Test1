package com.company;

public class StrategySummfixedloss {
    public static void main(String[] args) throws Exception {
        System.out.println("Общий доход итоговой стратегии:"+(Algorithm3.results(900,10,3)+Algorithm4.results(9,10, 0.05f)));
    }
}
