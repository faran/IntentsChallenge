package com.pg.fk.intents_challenge;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int ACTIVITY2 = 2;
    Button btnCreateNewContact;
    ImageView ivPhone, ivMap, ivWebsite, ivEmoticon;
    String name = "";
    String number = "";
    String website = "";
    String address = "";
    String mood = "";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ACTIVITY2){
            if(resultCode == RESULT_OK){

                ivMap.setVisibility(View.VISIBLE);
                ivPhone.setVisibility(View.VISIBLE);
                ivWebsite.setVisibility(View.VISIBLE);
                ivEmoticon.setVisibility((View.VISIBLE));

                name = data.getStringExtra("name");
                number = data.getStringExtra("number");
                website = data.getStringExtra("web");
                address = data.getStringExtra("map");
                mood = data.getStringExtra("mood");

                if(mood.equals("happy")){
                    ivEmoticon.setImageResource(R.drawable.ic_sentiment_satisfied_black_24dp);
                }else if(mood.equals("sad")){
                    ivEmoticon.setImageResource(R.drawable.ic_sentiment_dissatisfied_black_24dp);
                }else{
                    ivEmoticon.setImageResource(R.drawable.ic_sentiment_neutral_black_24dp);
                }
            }else{
                Toast.makeText(this, "No data passed through ", Toast.LENGTH_SHORT);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreateNewContact = findViewById(R.id.btnCreateNewContact);
        ivWebsite = findViewById(R.id.ivWebsite);
        ivPhone = findViewById(R.id.ivPhone);
        ivMap = findViewById(R.id.ivMap);
        ivEmoticon = findViewById(R.id.ivEmoticon);

        ivMap.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        ivWebsite.setVisibility(View.GONE);
        ivEmoticon.setVisibility(View.GONE);


        btnCreateNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        com.pg.fk.intents_challenge.Activity2.class);
                startActivityForResult(intent, ACTIVITY2);
            }
        });

        ivMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+address));
                startActivity(intent);
            }
        });

        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });

        ivWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+website));
                startActivity(intent);
            }
        });
    }
}
