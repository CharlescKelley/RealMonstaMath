package com.andriod.lennyface.monstamath;


import android.os.CountDownTimer;

public class Timer {

    private int level;
    private int startTime = 0;
    private int interval = 1000;


    public Timer(int lv)
    {
        level = lv;
    }

    public void setStartTime(int startSec)
    {
        startTime = startSec;
    }

    public void setTime()
    {
        if(level % 4 == 0)
        {
            int timeValue = 20000;
            setStartTime(timeValue);
            timeValue -= 5000;
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
