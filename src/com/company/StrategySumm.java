package com.company;

public class StrategySumm {
    public static void main(String[] args) throws Exception {
        System.out.println("Общий доход итоговой стратегии:"+(Algorithm1.results(1000,100,1)+Algorithm2.results(50,15,2)));
    }
}
