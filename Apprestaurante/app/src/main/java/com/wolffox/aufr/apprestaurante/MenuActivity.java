    package com.wolffox.aufr.apprestaurante;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.wolffox.aufr.apprestaurante.Clases.Adapter;
import com.wolffox.aufr.apprestaurante.Clases.Pedido;

public class MenuActivity extends AppCompatActivity {

    ListView lvMenus;
    String[] theNamesMenu = {"pollo al cilindro", "trucha", "pachamanca mixta"};
    String[] theDescriptionsMenu = {"En un bol se coloca el pisco y el ajo triturado (menjunje químico), luego adicionamos extracto de kión, sal, azúcar y salsa de soya clara. Esta primera base se deja  4 a 6 horas o toda la anoche", "Aprende a preparar esta estupenda trucha al horno que te proponemos en esta receta. Seguro que si nunca la has probado te va a sorprender lo rica que queda y lo sencillo que se prepara", "\n" +
            "Inicio Como preparar Pachamanca Pachamanca Recetas andinas Recetas con carnes Recetas peruanas\n" +
            "Pachamanca\n" +
            "\n" +
            "  0:41   P  , PACHAMANCA  , RECETAS ANDINAS  , RECETAS CON CARNES  , RECETAS PERUANAS\n" +
            "La PACHAMANCA es un plato que se prepara en todos los departamentos de la Sierra del Perú"};
    String[] thePricesMenu = {"10.00", "20.00", "30.00"};
    int[] theImagesMenu = {R.drawable.menu, R.drawable.menu, R.drawable.menu};

    ListView lvExtras;
    String[] theNamesExtra = {"Escabeche", "Cuy Chactado", "chicharron de chancho"};
    String[] theDescriptionsExtra = {"El escabeche peruano es un plato que puede consumirse tanto en reuniones familiares como durante la semana", "Un cuy \n +
            "Media taza de aceite.\n" +
            "Dos dientes de ajo molido.\n" +
            "Limón.\n" +
            "Sal y cominos al gusto.", "preparado con carne de chancho,  papas y mote y ensalada"};
    String[] thePricesExtra = {"40.00", "50.00", "60.00"};
    int[] theImagesExtra = {R.drawable.extra, R.drawable.extra, R.drawable.extra};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pida su descuento por Fiestas Patrias :D", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TabHost tabs = (TabHost)findViewById(R.id.tabHost);
        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("mytab1");
        spec.setContent(R.id.mytab1);
        spec.setIndicator("MENU",null);
        tabs.addTab(spec);

        spec = tabs.newTabSpec("mytab2");
        spec.setContent(R.id.mytab2);
        spec.setIndicator("EXTRA",null);
        tabs.addTab(spec);

        tabs.setCurrentTab(0);

        lvMenus = (ListView) findViewById(R.id.listViewMenus);
        //Adapter
        Adapter adapter = new Adapter(this, theNamesMenu, theDescriptionsMenu, thePricesMenu, theImagesMenu);
        lvMenus.setAdapter(adapter);

        lvMenus.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
                Toast.makeText(getApplicationContext(), theNamesMenu[pos], Toast.LENGTH_SHORT).show();

                Pedido.nameMenu = theNamesMenu[pos];
                Pedido.descriptionMenu = theDescriptionsMenu[pos];
                Pedido.priceMenu = thePricesMenu[pos];
                Pedido.imgMenu = theImagesMenu[pos];
                Intent myIntent = new Intent(MenuActivity.this, ConfirmarPedidoActivity.class);
                MenuActivity.this.startActivity(myIntent);
            }
        });

        lvExtras = (ListView) findViewById(R.id.listViewExtras);
        //Adapter
        adapter = new Adapter(this, theNamesExtra, theDescriptionsExtra, thePricesExtra, theImagesExtra);
        lvExtras.setAdapter(adapter);

        lvExtras.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
                Toast.makeText(getApplicationContext(), theNamesExtra[pos], Toast.LENGTH_SHORT).show();

                Pedido.nameExtra = theNamesExtra[pos];
                Pedido.descriptionExtra = theDescriptionsExtra[pos];
                Pedido.priceExtra = thePricesExtra[pos];
                Pedido.imgExtra = theImagesExtra[pos];
                Intent myIntent = new Intent(MenuActivity.this, ConfirmarPedidoActivity.class);
                MenuActivity.this.startActivity(myIntent);
            }
        });
    }
}
