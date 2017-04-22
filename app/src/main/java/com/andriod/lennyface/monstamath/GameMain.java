package com.andriod.lennyface.monstamath;


import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


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

    // EditText
    EditText playerAnswer = (EditText) findViewById(R.id.displayPlayerAns);

    // Variables
        // Game variables
    int lv = 1;
    int lives = 3;
    int monsterCount;
    int[] nums = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int userIntAnswer = 0;
    String playerType = "";
    String monsterName = "";
    String userStringAnswer = "";
    boolean run;
    boolean endRound = false;
    Random rand = new Random();



        // Character varaibles
    private int playerHealth =  100;
    private double playerDamage = 4;
        // Monster variables
    private int monsterHealth = 50;
    private double monsterDamage = 5;

    // Constructors
    Player player = new Player(playerHealth, playerDamage, lv, lives);
    Monster monster = new Monster(monsterHealth, monsterDamage, lv);
    MathLogic mathProblem = new MathLogic(nums);
    Battle battle = new Battle();
    Timer timer = new Timer(lv, playerType);


    public GameMain(int[] pickedNums, boolean isRunning, String mathType)
    {
        for(int i = 0; i <= 9; i++)
        {
            nums[i] = pickedNums[i];
        }

        run = isRunning;
        playerType = mathType;
    }


    private void runGame()
    {

    }

    private void game()
    {
        timer.setTime();
        time();
        nameOfMonsterForDisplay();
        setTextViews();
        userIntAnswer = Integer.parseInt(userStringAnswer);


        
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

    private void nameOfMonsterForDisplay()
    {
        if(lv <= 13)
        {
            monster.chooseMonster();
        }
        else if (lv == 14 && playerType != "allMath")
        {
            switch(playerType)
            {
                case "addition":
                    monster.chooseBoss(0);
                    break;

                case "subtraction":
                    monster.chooseBoss(1);
                    break;

                case "multiplication":
                    monster.chooseBoss(2);
                    break;

                case "division":
                    monster.chooseBoss(3);
                    break;
            }

        }
        else if(lv >= 14 && playerType == "allMath")
        {
            switch(lv)
            {
                case 14:
                    monster.chooseBoss(0);
                    break;
                case 15:
                    monster.chooseBoss(1);
                    break;
                case 16:
                    monster.chooseBoss(2);
                    break;
                case 17:
                    monster.chooseBoss(3);
                    break;
                case 18:
                    monster.chooseBoss(4);
                    break;
            } // switch

        } // end else if
    } // end method nameOfMonsterForDisplay


    private void time()
    {

        CountDownTimer countDown = new CountDownTimer(timer.getStartTime(), timer.getInterval()) {
            @Override
            public void onTick(long millisUntilFinished) {
                textTimer.setText((int) (millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                endRound = true;
            }
        }.start();

    }

    private void getUserInput()
    {
        gameNumZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userStringAnswer.length() <= 2) {
                    userStringAnswer += "0";
                    playerAnswer.setText(userStringAnswer);
                }
            }
        });

        gameNumOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userStringAnswer.length() <= 2) {
                    userStringAnswer += "1";
                    playerAnswer.setText(userStringAnswer);
                }
            }
        });

        gameNumTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userStringAnswer.length() <= 2) {
                    userStringAnswer += "2";
                    playerAnswer.setText(userStringAnswer);
                }
            }
        });

        gameNumThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userStringAnswer.length() <= 2) {
                    userStringAnswer += "3";
                    playerAnswer.setText(userStringAnswer);
                }
            }
        });

        gameNumFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userStringAnswer.length() <= 2) {
                    userStringAnswer += "4";
                    playerAnswer.setText(userStringAnswer);
                }
            }
        });

        gameNumFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userStringAnswer.length() <= 2) {
                    userStringAnswer += "5";
                    playerAnswer.setText(userStringAnswer);
                }
            }
        });

        gameNumSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userStringAnswer.length() <= 2) {
                    userStringAnswer += "6";
                    playerAnswer.setText(userStringAnswer);
                }
            }
        });

        gameNumSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userStringAnswer.length() <= 2) {
                    userStringAnswer += "7";
                    playerAnswer.setText(userStringAnswer);
                }
            }
        });

        gameNumEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userStringAnswer.length() <= 2) {
                    userStringAnswer += "8";
                    playerAnswer.setText(userStringAnswer);
                }
            }
        });

        gameNumNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userStringAnswer.length() <= 2) {
                    userStringAnswer += "9";
                    playerAnswer.setText(userStringAnswer);
                }
            }
        });
    }
}
