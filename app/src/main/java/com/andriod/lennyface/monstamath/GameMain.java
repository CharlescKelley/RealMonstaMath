package com.andriod.lennyface.monstamath;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static com.andriod.lennyface.monstamath.R.layout.gamemain;


public class GameMain  extends AppCompatActivity {



    //Buttons views that corrispond to the layout 
    ImageButton gameNumZero, gameNumOne, gameNumTwo, gameNumThree, gameNumFour, gameNumFive;
    ImageButton gameNumSix, gameNumSeven, gameNumEight, gameNumNine, gameBack, gameEnter;

    // textviews that correspond to the layout
    TextView textCharacterName, textMonsterName, textTimer, textPlayerHealth, textMonsterHealth;
    TextView textPlayerNum, textMonsterNum, textMathSymbol, playerAnswer;

    // variables for the amount of lives the player has, the levels, the nums array, the arraylist that was sent over
    // the players answer, the monster/player name, the run boolean that was sent over, the random number generator, 
    // the playertype for the math version, the end of a round of combat boolean, boolean for whether or not the question was answered
    private int lv = 1;
    private int lives = 3;
    private int monsterCount;
    private int[] nums = new int[10];
    private ArrayList<Integer> arraylistNums = new ArrayList<>();
    private int userIntAnswer = 0;
    private String playerType = "";
    private String monsterName = "";
    private String userStringAnswer = "";
    private boolean run;
    private boolean endRound = false;
    private Random rand = new Random();
    private boolean questionAnswered = false;



    // Character varaibles
    private int playerHealth =  100;
    private int playerDamage = 4;
    // Monster variables
    private int monsterHealth = 50;
    private int monsterDamage = 5;

    // Constructors

    Player player;
    Monster monster;
    MathLogic mathProblem;
    Battle battle;
    Timer timer;

    // the oncreate where the buttons are initialized, the game is called and started, the contentview is set, the constructors 
    // for the player, monste, battle, mathproblem and timer are created, the intent is also created to get the information that
    // was pased over from the character select
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(gamemain);

        gameNumZero = (ImageButton) findViewById(R.id.zeroBtn);
        gameNumOne = (ImageButton) findViewById(R.id.oneBtn);
        gameNumTwo = (ImageButton) findViewById(R.id.twoBtn);
        gameNumThree = (ImageButton) findViewById(R.id.threeBtn);
        gameNumFour = (ImageButton) findViewById(R.id.fourBtn);
        gameNumFive = (ImageButton) findViewById(R.id.fiveBtn);
        gameNumSix = (ImageButton) findViewById(R.id.sixBtn);
        gameNumSeven = (ImageButton) findViewById(R.id.sevenBtn);
        gameNumEight = (ImageButton) findViewById(R.id.eightBtn);
        gameNumNine = (ImageButton) findViewById(R.id.nineBtn);
        gameBack = (ImageButton) findViewById(R.id.backBtn);
        gameEnter = (ImageButton) findViewById(R.id.eightBtn);

        textCharacterName = (TextView) findViewById(R.id.characterNameText);
        textMonsterName = (TextView) findViewById(R.id.monsterNameText);
        textTimer =(TextView) findViewById(R.id.timerText);
        textPlayerHealth = (TextView) findViewById(R.id.playerHealthText);
        textMonsterHealth = (TextView) findViewById(R.id.monsterHealthText);
        textPlayerNum = (TextView) findViewById(R.id.playerNumText);
        textMonsterNum = (TextView) findViewById(R.id.monsterNumText);
        textMathSymbol = (TextView) findViewById(R.id.mathSymbolText);
        playerAnswer = (TextView) findViewById(R.id.answerText);

        player = new Player(playerHealth, playerDamage, lv, lives);
        monster = new Monster(monsterHealth, monsterDamage, lv);
        mathProblem  = new MathLogic(nums);
        battle = new Battle();
        timer = new Timer(lv, playerType);
         Intent intent = getIntent();
        playerType = intent.getStringExtra("character");
        Log.d("character","here it is " + playerType);
        run = intent.getBooleanExtra("boolean", false);
        Log.d("character","here it is " + run);
        //nums = intent.getIntArrayExtra("int array");
        arraylistNums = intent.getIntegerArrayListExtra("int array");
        Log.d("character","here it is " + arraylistNums.toString());
        changeArrays(arraylistNums, nums);
        runGame(run);


    }
//

//    //Level Change Screen
//
//    //Buttons (continue button)
//    Button next; // cant write continue, guessing its a ... one of them words u cant use
//
//    //TextView ()
//    TextView lvCorrAns;
//    TextView lvWrongAns;
//    TextView ansPercent;
//
    //TextView


//    TextView textDeath = (TextView) findViewById(R.id.displayDeathMessage);
//    TextView textWin = (TextView) findViewById(R.id.displayWinMessage);

//    // EditText
//    EditText playerAnswer = (EditText) findViewById(R.id.displayPlayerAns);
//
    // Variables
        // Game variables







//    public GameMain(int[] pickedNums, boolean isRunning, String mathType)
//    {
//        nums = pickedNums;
//
//        run = isRunning;
//        playerType = mathType;
//    }

    // method to start the game
    private void runGame(boolean run)
    {
        if(run == true)
        {
            game();
        }
        //else //display title screen;

    }
    
    // actual game method. If the player still has lives the timer is started and all the text is displayed. The question is asked
    // and the battle is created. Based on what lv the charater is determines what message the player gets. I realized though after 
    // that this would be in a different activity
    private void game()
    {
        String dead = "YOU DIED!";
        String winLv = "YOU WON.... this level. ON TO THE NEXT!!";
        String winMath = "YOU WON.... this math version. ON TO THE NEXT!!";
        String megaWin = "YOU BEAT THE WHOLE GAME!!!";
        if(lives != 0) {

            timer.setTime();
            final CountDownTimer countDown = new CountDownTimer(timer.getStartTime(), timer.getInterval()) {
                @Override
                public void onTick(long millisUntilFinished) {
                    textTimer.setText(String.valueOf( (int) (millisUntilFinished/1000)));
                }

                @Override
                public void onFinish() {
                    endRound = true;
                }


            }.start();
            nameOfMonsterForDisplay();
            setTextViews();

            gameEnter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    userIntAnswer = Integer.parseInt(userStringAnswer);
                    questionAnswered = true;
                    countDown.cancel();
                }
            });


            if(playerType != "allMath" && lv < 15 )
            {

                gameRound(dead, winLv, winMath);


            }
            else if (playerType == "allMath")
            {
                gameRound(dead, winLv, megaWin);
            }
            run = true;
            runGame(run);

        }
        else if (lives == 0)
        {
//            textDeath.setText("YOU DIED AND HAVE NO MORE LIVES LEFT!!");
//            run = false;
//            runGame(run);
        }


    }

    // method to set the textviews that are diplayed, still ahve some trouble with this and havent fixed all the bugs
    private void setTextViews()
    {
        mathProblem.createPlayerNum();
        mathProblem.createMonsterNum();

        textCharacterName.setText(playerType);
        textMonsterName.setText(monster.setMonster());
        textMonsterNum.setText(Integer.toString(mathProblem.monsterNum));
        textPlayerNum.setText(Integer.toString(mathProblem.playerNum));
        textPlayerHealth.setText(Integer.toString(player.setHealth()));
        textMonsterHealth.setText(Integer.toString(monster.setHealth()));

        Log.d("character", textMonsterNum.getText().toString());
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

    // method for displaying with monster would show up and the name associtated. I didn't get to the actual showing of the monster
    /// so that mett end up have going into a different method or class even but i got the name to show up.
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




    // the method that the onclick methods are in for the number buttons the player presses during the game to answer the question
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

    // This method would have gon into a different activity
    private void gameRound(String death, String miniWin, String bigWin)
    {
        int correctAnswer = mathProblem.mathSwitch(playerType);
        int pH = player.setHealth();
        int mH = monster.setHealth();
        int pD = player.setDamage();
        int mD = monster.setDamage();
        while ((pH != 0) && (mH != 0)) {

            if (correctAnswer == userIntAnswer) {
                mH = battle.round(pH, mH, pD, mD, true);
            } else pH = battle.round(pH, mH, pD, mD, false);

            textPlayerHealth.setText(String.valueOf(pH));
            textMonsterHealth.setText(String.valueOf(mH));
        }

        if (pH == 0)
        {
            lives--;
            //textDeath.setText(death);
            // display the death screen
        } else if (mH == 0 && lv < 14)
        {
            //textWin.setText(miniWin);
            // display the lv break screen
        }
        else if (mH == 0 && lv == 14 && playerType != "allMath")
        {
            //textWin.setText(bigWin);
            // display the win screen
        }
        else if (mH == 0 && lv == 18 && playerType == "allMath")
        {
            //textWin.setText(bigWin);
            // display the best win screen
        }
    } // end gameRound

    // changes the array into an array list. I would ahve kept it as an arraylist but when i found out that intents only play nice
    // with array list and not arrays i had already coded the majority of the game using arrays.
    public void changeArrays(ArrayList<Integer> arraylistNums, int[] nums)
    {
        for(int i = 0; i < arraylistNums.size(); i++)
        {
            nums[i] = arraylistNums.get(i);
        }
    }
}
