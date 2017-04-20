package com.andriod.lennyface.monstamath;

import java.util.Random;

public class Monster {

    private int health;
    private double damage;
    private int level;


    public String chooseMonster()
    {
        String monsterName = "";
        String[] monsters = {"Moltip", "Quosho", "Perrisent", "Minas", "Ekal", "Inikhul the lesser and GREATER",
                "Pye", "Ruht", "Syn & Cosyn", "Imagen", "Delta", "Set"};
        Random rand = new Random();
        monsterName = monsters[rand.nextInt(11)];
        return monsterName;
    }

    public String chooseBoss(int num)
    {
        String boss = "";
        String[] bosses = {"Enfin", "Elmin", "Ingrall", "Sigma", "Boolean"};
        boss = bosses[num];
        return boss;
    }

    public Monster(int monsterHealth, double monsterDamage, int lv) {
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

    public double modifyMonsterDamage(double damage, int lv)
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
