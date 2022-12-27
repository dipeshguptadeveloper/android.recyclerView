package com.example.recyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModel> arrContacts = new ArrayList<>();
    FloatingActionButton btnOpenDialog;
    EditText edtName, edtNumber;
    Button btnAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        step1
        RecyclerView recyclerContact = findViewById(R.id.recyclerContact);

//        step2 - define layout manager

        recyclerContact.setLayoutManager(new LinearLayoutManager(this));


//        step3 - make a layout for showing the data (same as flat list in react native (js))

//        step4 - make a model for declaring variable which we have to show as per layout

//        step5 - make a constructor which take input as per defined variables in array list

//        step6 - define the array list with model

//        step7 - now add the data in array list in below format

        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "A", "9867990635"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "B", "9867990635"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "C", "9867990635"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "D", "9867990635"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "E", "9867990635"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "F", "9867990635"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "G", "9867990635"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "H", "9867990635"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "I", "9867990635"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "J", "9867990635"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "K", "9867990635"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "L", "9867990635"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "M", "9867990635"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "N", "9867990635"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "O", "9867990635"));


//        step8 - make a adapter file & define view older

        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this, arrContacts);
        recyclerContact.setAdapter(adapter);


//        Adding, Updating & Deleting items of Recycler View

        btnOpenDialog = findViewById(R.id.btnOpenDialog);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_layout);

                edtName = dialog.findViewById(R.id.edtName);
                edtNumber = dialog.findViewById(R.id.edtNumber);
                btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String name = "", number = "";

                        if (!edtName.getText().toString().equals("")) {
                            name = edtName.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please Enter Contact Name", Toast.LENGTH_SHORT).show();
                        }

                        if (!edtNumber.getText().toString().equals("")) {
                            number = edtNumber.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please Enter Contact Number", Toast.LENGTH_SHORT).show();
                        }

                        arrContacts.add(new ContactModel(name, number));

                        adapter.notifyItemInserted(arrContacts.size()-1);

                        recyclerContact.scrollToPosition(arrContacts.size()-1);

                        dialog.dismiss();

                    }
                });

                dialog.show();
            }
        });


    }
}