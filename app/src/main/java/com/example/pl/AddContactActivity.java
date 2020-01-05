package com.example.pl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class AddContactActivity extends AppCompatActivity implements AddNumberIterface {
    RecyclerView numbersRv;
    AddNumberAdapter addNumberAdapter;
    List<Number> numberList;
    HelperSQL helper;
    EditText firstname, lastname, nickname, work, home, email, website, birthdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        helper = new HelperSQL(this);

        numbersRv = findViewById(R.id.rv_numbers);
        firstname = findViewById(R.id.et_firstname);
        lastname = findViewById(R.id.et_lastname);
        nickname = findViewById(R.id.et_nickname);
        work = findViewById(R.id.et_work);
        home = findViewById(R.id.et_home);
        email = findViewById(R.id.et_email);
        website = findViewById(R.id.et_website);
        birthdate = findViewById(R.id.et_birthdate);


        numberList = new ArrayList<>();
        numberList.add(new Number("", ""));

        addNumberAdapter = new AddNumberAdapter(this, numberList);
        numbersRv.setLayoutManager(new LinearLayoutManager(this));

        numbersRv.setAdapter(addNumberAdapter);

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.Add(new Person(0, "", firstname.getText().toString(), lastname.getText().toString(), nickname.getText().toString(), "", work.getText().toString(), home.getText().toString(), email.getText().toString(), website.getText().toString(), birthdate.getText().toString(), "", "", "", "", "", ""));
                setResult(1);
                finish();
            }
        });
    }

    @Override
    public void onAdd(List<Number> numberList) {
        this.numberList = numberList;
        addNumberAdapter = new AddNumberAdapter(this, numberList);
        numbersRv.setLayoutManager(new LinearLayoutManager(this));

        numbersRv.setAdapter(addNumberAdapter);

        addNumberAdapter.notifyDataSetChanged();


    }
}
