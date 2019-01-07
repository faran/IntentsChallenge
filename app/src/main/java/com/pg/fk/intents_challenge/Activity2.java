package com.pg.fk.intents_challenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements View.OnClickListener{

    EditText etName, etNumber, etWebsite, etLocation;
    ImageView ivHappy, ivNeutral, ivSad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        etWebsite = findViewById(R.id.etWebsite);
        etLocation = findViewById(R.id.etLocation);

        ivHappy = findViewById(R.id.ivHappy);
        ivNeutral = findViewById(R.id.ivNeutral);
        ivSad = findViewById(R.id.ivSad);

        ivSad.setOnClickListener(this);
        ivHappy.setOnClickListener(this);
        ivNeutral.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){

        if(etName.getText().toString().isEmpty() || etNumber.getText().toString().isEmpty()
                        || etWebsite.getText().toString().isEmpty() || etWebsite.getText().toString().isEmpty()) {
                    Toast.makeText(Activity2.this, "Please enter text in all fields ", Toast.LENGTH_SHORT).show();
        }
        else{

            Intent intent = new Intent();

//            intent.putStringArrayListExtra("data", );
//            stringList.add(name);
//            stringList.add(number);
//            stringList.add(website);
//            stringList.add(location);
//            stringList.add(happy);

            intent.putExtra("name", etName.getText().toString().trim());
            intent.putExtra("number", etNumber.getText().toString().trim());
            intent.putExtra("web", etWebsite.getText().toString().trim());
            intent.putExtra("map", etLocation.getText().toString().trim());

            if (view.getId() == R.id.ivHappy){
                intent.putExtra("mood", "happy");
            }else if(view.getId() == R.id.ivNeutral){
                intent.putExtra("mood", "ok");
            }else if(view.getId() == R.id.ivSad){
                intent.putExtra("mood", "sad");
            }

            setResult(RESULT_OK, intent);
            Activity2.this.finish();
        }
    }
}
