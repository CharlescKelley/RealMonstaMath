package com.andriod.lennyface.monstamath;



public class Battle {

//    public Battle(Player player, Monster monster)
//    {
//
//    }


    public int round(int playerHealth, int monsterHealth, int playerDamage, int monsterDamage, boolean playerAttacks)
    {

        int pHealth = playerHealth;
        int mHealth = monsterHealth;
        int pDamage = playerDamage;
        int mDamage =  monsterDamage;

        if(playerAttacks == true)
        {
            mHealth = mHealth - pDamage;
            return mHealth;
        }
        else
        {
            pHealth = pHealth - mDamage;

            return pHealth;
        }
    }
}
