package com.example.wyznaczanielatprzestpnych;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    EditText erok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        erok=findViewById(R.id.erok);
    }

    /* sprawdz czy dany rok jest przestepny */
    private static boolean przestepny(int rok)
    {
        return ((rok % 4 == 0) && (rok % 100 != 0)) || (rok % 400 == 0);
    }

    public void sprawdz(View view){
        int rok=0;
        String bufor="";
        tv.setText("");
        try{
            rok=Integer.parseInt(erok.getText().toString());
            if (przestepny(rok)){
                bufor="Rok "+rok+" jest przestepny.";
            }
            else {
                bufor="Rok "+rok+" nie jest przestepny.";
            }
        }catch(Exception blad){
            Toast.makeText(this,blad.getMessage(),Toast.LENGTH_LONG).show();
            bufor="";
        }finally {
            erok.setText("");
            tv.setText(bufor);
        }
    }
}