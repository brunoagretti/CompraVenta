package com.example.compraventa;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterCategoria extends RecyclerView.Adapter<AdapterCategoria.ViewHolderCategoria>{

    private ArrayList<CategoriaVo> categorias;

    public AdapterCategoria(ArrayList<CategoriaVo> categorias) {
        this.categorias = categorias;
    }

    @Override
    public ViewHolderCategoria onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fila_cat,null,false);
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

        TextView textoCategoria;
        ImageView imagenCategoria;

        public ViewHolderCategoria(View itemView) {
            super(itemView);
            textoCategoria = itemView.findViewById(R.id.textoCategoriaID);
            imagenCategoria = itemView.findViewById(R.id.imagenCategoriaID);
        }

        public void asignarDatos(CategoriaVo c) {
            textoCategoria.setText(c.getNombre());
            imagenCategoria.setImageResource(c.getImagen());
        }
    }
}
