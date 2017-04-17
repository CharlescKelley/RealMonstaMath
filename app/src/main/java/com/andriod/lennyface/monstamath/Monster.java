package com.andriod.lennyface.monstamath;


public class Monster {

    int health;
    double damage;
    int level;
    double crit;



    public Monster(int monsterHealth, double monsterDamage, int lv) {
        health = modifyHealth(monsterHealth, lv);
        damage = modifyDamage(monsterDamage, lv);
        level =lv;

    }

    public int modifyHealth(int health, int level)
    {
        int newHealth = 0;
        int isDivisibleByTwo = level % 2;

       if(level < 6)
       {
           newHealth = health + (level *10);
       }
       else if(level >= 6 && level < 14)
       {
           if (isDivisibleByTwo == 0)
           {
               newHealth = health + (level * 10);
           }
       }
       else if(level == 14)
       {
           newHealth =  health + 250;
       }
       else if(level == 15)
       {
           newHealth = health + 500;
       }
       else if(level == 18)
       {
           newHealth =  health + 500;
       }

        return newHealth;
    }

    public double modifyDamage(double damage, int lv)
    {
        double newDamage = 0;
        int isDivisibleByTwo = level % 2;

        if(lv <= 13)
        {
            if (isDivisibleByTwo == 0)
            {
                newDamage = Math.pow(damage, 1.05);
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
