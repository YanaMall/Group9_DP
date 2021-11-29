package com.example.group9_digitalpet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.DatePicker;

public class FriendWalk extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedulewalk);

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        DatePicker datePicker = (DatePicker)findViewById(R.id.datePicker1);

        Button schedWalk = (Button)findViewById(R.id.schedwalk);
        schedWalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId=radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton =(RadioButton)findViewById(selectedId);
                CharSequence text = "You have scheduled a walk with " + radioButton.getText() +" on " + datePicker.getDayOfMonth()+"/"+ (datePicker.getMonth() + 1);
                Toast.makeText(FriendWalk.this, text, Toast.LENGTH_LONG).show();
                setContentView(R.layout.activity_main);
            }
        });
        Button backToMain = (Button)findViewById(R.id.backToMain);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(FriendWalk.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
