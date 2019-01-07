package com.example.thiti.alz;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Arrays;

public class Select extends AppCompatActivity {

    private ImageButton play;
    private Button al;
    String[] listitem;
    String[] level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        play = (ImageButton)findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listitem = new String[]{"สิ่งของ","สัตว์","สถานที่"};
                AlertDialog.Builder mDialog = new AlertDialog.Builder(Select.this);
                mDialog.setTitle("เลือกประเภท");
                mDialog.setSingleChoiceItems(listitem, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, final int i) {
                        if (i == 0) {
                            level = new String[]{"ง่าย", "ยาก"};
                            final AlertDialog.Builder mDialog1 = new AlertDialog.Builder(Select.this);
                            mDialog1.setTitle("เลือกความยาก");
                            mDialog1.setSingleChoiceItems(level, -1, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (which == 0) {
                                        Intent intent = new Intent(Select.this, Image_view.class);
                                        startActivity(intent);
                                    } else {
                                        Intent intent = new Intent(Select.this, SplashScreen.class);
                                        startActivity(intent);
                                    }
                                }
                            });
                            AlertDialog mDia11 = mDialog1.create();
                            mDia11.show();
                        }
                        if (i == 1) {
                            level = new String[]{"ง่าย", "ยาก"};
                            final AlertDialog.Builder mDialog1 = new AlertDialog.Builder(Select.this);
                            mDialog1.setTitle("เลือกความยาก");
                            mDialog1.setSingleChoiceItems(level, -1, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (which == 0) {
                                        Intent intent = new Intent(Select.this, Image_animal_easy.class);
                                        startActivity(intent);
                                    } else {
                                        Intent intent = new Intent(Select.this, Image_animal_hard.class);
                                        startActivity(intent);
                                    }
                                }
                            });
                            AlertDialog mDia11 = mDialog1.create();
                            mDia11.show();
                        }
                        if (i == 2) {
                            level = new String[]{"ง่าย", "ยาก"};
                            final AlertDialog.Builder mDialog1 = new AlertDialog.Builder(Select.this);
                            mDialog1.setTitle("เลือกความยาก");
                            mDialog1.setSingleChoiceItems(level, -1, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (which == 0) {
                                        Intent intent = new Intent(Select.this, Image_view.class);
                                        startActivity(intent);
                                    } else {
                                        Intent intent = new Intent(Select.this, Image_place_hard.class);
                                        startActivity(intent);
                                    }
                                }
                            });
                            AlertDialog mDia11 = mDialog1.create();
                            mDia11.show();
                        }
                    }
                });
                AlertDialog mDia1 = mDialog.create();
                mDia1.show();
            }
        });
        al = (Button)findViewById(R.id.button3);
        al.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.bumrungrad.com/th/betterhealth/2556/better-brain-health/dementia-alzheimer"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
