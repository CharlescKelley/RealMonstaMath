package com.andriod.lennyface.monstamath;


import java.util.Random;

public class MathLogic {

    Random rand = new Random();

    private int userAnswer;
    private int correctAnswer;
    private int playerNum;
    private int monsterNum;

    private String type;

    public MathLogic(String math) {
        type = math;
    }

    public void createPlayerNum()
    {
        playerNum = rand.nextInt(10);
    }

    public void createMonsterNum()
    {
        monsterNum = rand.nextInt(10);
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
