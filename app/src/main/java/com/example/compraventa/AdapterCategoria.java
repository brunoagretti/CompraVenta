package com.example.compraventa;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterCategoria extends RecyclerView.Adapter<AdapterCategoria.ViewHolderCategoria>{

    private ArrayList<CategoriaVo> categorias;
    private Context contexto;
    public AdapterCategoria(Context contexto, ArrayList<CategoriaVo> categorias) {
        this.categorias = categorias;
        this.contexto = contexto;
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
        LinearLayout layoutHorizontal;

        public ViewHolderCategoria(View itemView) {
            super(itemView);

            layoutHorizontal = itemView.findViewById(R.id.layoutHorizontalID);
            textoCategoria = itemView.findViewById(R.id.textoCategoriaID);
            imagenCategoria = itemView.findViewById(R.id.imagenCategoriaID);


        }

        public void asignarDatos(CategoriaVo c) {
            textoCategoria.setText(c.getNombre());
            imagenCategoria.setImageResource(c.getImagen());

            layoutHorizontal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("PRESIONAR","Presionó "+c.getNombre()); //TODO remover esto
                    Intent intent = new Intent(contexto, MainActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("categoria",c);

                    intent.putExtras(bundle);
                    contexto.startActivity(intent);
                }


            });



        }
    }
}
