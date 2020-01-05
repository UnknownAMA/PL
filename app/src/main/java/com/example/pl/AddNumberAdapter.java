package com.example.pl;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AddNumberAdapter extends RecyclerView.Adapter<AddNumberAdapter.MyViewHolder> {
    Activity activity;
    List<Number> list;
    AddNumberIterface addNumberIterface;

    public AddNumberAdapter(Activity activity, List<Number> list) {
        this.activity = activity;
        this.list = list;

        addNumberIterface = ((AddContactActivity)activity);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(activity).inflate(R.layout.item_add_number, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.number.setText(list.get(position).getNumber());

        holder.number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                list.get(position).setNumber(s.toString());
                addNumberIterface.onAdd(list);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(new Number("", ""));
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        EditText number;
        RadioGroup radioGroup;
        ImageView add;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            number = itemView.findViewById(R.id.et_number);
            radioGroup = itemView.findViewById(R.id.radiogroup);
            add = itemView.findViewById(R.id.img_add);
        }


    }
}

