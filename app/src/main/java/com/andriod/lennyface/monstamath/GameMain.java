package com.andriod.lennyface.monstamath;


import android.widget.Button;
import android.widget.TextView;


public class GameMain {

    //Buttons ( Num select for answering questions, button to go to options menu, enter answer
    // and back button for if player enters the wrong num by accident)

    Button optionsDuringGame = (Button) findViewById(R.id.optionsButton);
    Button gameNumZero = (Button) findViewById(R.id.numZero);
    Button gameNumOne = (Button) findViewById(R.id.numOne);
    Button gameNumTwo = (Button) findViewById(R.id.numTwo);
    Button gameNumThree = (Button) findViewById(R.id.numThree);
    Button gameNumFour = (Button) findViewById(R.id.numFour);
    Button gameNumFive = (Button) findViewById(R.id.numFive);
    Button gameNumSix = (Button) findViewById(R.id.numSix);
    Button gameNumSeven = (Button) findViewById(R.id.numSeven);
    Button gameNumEight = (Button) findViewById(R.id.numEight);
    Button gameNumNine = (Button) findViewById(R.id.numNine);
    Button gameBack = (Button) findViewById(R.id.backButton);
    Button gameEnter = (Button) findViewById(R.id.enterButton);

    //TextView

    TextView textCharacterName = (TextView) findViewById(R.id.displayCharacterName);
    TextView textMonsterName = (TextView) findViewById(R.id.displayMonsterName);
    TextView textTimer =(TextView) findViewById(R.id.displayTimer);
    TextView textPlayerHealth = (TextView) findViewById(R.id.displayPlayerHealth);
    TextView textMonsterHealth = (TextView) findViewByid(R.id.displayMonsterHealth);
    TextView textPlayerNum = (TextView) findViewById(R.id.displayPlayerNum);
    TextView textMonsterNum = (TextView) findViewById(R.id.displayMonsterNum);
    TextView textMathSymbol = (TextView) findViewById(R.id.displayMathSymbol);

    // Variables
        // Game variables
    int lv = 1;
    int lives = 3;
    int monsterCount;
    int[] nums = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
    String playerType = "";
    String monsterName = "";
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
    MathLogic mathProblem = new MathLogic(nums);
    Battle battle = new Battle();



    private void runGame()
    {

    }

    private void game()
    {
        setTextViews();

        if(lv <= 13)
        {
            monster.chooseMonster();
            setTextViews();
        }
    }

    private void setTextViews()
    {
        mathProblem.createPlayerNum();
        mathProblem.createMonsterNum();

        textCharacterName.setText(playerType);
        textMonsterName.setText(monster.setMonster());
        textMonsterNum.setText(mathProblem.monsterNum);
        textPlayerNum.setText(mathProblem.playerNum);
        textPlayerHealth.setText(player.setHealth());
        textMonsterHealth.setText(monster.setHealth());
        if(playerType == "addition")
        {
            textMathSymbol.setText("+");
        }
        else if(playerType == "subtraction")
        {
            textMathSymbol.setText("-");
        }
        else if(playerType == "multiplication")
        {
            textMathSymbol.setText("x");
        }
        else textMathSymbol.setText("/");
    }
}
