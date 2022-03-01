package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    List<ImageView> cardList;
    Button myButton;
    TextView myText;
    Random random;
    int correctNumber;
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();
        correctNumber = -1;

        mPlayer = MediaPlayer.create(this, R.raw.cat_meow);

        myButton = findViewById(R.id.myButton);

        cardList = new ArrayList<ImageView>();
        myText = findViewById(R.id.myText);
        ImageView card1 = findViewById(R.id.card1);
        cardList.add(card1);
        ImageView card2 = findViewById(R.id.card2);
        cardList.add(card2);
        ImageView card3 = findViewById(R.id.card3);
        cardList.add(card3);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0; i < 3; i++) {
                    ImageView card = cardList.get(i);
                    card.setImageResource(R.drawable.card);
                }
                correctNumber = random.nextInt(3);
                myText.setText("");
            }
        });

        for (int i = 0; i < 3; i++) {
            ImageView card = cardList.get(i);
            card.setTag(i);
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedCard((int)view.getTag());
                }
            });
        }
    }

    private void selectedCard(int chosen) {
        if(correctNumber != -1) {
            ImageView card = cardList.get(chosen);
            if (chosen == correctNumber) {
                mPlayer.start();
                card.setImageResource(R.drawable.cat);
                myText.setText("Congrats!");
            } else {
                card.setImageResource(R.drawable.dog);
            }
            correctNumber = -1;
        }
    }
}