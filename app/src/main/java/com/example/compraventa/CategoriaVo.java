package com.example.compraventa;

import java.io.Serializable;

public class CategoriaVo implements Serializable {
    private String id;
    private String nombre;
    private int imagen;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    //Constructor sin imagen
    public CategoriaVo(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        //Imagen por defecto
        this.imagen = R.mipmap.ic_launcher_round;
    }

    public CategoriaVo(String id, String nombre, int imagen) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
    }
}
