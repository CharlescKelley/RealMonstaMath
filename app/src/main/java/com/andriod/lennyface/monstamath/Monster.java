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

        if (isDivisibleByTwo == 0)
        {
            newHealth = health + (level * 10);
        }

        return newHealth;
    }

    public double modifyDamage(double damage, int lv)
    {
        double newDamage = 0;
        int isDivisibleByTwo = level % 2;

        if(lv <= 10)
        {
            if (isDivisibleByTwo == 0)
            {
                newDamage = Math.pow(damage, 1.1);
            }

        }
        else if(lv > 10 && lv < 20)
        {

        }
        else ;

        return newDamage;
    }
}
