package com.andriod.lennyface.monstamath;



public class Player {

    int health;
    double damage;
    int level;
    int lifes;






    public Player(int playerHealth, double playerDamage, int lv, int lives) {
        health = modifyPlayerHealth(playerHealth, lv);
        damage = modifyPlayerDamage(playerDamage, lv);
        level = lv;
        lifes = lives;

    }

    public int modifyPlayerHealth(int health, int level)
    {
        int newHealth = 0;
        int isDivisibleByTwo = level % 2;

        if(level < 6)
        {
            newHealth = health + ((level/2) *10);
        }
        else if(level >= 6 && level < 14)
        {
            if (isDivisibleByTwo == 0)
            {
                newHealth = health + ((level/2) * 10);
            }
        }
        else if(level == 14)
        {
            newHealth =  health + 100;
        }
        else if(level == 15)
        {
            newHealth = health + 200;
        }
        else if(level == 18)
        {
            newHealth =  health + 200;
        }

        return newHealth;
    }

    public double modifyPlayerDamage(double damage, int lv)
    {
        double newDamage = 0;
        int isDivisibleByTwo = level % 2;

        if(lv <= 13)
        {
            if (isDivisibleByTwo == 0)
            {
                newDamage = Math.pow(damage, 1.4);
            }

        }
        else if(level == 14)
        {
            newDamage = damage + 10;
        }
        else if(level == 15)
        {
            newDamage = damage + 20;
        }
        else if(level == 18)
        {
            newDamage = damage + 30;
        }

        return newDamage;
    }


}
