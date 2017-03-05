package com.app.akshatha.math_quiz_app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class QuizActivity extends AppCompatActivity {

    TextView answer;
    Button n1;
    Button n2;
    Button n3;
    Button n4;
    Button n5;
    Button n6;
    Button n7;
    Button n8;
    Button n9;
    Button n0;
    Button next;



    int quesNum = 1;
    int num1;
    int num2;
    String operand;
    int result;
    int Score = 0;
    CountDownTimer timer;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        initializeTimer();
        initializeNumpad();
        generateQuestion();
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                QuitFragment quitFragment = new QuitFragment();
                quitFragment.show(getSupportFragmentManager(),"ExitFragment");


                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private void initializeTimer() {
        final TextView timerView=(TextView)findViewById(R.id.timer);
        timer = new CountDownTimer(6000, 1000) {

            public void onTick(long millisUntilFinished) {
                if(quesNum <= 10) {
                    timerView.setText("" + millisUntilFinished / 1000);
                }
                else{
                    timerView.setText("");
                }
            }

            public void onFinish() {
                if(quesNum <= 10) {
                    TimerTask task = new TimerTask() {
                        public void run() {
                            runOnUiThread(new Runnable() {

                                @Override
                                public void run() {
                                    generateQuestion();
                                }
                            });
                        }
                    };
                    Timer timer = new Timer();
                    timer.schedule(task, 500);
                }
                else{
                    timer.cancel();
                }
            }
        };
    }

    private void initializeNumpad() {

        answer = (TextView)findViewById(R.id.answer);
        n1 =(Button)findViewById(R.id.num1);
        n2 =(Button)findViewById(R.id.num2);
        n3 =(Button)findViewById(R.id.num3);
        n4 =(Button)findViewById(R.id.num4);
        n5 =(Button)findViewById(R.id.num5);
        n6 =(Button)findViewById(R.id.num6);
        n7 =(Button)findViewById(R.id.num7);
        n8 =(Button)findViewById(R.id.num8);
        n9 =(Button)findViewById(R.id.num9);
        n0 =(Button)findViewById(R.id.num0);
        next = (Button)findViewById(R.id.next);

        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText() + "1");
                checkAnswer(answer.getText().toString());
            }
        });

        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText() + "2");
                checkAnswer(answer.getText().toString());
            }
        });

        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText() + "3");
                checkAnswer(answer.getText().toString());
            }
        });

        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText() + "4");
                checkAnswer(answer.getText().toString());
            }
        });

        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText() + "5");
                checkAnswer(answer.getText().toString());
            }
        });

        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText() + "6");
                checkAnswer(answer.getText().toString());
            }
        });

        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText() + "7");
                checkAnswer(answer.getText().toString());
            }
        });

        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText() + "8");
                checkAnswer(answer.getText().toString());
            }
        });

        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText() + "9");
                checkAnswer(answer.getText().toString());
            }
        });

        n0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText() + "0");
                checkAnswer(answer.getText().toString());
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(answer.getText().toString());
            }
        });
    }

    private void checkAnswer(String text) {
        result = getResult();
        if((int)(Math.log10(result)+1) == 1) {
            if (text.equals(Integer.toString(result))) {
                final Toast toast = Toast.makeText(getApplicationContext(), "Correct",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 0);
                toast.show();
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.cancel();
                    }
                }, 500);
                Score ++;
                if(quesNum <= 10) {
                    TimerTask task = new TimerTask() {
                        public void run() {
                            runOnUiThread(new Runnable() {

                                @Override
                                public void run() {
                                    generateQuestion();
                                }
                            });
                        }
                    };
                    Timer timer = new Timer();
                    timer.schedule(task, 500);
                }else {
                    showResult();
                }
            } else {
                final Toast toast = Toast.makeText(getApplicationContext(), "Wrong",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.cancel();
                    }
                }, 500);
                if(quesNum <= 10) {
                    TimerTask task = new TimerTask() {
                        public void run() {
                            runOnUiThread(new Runnable() {

                                @Override
                                public void run() {
                                    generateQuestion();
                                }
                            });
                        }
                    };
                    Timer timer = new Timer();
                    timer.schedule(task, 500);
                }else {
                    showResult();
                }
            }
        }else if((int)(Math.log10(result)+1) == 2){
            if(text.length() == 2){
                if (text.equals(Integer.toString(result))) {
                    final Toast toast = Toast.makeText(getApplicationContext(), "Correct",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 500);
                    Score ++;
                    if(quesNum <= 10) {
                        TimerTask task = new TimerTask() {
                            public void run() {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        generateQuestion();
                                    }
                                });
                            }
                        };
                        Timer timer = new Timer();
                        timer.schedule(task, 500);
                    }else {
                        showResult();
                    }
                } else {
                    final Toast toast = Toast.makeText(getApplicationContext(), "Wrong",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 500);
                    if(quesNum <= 10) {
                        TimerTask task = new TimerTask() {
                            public void run() {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        generateQuestion();
                                    }
                                });
                            }
                        };
                        Timer timer = new Timer();
                        timer.schedule(task, 500);
                    }else {
                        showResult();
                    }
                }
            }else{
                return;
            }
        }
    }

    private int getResult() {

        if(operand.contentEquals("+")){
            result = num1 + num2;
        }else if(operand.contentEquals("-")){
            result = num1 - num2;
        }else if(operand.contentEquals("*")){
            result = num1 * num2;
        }
        return result;
    }

    private void generateQuestion() {
        if(quesNum <= 10) {
            timer.cancel();
            answer.setText("");
            Random random = new Random();
            operand = getIntent().getStringExtra("operand");
            if (operand.equals("-")) {
                num1 = random.nextInt(10);
                num2 = random.nextInt(num1);
            } else {
                num1 = random.nextInt(10);
                num2 = random.nextInt(10);
            }
            TextView num1View = (TextView) findViewById(R.id.number1);
            TextView num2View = (TextView) findViewById(R.id.number2);
            TextView operandView = (TextView) findViewById(R.id.operand);
            TextView quesNo = (TextView) findViewById(R.id.questionNumber);

            num1View.setText(String.valueOf(num1));
            num2View.setText(String.valueOf(num2));
            operandView.setText(operand);
            quesNo.setText(String.valueOf(quesNum));
            quesNum++;
            if (quesNum > 10) {
                showResult();
            }
            timer.start();
        }

    }

    private void showResult() {

        final Dialog dialog = new Dialog(context);

        dialog.setContentView(R.layout.result);

        dialog.setTitle("Score Card");
        Button dialogButtonOk = (Button) dialog.findViewById(R.id.ok);
        TextView score = (TextView) dialog.findViewById(R.id.score);
        score.setText(Score + "");


        dialogButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeActivity();
            }
        });

        dialog.show();
        timer.cancel();

    }

    @Override
    protected void onPause(){
        super.onPause();
        timer.onFinish();
    }


    private void closeActivity() {
        super.finish();
    }
}
