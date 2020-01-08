package com.company;

import java.util.List;

//Это класс для нахождения значения линейной регресси при заданных значениях коридора и номеру текущего стакана
public class  Parameters{
    public static Float getb(int numberofPeriods,int CurrentPeriod,int Width,List<Float> closes) throws Exception {
        float sumx = 0;
        float sumx2 = 0;
        float sumy = 0;
        float sumxy = 0;
        for (int i=0;i<=numberofPeriods-1;i++){
            sumx = sumx + CurrentPeriod-i;
        }
        for (int i=0;i<=numberofPeriods-1;i++){
            sumx2 = sumx2 + (CurrentPeriod-i)*(CurrentPeriod-i);
        }
        for (int i=0;i<=numberofPeriods-1;i++){
            sumy = sumy + closes.get(CurrentPeriod-i);
        }
        for (int i=0;i<=numberofPeriods-1;i++){
            sumxy = sumxy + closes.get(CurrentPeriod-i)*(CurrentPeriod-i);

        }
        float b = (numberofPeriods*sumxy - (sumx*sumy))/(numberofPeriods*sumx2 - sumx*sumx);
        return b;
    }
    public static Float geta(int numberofPeriods,int CurrentPeriod,int Width,List<Float> closes) throws Exception {
        float sumx = 0;
        float sumy = 0;
        for (int i=0;i<=numberofPeriods-1;i++){
            sumx = sumx + CurrentPeriod-i;
        }
        for (int i=0;i<=numberofPeriods-1;i++){
            sumy = sumy + closes.get(CurrentPeriod-i);
        }
        float a = (sumy - sumx*getb( numberofPeriods, CurrentPeriod, Width,closes))/numberofPeriods;
        return a;
    }
}