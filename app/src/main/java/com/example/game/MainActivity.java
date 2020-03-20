package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnOK;
    TextView outMessage;
    EditText input;
    int number = 0;
    int chosenNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOK = findViewById(R.id.btnOK);
        input = findViewById(R.id.editText);
        outMessage = findViewById(R.id.textView);

        outMessage.setText("Enter a number between 0 and 100");
        Random rnd = new Random();
        chosenNumber = rnd.nextInt(100);
        final Intent intent = getIntent();

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number = Integer.parseInt(input.getText().toString());
                if(number < chosenNumber){
                    outMessage.setText("Enter a bigger number!");
                }
                if(number > chosenNumber){
                    outMessage.setText("Enter a smaller number!");
                }
                if(chosenNumber == number){
                    outMessage.setText("Congratulations! You found the number!");

                    AlertDialog diag = new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Game")
                            .setMessage("Do you want to play again?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                    startActivity(intent);
                                }
                            })
                            .setNegativeButton(android.R.string.no, null)
                            .setIcon(android.R.drawable.ic_dialog_info)
                            .show();
                }

            }
        });
    }
}
