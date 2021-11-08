package com.example.compraventa;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;

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
        AdapterCategoria adapterCategoria = new AdapterCategoria(this,categorias);//TODO aca esta mal el contexto?
        recyclerCategoria.setAdapter(adapterCategoria);



    }

    private void llenarCategorias() {

        categorias.add(new CategoriaVo("MLA5725","Accesorios para Vehículos",R.drawable.ic_baseline_car_repair_24));
        categorias.add(new CategoriaVo("MLA1512","Agro",R.drawable.ic_baseline_agriculture_24));
        categorias.add(new CategoriaVo("MLA1403","Alimentos y Bebidas",R.drawable.ic_baseline_fastfood_24));
        categorias.add(new CategoriaVo("MLA1071","Animales y Mascotas",R.drawable.ic_baseline_pets_24));
        categorias.add(new CategoriaVo("MLA1367","Antigüedades y Colecciones",R.drawable.ic_baseline_diamond_24));
        categorias.add(new CategoriaVo("MLA1368","Arte, Librería y Mercería",R.drawable.ic_baseline_menu_book_24));
        categorias.add(new CategoriaVo("MLA1743","Autos, Motos y Otros",R.drawable.ic_baseline_directions_car_24));
        categorias.add(new CategoriaVo("MLA1384","Bebés",R.drawable.ic_baseline_baby_changing_station_24));
        categorias.add(new CategoriaVo("MLA1246","Belleza y Cuidado Personal",R.drawable.ic_baseline_soap_24));
        categorias.add(new CategoriaVo("MLA1039","Cámaras y Accesorios",R.drawable.ic_baseline_camera_24));
        categorias.add(new CategoriaVo("MLA1051","Celulares y Teléfonos",R.drawable.ic_baseline_phone_iphone_24));
        categorias.add(new CategoriaVo("MLA1648","Computación",R.drawable.ic_baseline_laptop_mac_24));
        categorias.add(new CategoriaVo("MLA1144","Consolas y Videojuegos",R.drawable.ic_baseline_videogame_asset_24));
        categorias.add(new CategoriaVo("MLA1500","Construcción",R.drawable.ic_baseline_construction_24));
        categorias.add(new CategoriaVo("MLA1276","Deportes y Fitness",R.drawable.ic_baseline_sports_basketball_24));
        categorias.add(new CategoriaVo("MLA5726","Electrodomésticos y Aires Ac.",R.drawable.ic_baseline_microwave_24));
        categorias.add(new CategoriaVo("MLA1000","Electrónica, Audio y Video",R.drawable.ic_baseline_cable_24));
        categorias.add(new CategoriaVo("MLA2547","Entradas para Eventos",R.drawable.ic_baseline_local_activity_24));
        categorias.add(new CategoriaVo("MLA407134","Herramientas",R.drawable.ic_baseline_construction_24));
        categorias.add(new CategoriaVo("MLA1574","Hogar, Muebles y Jardín",R.drawable.ic_baseline_event_seat_24));
        categorias.add(new CategoriaVo("MLA1499","Industrias y Oficinas",R.drawable.ic_baseline_business_24));
        categorias.add(new CategoriaVo("MLA1459","Inmuebles",R.drawable.ic_baseline_roofing_24));
        categorias.add(new CategoriaVo("MLA1182","Instrumentos Musicales",R.drawable.ic_baseline_music_note_24));
        categorias.add(new CategoriaVo("MLA3937","Joyas y Relojes",R.drawable.ic_baseline_watch_24));
        categorias.add(new CategoriaVo("MLA1132","Juegos y Juguetes",R.drawable.ic_baseline_smart_toy_24));
        categorias.add(new CategoriaVo("MLA3025","Libros, Revistas y Comics",R.drawable.ic_baseline_book_24));
        categorias.add(new CategoriaVo("MLA1168","Música, Películas y Series",R.drawable.ic_baseline_movie_filter_24));
        categorias.add(new CategoriaVo("MLA1430","Ropa y Accesorios",R.drawable.ic_baseline_shopping_bag_24));
        categorias.add(new CategoriaVo("MLA409431","Salud y Equipamiento Médico",R.drawable.ic_baseline_health_and_safety_24));
        categorias.add(new CategoriaVo("MLA1540","Servicios",R.drawable.ic_baseline_build_24));
        categorias.add(new CategoriaVo("MLA9304","Souvenirs, Cotillón y Fiestas",R.drawable.ic_baseline_celebration_24));
        categorias.add(new CategoriaVo("MLA1953","Otras categorías",R.drawable.ic_baseline_add_box_24));

    }
}