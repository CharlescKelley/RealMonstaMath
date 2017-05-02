package com.andriod.lennyface.monstamath;



public class Battle {

//    public Battle(Player player, Monster monster)
//    {
//
//    }


    public int round(int playerHealth, int monsterHealth, int playerDamage, int monsterDamage, boolean playerAttacks)
    {
        // the player/monster health and player/monster damage takin from the GameMain assigned to variables 
        int pHealth = playerHealth;
        int mHealth = monsterHealth;
        int pDamage = playerDamage;
        int mDamage =  monsterDamage;
        // iff statement to determine is the player of the monster lose health and return that lost health
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
