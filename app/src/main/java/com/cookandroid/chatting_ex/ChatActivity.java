package com.cookandroid.chatting_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChatActivity extends AppCompatActivity {

    EditText GetEmail;
    String email;
    Button Finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        GetEmail = findViewById(R.id.GetEmail);
        Finish = findViewById(R.id.Finish);

        Finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = GetEmail.getText().toString();

                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");

                myRef.setValue(email);
            }
        });


        //1. recyclerView - 반복
        //2. 디비 내용을 넣는다
        //3. 상대방 폰에 채팅 내용이 보임
    }
}
