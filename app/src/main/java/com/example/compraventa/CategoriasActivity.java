package com.example.compraventa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class CategoriasActivity extends AppCompatActivity {

    private ArrayList<String> categorias;
    RecyclerView recyclerCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        recyclerCategoria = (RecyclerView) findViewById(R.id.recyclerCategoriaID);
        recyclerCategoria.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<String> listaStrings = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.opciones_categoria)));

        AdapterCategoria adapterCategoria = new AdapterCategoria(listaStrings);
        recyclerCategoria.setAdapter(adapterCategoria);
    }
}