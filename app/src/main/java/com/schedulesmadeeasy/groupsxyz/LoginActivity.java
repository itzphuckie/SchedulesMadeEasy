package com.schedulesmadeeasy.groupsxyz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//TODO MAKE EDIT TEXT EMPTY WHEN THEY FIRST CLICK ON IT, THEN MAKE IT EDITABLE FROM THE END
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button button = findViewById(R.id.sign_in_button_login);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //TODO VALIDATE LOGIN CREDENTIALS
                Intent intent = new Intent(v.getContext(), HomePageActivity.class);
                startActivity(intent);
            }
        });
    }
}
