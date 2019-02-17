package com.example.biddutkumar.firebasedatastore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button saveBtn,loadBtn;
    private EditText nameET,ageET;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference=FirebaseDatabase.getInstance().getReference("students");

        saveBtn=findViewById(R.id.saveBtnId);
        loadBtn=findViewById(R.id.loadBtnId);
        nameET=findViewById(R.id.nameETId);
        ageET=findViewById(R.id.ageETId);

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DetailsActivity.class);
                startActivity(intent);

            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    public void saveData()
    {
        String name=nameET.getText().toString().trim();
        String age=ageET.getText().toString().trim();

        String key=databaseReference.push().getKey();
        Student student=new Student(name, age);
        databaseReference.child(key).setValue(student);

        Toast.makeText(getApplicationContext(), "Studnet info is successfully added", Toast.LENGTH_LONG).show();

        nameET.setText("");
        ageET.setText("");

    }
}
