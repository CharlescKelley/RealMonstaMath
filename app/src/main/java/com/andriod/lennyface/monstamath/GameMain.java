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
    int lv = 0;
    int lives = 3;
        // Character varaibles
    private int playerHealth =  100;
    private double playerDamage = 4;
        // Monster variables
    private int monsterHealth = 50;
    private double monsterDamage = 5;

    // Constructors

    Player player = new Player(playerHealth, playerDamage, lv, lives);
    Monster monster = new Monster(monsterHealth, monsterDamage, lv);
    MathLogic mathProblem = new MathLogic();
}
