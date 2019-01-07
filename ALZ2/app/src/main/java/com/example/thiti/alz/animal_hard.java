package com.example.thiti.alz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class animal_hard extends AppCompatActivity {

    Button b_answer1,b_answer2,b_answer3,b_answer4;

    ImageView iv_flag;
    TextView score;
    private int mScore = 0;

    Random r;
    List<CountryItem> list;

    int turn = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_hard);

        r = new Random();

        iv_flag = (ImageView) findViewById(R.id.iv_flag);
        b_answer1 = (Button) findViewById(R.id.b_answer_1);
        b_answer2 = (Button) findViewById(R.id.b_answer_2);
        b_answer3 = (Button) findViewById(R.id.b_answer_3);
        b_answer4 = (Button) findViewById(R.id.b_answer_4);
        score = (TextView) findViewById(R.id.score);

        list = new ArrayList<>();

        for (int i = 0; i < new Database().ans__place_hard.length;i++){
            list.add(new CountryItem(new Database().ans__place_hard[i], new Database().place_hard[i]));
        }

        Collections.shuffle(list);
        newQuestion(turn);

        b_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b_answer1.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())){
                    Toast.makeText(animal_hard.this, "Correct", Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score : " + mScore);
                    if (turn < list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(animal_hard.this, "Finish", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(animal_hard.this, "Wrong", Toast.LENGTH_SHORT).show();
                    mScore--;
                    if (turn < list.size()){
                        turn++;
                        newQuestion(turn);
                        if (mScore < 0){
                            mScore = 0;
                        }
                    }
                }
            }
        });

        b_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b_answer2.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())){
                    Toast.makeText(animal_hard.this, "Correct", Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score : " + mScore);
                    if (turn < list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(animal_hard.this, "Finish", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(animal_hard.this, "Wrong", Toast.LENGTH_SHORT).show();
                    mScore--;
                    if (turn < list.size()){
                        turn++;
                        newQuestion(turn);
                        if (mScore < 0){
                            mScore = 0;
                        }
                    }
                }
            }
        });

        b_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b_answer3.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())){
                    Toast.makeText(animal_hard.this, "Correct", Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score : " + mScore);
                    if (turn < list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(animal_hard.this, "Finish", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(animal_hard.this, "Wrong", Toast.LENGTH_SHORT).show();
                    mScore--;
                    if (turn < list.size()){
                        turn++;
                        newQuestion(turn);
                        if (mScore < 0){
                            mScore = 0;
                        }
                    }
                }
            }
        });

        b_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b_answer4.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())){
                    Toast.makeText(animal_hard.this, "Correct", Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score : " + mScore);
                    if (turn < list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(animal_hard.this, "Finish", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(animal_hard.this, "Wrong", Toast.LENGTH_SHORT).show();
                    mScore--;
                    if (turn < list.size()){
                        turn++;
                        newQuestion(turn);
                        if (mScore < 0){
                            mScore = 0;
                        }
                    }

                }
            }
        });
    }

    private void newQuestion(int number){
        iv_flag.setImageResource(list.get(number - 1).getImage());

        int correct_answer = r.nextInt(4)+1;

        int firstButton = number - 1;
        int secoundButton;
        int thirdButton;
        int frothButton;

        switch (correct_answer){
            case 1:
                b_answer1.setText(list.get(firstButton).getName());

                do {
                    secoundButton = r.nextInt(list.size());
                }while (secoundButton == firstButton);
                do {
                    thirdButton = r.nextInt(list.size());
                }while (thirdButton == firstButton || thirdButton == secoundButton);
                do{
                    frothButton = r.nextInt(list.size());
                }while (frothButton == firstButton || frothButton == secoundButton || frothButton == thirdButton);

                b_answer2.setText(list.get(secoundButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(frothButton).getName());
                break;
            case 2:
                b_answer2.setText(list.get(firstButton).getName());

                do {
                    secoundButton = r.nextInt(list.size());
                }while (secoundButton == firstButton);
                do {
                    thirdButton = r.nextInt(list.size());
                }while (thirdButton == firstButton || thirdButton == secoundButton);
                do{
                    frothButton = r.nextInt(list.size());
                }while (frothButton == firstButton || frothButton == secoundButton || frothButton == thirdButton);

                b_answer1.setText(list.get(secoundButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(frothButton).getName());
                break;
            case 3:
                b_answer3.setText(list.get(firstButton).getName());

                do {
                    secoundButton = r.nextInt(list.size());
                }while (secoundButton == firstButton);
                do {
                    thirdButton = r.nextInt(list.size());
                }while (thirdButton == firstButton || thirdButton == secoundButton);
                do{
                    frothButton = r.nextInt(list.size());
                }while (frothButton == firstButton || frothButton == secoundButton || frothButton == thirdButton);

                b_answer2.setText(list.get(secoundButton).getName());
                b_answer1.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(frothButton).getName());
                break;
            case 4:
                b_answer4.setText(list.get(firstButton).getName());

                do {
                    secoundButton = r.nextInt(list.size());
                }while (secoundButton == firstButton);
                do {
                    thirdButton = r.nextInt(list.size());
                }while (thirdButton == firstButton || thirdButton == secoundButton);
                do{
                    frothButton = r.nextInt(list.size());
                }while (frothButton == firstButton || frothButton == secoundButton || frothButton == thirdButton);

                b_answer2.setText(list.get(secoundButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer1.setText(list.get(frothButton).getName());
                break;
        }
    }
}
