package com.example.compraventa;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterCategoria extends RecyclerView.Adapter<AdapterCategoria.ViewHolderCategoria>{

    private ArrayList<String> categorias;

    public AdapterCategoria(ArrayList<String> categorias) {
        this.categorias = categorias;
    }

    @Override
    public ViewHolderCategoria onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.categoria_item,null,false);
        return new ViewHolderCategoria(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderCategoria viewHolderCategoria, int i) {
        viewHolderCategoria.asignarDatos(categorias.get(i));
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    public class ViewHolderCategoria extends RecyclerView.ViewHolder {

        TextView texto_test;
        Button boton_test;

        public ViewHolderCategoria(View itemView) {
            super(itemView);
            texto_test = itemView.findViewById(R.id.itemTV);
            boton_test = itemView.findViewById(R.id.botonB);

        }

        public void asignarDatos(String s) {
            texto_test.setText(s);
            boton_test.setText(s+" apretame");
        }
    }
}
