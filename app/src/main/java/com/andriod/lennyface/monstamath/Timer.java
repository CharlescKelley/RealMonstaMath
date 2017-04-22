package com.andriod.lennyface.monstamath;


import android.os.CountDownTimer;

public class Timer {

    private int level;
    private int startTime = 0;
    private int interval = 1000;
    String playerType;


    public Timer(int lv, String mathType)
    {
        level = lv;
        playerType = mathType;
    }

    public void setStartTime(int startSec)
    {
        startTime = startSec;
    }

    public void setTime()
    {
        int timeValue;

        if((level % 4 == 0) && level <= 8)
        {
            timeValue = 20000;
            setStartTime(timeValue);
            timeValue -= 5000;
        }
        else if (level > 8 && level < 14)
        {
            timeValue = 300000;
            setStartTime(timeValue);
        }
        else if ((level == 14) && (playerType != "allMath"))
        {
            timeValue = 90000;
            setStartTime(timeValue);
        }
        else if((level >= 14) && (playerType == "allMath"))
        {
            timeValue = 300000;
            setStartTime(timeValue);
        }
    }

    public long getStartTime()
    {
        return startTime;
    }

    public long getInterval()
    {
        return interval;
    }
}
