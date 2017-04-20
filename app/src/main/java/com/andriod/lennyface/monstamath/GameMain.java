package com.andriod.lennyface.monstamath;


import android.widget.Button;
import android.widget.TextView;


public class GameMain {

    //Buttons ( Num select for answering questions, button to go to options menu, enter answer
    // and back button for if player enters the wrong num by accident)

    Button optionsDuringGame;
    Button gameNumZero;
    Button gameNumOne;
    Button gameNumTwo;
    Button gameNumThree;
    Button gameNumFour;
    Button gameNumFive;
    Button gameNumSix;
    Button gameNumSeven;
    Button gameNumEight;
    Button gameNumNine;
    Button gameBack;
    Button gameEnter;

    //TextView

    TextView textCharacterName;
    TextView textMonsterName;
    TextView textTimer;
    TextView textPlayerHealth;
    TextView textMonsterHealth;
    TextView textPlayerNum;
    TextView textMonsterNum;
    TextView textMathSymbol;

    // Variables
        // Game variables
    int lv;
    int lives = 3;
    int monsterCount;
    int[] nums = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    String playerType = "";
    boolean run;

        // Character varaibles
    private int playerHealth =  100;
    private double playerDamage = 4;
        // Monster variables
    private int monsterHealth = 50;
    private double monsterDamage = 5;




    public GameMain(int[] pickedNums, boolean isRunning, String mathType)
    {
        for(int i = 0; i <= 9; i++)
        {
            nums[i] = pickedNums[i];
        }

        run = isRunning;
        playerType = mathType;
    }

    // Constructors
    Player player = new Player(playerHealth, playerDamage, lv, lives);
    Monster monster = new Monster(monsterHealth, monsterDamage, lv);
    MathLogic mathProblem = new MathLogic(playerType, nums);



    private void runGame()
    {

    }

    private void game()
    {

    }
}
