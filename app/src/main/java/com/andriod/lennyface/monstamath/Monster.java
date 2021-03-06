package com.andriod.lennyface.monstamath;

import java.util.Random;

public class Monster {

    private int health;
    private int damage;
    private int level;
    private String monsterName = "";
    private String bossName = "";


    public void chooseMonster()
    {
        String[] monsters = {"Moltip", "Quosho", "Perrisent", "Minas", "Ekal", "Inikhul the lesser and GREATER",
                "Pye", "Ruht", "Syn & Cosyn", "Imagen", "Delta", "Set"};
        Random rand = new Random();
        monsterName = monsters[rand.nextInt(11)];
    }

    public String setMonster()
    {
        if(level <= 13)
        {
            return monsterName;
        }
        else return bossName;
    }

    public int setHealth()
    {
        return health;
    }

    public int setDamage()
    {
        return damage;
    }


    public void chooseBoss(int num)
    {

        String[] bosses = {"Enfin", "Elmin", "Ingrall", "Sigma", "Boolean"};
        bossName = bosses[num];
    }

    public Monster(int monsterHealth, int monsterDamage, int lv) {
        health = modifyMonsterHealth(monsterHealth, lv);
        damage = modifyMonsterDamage(monsterDamage, lv);

    }

    public int modifyMonsterHealth(int health, int level)
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

    public int modifyMonsterDamage(int damage, int lv)
    {
        int newDamage = 0;
        int isDivisibleByTwo = level % 2;

        if(lv <= 13)
        {
            if (isDivisibleByTwo == 0)
            {
                newDamage = (int) Math.pow(damage, 1.05);
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
