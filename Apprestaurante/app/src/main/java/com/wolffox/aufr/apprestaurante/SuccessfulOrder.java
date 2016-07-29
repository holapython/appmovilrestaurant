package com.wolffox.aufr.apprestaurante;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class SuccessfulOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_order);

        TextView tv = (TextView)findViewById(R.id.textViewSuccessfulOrder);
        Random rnd = new Random();
        int tiemesp=(int) (rnd.nextDouble() * 25 + 5);
        String message = "Su orden está\nsiendo preparada\n";
        message = message+"Por favor espere: "+tiemesp+"min\n";
        message = message+"¡MUCHAS GRACIAS!";
        tv.setText(message);
    }
}
