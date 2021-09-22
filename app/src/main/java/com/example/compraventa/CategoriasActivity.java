package com.example.compraventa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class CategoriasActivity extends AppCompatActivity {

    private ArrayList<CategoriaVo> categorias = new ArrayList<>();
    RecyclerView recyclerCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        recyclerCategoria = (RecyclerView) findViewById(R.id.recyclerCategoriaID);
        recyclerCategoria.setLayoutManager(new LinearLayoutManager(this));

        llenarCategorias();

        AdapterCategoria adapterCategoria = new AdapterCategoria(categorias);
        recyclerCategoria.setAdapter(adapterCategoria);
    }

    private void llenarCategorias() {

        categorias.add(new CategoriaVo("MLA5725","Accesorios para Vehículos",R.drawable.ic_baseline_build_24));
        categorias.add(new CategoriaVo("MLA1512","Agro"));
        categorias.add(new CategoriaVo("MLA1403","Alimentos y Bebidas"));
        categorias.add(new CategoriaVo("MLA1071","Animales y Mascotas"));
        categorias.add(new CategoriaVo("MLA1367","Antigüedades y Colecciones"));
        categorias.add(new CategoriaVo("MLA1368","Arte, Librería y Mercería",));
        categorias.add(new CategoriaVo("MLA1743","Autos, Motos y Otros",));
        categorias.add(new CategoriaVo("MLA1384","Bebés",));
        categorias.add(new CategoriaVo("MLA1246","Belleza y Cuidado Personal",));
        categorias.add(new CategoriaVo("MLA1039","Cámaras y Accesorios",));
        categorias.add(new CategoriaVo("MLA1051","Celulares y Teléfonos",));
        categorias.add(new CategoriaVo("MLA1648","Computación",));
        categorias.add(new CategoriaVo("MLA1144","Consolas y Videojuegos",));
        categorias.add(new CategoriaVo("MLA1500","Construcción",));
        categorias.add(new CategoriaVo("MLA1276","Deportes y Fitness",));
        categorias.add(new CategoriaVo("MLA5726","Electrodomésticos y Aires Ac.",));
        categorias.add(new CategoriaVo("MLA1000","Electrónica, Audio y Video",));
        categorias.add(new CategoriaVo("MLA2547","Entradas para Eventos",));
        categorias.add(new CategoriaVo("MLA407134","Herramientas",));
        categorias.add(new CategoriaVo("MLA1574","Hogar, Muebles y Jardín",));
        categorias.add(new CategoriaVo("MLA1499","Industrias y Oficinas",));
        categorias.add(new CategoriaVo("MLA1459","Inmuebles",));
        categorias.add(new CategoriaVo("MLA1182","Instrumentos Musicales",));
        categorias.add(new CategoriaVo("MLA3937","Joyas y Relojes",));
        categorias.add(new CategoriaVo("MLA1132","Juegos y Juguetes",));
        categorias.add(new CategoriaVo("MLA3025","Libros, Revistas y Comics",));
        categorias.add(new CategoriaVo("MLA1168","Música, Películas y Series",));
        categorias.add(new CategoriaVo("MLA1430","Ropa y Accesorios",));
        categorias.add(new CategoriaVo("MLA409431","Salud y Equipamiento Médico",));
        categorias.add(new CategoriaVo("MLA1540","Servicios",));
        categorias.add(new CategoriaVo("MLA9304","Souvenirs, Cotillón y Fiestas",));
        categorias.add(new CategoriaVo("MLA1953","Otras categorías",));
        
    }
}