package com.example.pl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class AddGroupActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    HelperSQL helperSQL;
    RecyclerView recyclerView;
    ContactAdapter contactAdapter;
    List<Person> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);

        helperSQL = new HelperSQL(this);

        editText = findViewById(R.id.et_add_group);
        button = findViewById(R.id.btn_add);
        recyclerView = findViewById(R.id.rv);

        list = helperSQL.getAll();

        contactAdapter = new ContactAdapter(this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(contactAdapter);

        helperSQL = new HelperSQL(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Person p: list) {

                }
            }
        });
    }
}
