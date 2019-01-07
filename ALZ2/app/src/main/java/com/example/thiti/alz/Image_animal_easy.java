package com.example.thiti.alz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Image_animal_easy extends AppCompatActivity {

    List<CountryItem> list;

    ImageView img;
    Button next;
    Random r;
    int turn = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_animal_easy);

        r = new Random();

        img = (ImageView) findViewById(R.id.imageView2);
        next = (Button) findViewById(R.id.next);

        list = new ArrayList<>();

        for (int i = 0; i < new Database().ans_animal_easy.length;i++){
            list.add(new CountryItem(new Database().ans_animal_easy[i], new Database().animal_easy[i]));
        }

        Collections.shuffle(list);

        im(turn);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (turn < list.size()) {
                    turn++;
                    im(turn);
                }else{
                    Intent intent = new Intent(Image_animal_easy.this, animal_easy.class);
                    startActivity(intent);
                }
            }
        });
    }
    private void im(int number){
        img.setImageResource(list.get(number - 1).getImage());
    }
}
