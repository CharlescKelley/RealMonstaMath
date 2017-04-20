package com.andriod.lennyface.monstamath;


import java.util.Random;

public class MathLogic {

    Random rand = new Random();

    private int userAnswer;
    private int correctAnswer;
    public int playerNum;
    public int monsterNum;
    private int[] nums = new int[10];

    public MathLogic(int[] arrayOfNums) {
        for(int i = 0; i <= nums.length; i++)
        {
            nums[i] = arrayOfNums[i];
        }
    }

    public void createPlayerNum()
    {
        playerNum = rand.nextInt(10);
        for(int i = 0; i <= nums.length; i++)
        {
            if(nums[i] != -1)
            {
                if((playerNum != nums[0]) || (playerNum != nums[1]) ||(playerNum != nums[2]) ||
                        (playerNum != nums[3]) ||(playerNum != nums[4]) || (playerNum != nums[5]) ||
                        (playerNum != nums[6]) || (playerNum != nums[7]) ||(playerNum != nums[8]) ||
                        (playerNum != nums[9]))
                {
                    createPlayerNum();
                }
            }
        }
    }

    public void createMonsterNum()
    {
        monsterNum = rand.nextInt(10);
        for(int i = 0; i <= nums.length; i++)
        {
            if(nums[i] != -1)
            {
                if((monsterNum != nums[0]) || (monsterNum != nums[1]) ||(monsterNum != nums[2]) ||
                        (monsterNum != nums[3]) ||(monsterNum != nums[4]) || (monsterNum != nums[5]) ||
                        (monsterNum != nums[6]) || (monsterNum != nums[7]) ||(monsterNum != nums[8]) ||
                        (monsterNum != nums[9]))
                {
                    createMonsterNum();
                }
            }
        }
    }

    public int mathSwitch(String type)
    {
        switch(type)
        {
            case "addition":
                correctAnswer = playerNum + monsterNum;
                break;

            case "subtraction":
                correctAnswer = playerNum - monsterNum;
                break;

            case "multiplication":
                correctAnswer = playerNum * monsterNum;
                break;

            case "division":

                while(monsterNum == 0)
                {
                    createMonsterNum();
                }

                int isDivisable = playerNum % monsterNum;

                while (isDivisable != 0)
                {
                    createPlayerNum();
                }

                correctAnswer = playerNum / monsterNum;
                break;
        }
        return correctAnswer;
    }

}
