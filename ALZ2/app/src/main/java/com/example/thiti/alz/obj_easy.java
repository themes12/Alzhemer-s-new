package com.example.thiti.alz;

import android.content.Intent;
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

public class obj_easy extends AppCompatActivity {

    Button b_answer1,b_answer2;

    ImageView iv_flag;
    TextView score;
    private int mScore = 0;

    Random r;
    List<CountryItem> list1;

    int turn = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obj_easy);

        r = new Random();

        iv_flag = (ImageView) findViewById(R.id.iv_flag);
        b_answer1 = (Button) findViewById(R.id.b_answer_1);
        b_answer2 = (Button) findViewById(R.id.b_answer_2);
        score = (TextView) findViewById(R.id.score);

        list1 = new ArrayList<>();

        for (int i = 0; i < new Database().ans_obj_easy.length;i++){
            list1.add(new CountryItem(new Database().ans_obj_easy[i], new Database().obj_easy[i]));
        }

        Collections.shuffle(list1);
        newQuestion(turn);

        b_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b_answer1.getText().toString().equalsIgnoreCase(list1.get(turn - 1).getName())){
                    Toast.makeText(obj_easy.this, "Correct", Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score : " + mScore);
                    if(b_answer1.getText() == b_answer2.getText()){
                        b_answer1.setText("ไม่เคย");
                    }else{
                        b_answer2.setText("ไม่เคย");
                    }
                    if (turn < list1.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Intent intent = new Intent(obj_easy.this, end.class);
                        startActivity(intent);                    }
                }else{
                    Toast.makeText(obj_easy.this, "Wrong", Toast.LENGTH_SHORT).show();
                    mScore--;
                    if(b_answer1.getText() == b_answer2.getText()){
                        b_answer1.setText("ไม่เคย");
                    }else{
                        b_answer2.setText("ไม่เคย");
                    }
                    if (turn < list1.size()){
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
                if (b_answer2.getText().toString().equalsIgnoreCase(list1.get(turn - 1).getName())){
                    Toast.makeText(obj_easy.this, "Correct", Toast.LENGTH_SHORT).show();
                    mScore++;
                    score.setText("Score : " + mScore);
                    if(b_answer2.getText() == b_answer1.getText()){
                        b_answer1.setText("ไม่เคย");
                    }else{
                        b_answer2.setText("ไม่เคย");
                    }
                    if (turn < list1.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Intent intent = new Intent(obj_easy.this, end.class);
                        startActivity(intent);                      }
                }else{
                    Toast.makeText(obj_easy.this, "Wrong", Toast.LENGTH_SHORT).show();
                    mScore--;
                    if(b_answer2.getText() == b_answer1.getText()){
                        b_answer1.setText("ไม่เคย");
                    }else{
                        b_answer2.setText("ไม่เคย");
                    }
                    if (turn < list1.size()){
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
        iv_flag.setImageResource(list1.get(number - 1).getImage());

        int correct_answer = r.nextInt(2)+1;

        int firstButton = number - 1;
        int secoundButton;

        switch (correct_answer){
            case 1:
                b_answer1.setText(list1.get(firstButton).getName());

                do {
                    secoundButton = r.nextInt(list1.size());
                }while (secoundButton == firstButton);

                b_answer2.setText(list1.get(secoundButton).getName());
                break;
            case 2:
                b_answer2.setText(list1.get(firstButton).getName());

                do {
                    secoundButton = r.nextInt(list1.size());
                }while (secoundButton == firstButton);

                b_answer1.setText(list1.get(secoundButton).getName());
                break;
        }
    }
}
