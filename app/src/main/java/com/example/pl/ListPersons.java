package com.example.pl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ListPersons extends AppCompatActivity {
    Button addContact, addGroup;
    RecyclerView recyclerView;
    ContactAdapter contactAdapter;
    List<Person> personList;

    HelperSQL helperSQL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_persons);

        helperSQL = new HelperSQL(this);

        addContact = findViewById(R.id.addP);
        addGroup = findViewById(R.id.addG);
        recyclerView = findViewById(R.id.rv);
        personList = helperSQL.getAll();

        contactAdapter = new ContactAdapter(this, personList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(contactAdapter);

        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(ListPersons.this, AddContactActivity.class), 1);
            }
        });

        addGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(ListPersons.this, AddGroupActivity.class), 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            personList = helperSQL.getAll();
            contactAdapter = new ContactAdapter(this, personList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            recyclerView.setAdapter(contactAdapter);

            contactAdapter.notifyDataSetChanged();
        }
    }
}
