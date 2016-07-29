package com.wolffox.aufr.apprestaurante;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.wolffox.aufr.apprestaurante.Clases.Adapter;
import com.wolffox.aufr.apprestaurante.Clases.Pedido;

public class ConfirmarPedidoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_pedido);

        ListView lvPedido = (ListView) findViewById(R.id.listViewPedido);
        String[] theNamesPedido = new String[1];
        String[] theDescriptionsPedido = new String[1];
        String[] thePricesPedido = new String[1];
        int[] theImagesPedido = new int[1];

        String total = "";

        if(!Pedido.nameMenu.equals("")) {
            theNamesPedido[0] = Pedido.nameMenu;
            theDescriptionsPedido[0] = Pedido.descriptionMenu;
            thePricesPedido[0] = Pedido.priceMenu;
            theImagesPedido[0] = Pedido.imgMenu;

            total = Pedido.priceMenu;

        }else{
            theNamesPedido[0] = Pedido.nameExtra;
            theDescriptionsPedido[0] = Pedido.descriptionExtra;
            thePricesPedido[0] = Pedido.priceExtra;
            theImagesPedido[0] = Pedido.imgExtra;

            total = Pedido.priceExtra;
        }
        //Adapter
        Adapter adapter = new Adapter(this, theNamesPedido, theDescriptionsPedido, thePricesPedido, theImagesPedido);
        lvPedido.setAdapter(adapter);

        Button mEmailSignInButton = (Button) findViewById(R.id.btnConfirmarPedido);
        mEmailSignInButton.setText("CONFIRMAR S/"+total);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Confirmado", Toast.LENGTH_SHORT).show();

                Intent myIntent = new Intent(ConfirmarPedidoActivity.this, SuccessfulOrder.class);
                ConfirmarPedidoActivity.this.startActivity(myIntent);
            }
        });
    }


}
