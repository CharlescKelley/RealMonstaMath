package com.andriod.lennyface.monstamath;



public class Player {

    private int health;
    int damage;
    private int level;
    private int lifes;




    public Player(int playerHealth, int playerDamage, int lv, int lives) {
        health = modifyPlayerHealth(playerHealth, lv);
        damage = modifyPlayerDamage(playerDamage, lv);
        level = lv;
        lifes = lives;

    }

    public int setHealth()
    {
        return health;
    }

    public int setDamage()
    {
        return damage;
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

    public int modifyPlayerDamage(int damage, int lv)
    {
        int newDamage = 0;
        int isDivisibleByTwo = level % 2;

        if(lv <= 13)
        {
            if (isDivisibleByTwo == 0)
            {
                newDamage = (int) Math.pow(damage, 1.4);
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
