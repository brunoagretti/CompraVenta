package com.example.compraventa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextView tvDireccionRetiro;
    private EditText etTitulo;
    private EditText etDescripcion;
    private EditText etCorreo;
    private EditText etPrecio;
    private EditText etDireccion;
    private Button botonCategoria;
    private Switch ofrecerDescuento;
    private SeekBar barritaDescuento;
    private CheckBox retiroEnPersona;
    private CheckBox aceptoTyC;
    private Button botonPublicar;


    @Override
    public void onSaveInstanceState(Bundle instaciaGuardada) {
        super.onSaveInstanceState(instaciaGuardada);

        instaciaGuardada.putString("titulo",etTitulo.getText().toString());
        instaciaGuardada.putString("correo",etCorreo.getText().toString());
        instaciaGuardada.putString("descripcion",etDescripcion.getText().toString());
        instaciaGuardada.putString("direccion",etDireccion.getText().toString());
        instaciaGuardada.putString("precio",etPrecio.getText().toString());
        instaciaGuardada.putBoolean("retiro", retiroEnPersona.isChecked());
        instaciaGuardada.putBoolean("condiciones", aceptoTyC.isChecked());
        instaciaGuardada.putBoolean("descuento", ofrecerDescuento.isChecked());
        instaciaGuardada.putInt("progresoBarra", barritaDescuento.getProgress());


    }

    @Override
    public void onRestoreInstanceState(Bundle instaciaGuardada) {
        super.onRestoreInstanceState(instaciaGuardada);

        etTitulo.setText(instaciaGuardada.getString("titulo"));
        etCorreo.setText(instaciaGuardada.getString("correo"));
        etDescripcion.setText(instaciaGuardada.getString("descripcion"));
        etDireccion.setText(instaciaGuardada.getString("direccion"));
        etPrecio.setText(instaciaGuardada.getString("precio"));
        retiroEnPersona.setChecked(instaciaGuardada.getBoolean("retiro"));
        aceptoTyC.setChecked(instaciaGuardada.getBoolean("condiciones"));
        ofrecerDescuento.setChecked(instaciaGuardada.getBoolean("descuento"));
        barritaDescuento.setProgress(instaciaGuardada.getInt("progresoBarra"));

    }


    @Override
    protected void onCreate(Bundle instaciaGuardada) {
        super.onCreate(instaciaGuardada);
        setContentView(R.layout.activity_main);


        tvDireccionRetiro = (TextView) findViewById(R.id.direccionRetiroTV);
        etTitulo = (EditText) findViewById(R.id.tituloET);
        etDescripcion = (EditText) findViewById(R.id.descripcionET);
        etCorreo = (EditText) findViewById(R.id.correoET);
        etPrecio = (EditText) findViewById(R.id.precioET);
        etDireccion = (EditText) findViewById(R.id.direccionRetiroET);
        botonCategoria = (Button) findViewById(R.id.botonCategoriaID);
        ofrecerDescuento = (Switch) findViewById(R.id.descuentoSwitch);
        barritaDescuento = (SeekBar) findViewById(R.id.descuentoSB);
        retiroEnPersona = (CheckBox) findViewById(R.id.retiroCB);
        aceptoTyC = (CheckBox) findViewById(R.id.tycCB);
        botonPublicar = (Button) findViewById(R.id.publicarButton);

        ofrecerDescuento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int visibilidadBarrita = barritaDescuento.getVisibility();

                if(visibilidadBarrita == View.VISIBLE){
                    barritaDescuento.setVisibility(View.GONE);
                    barritaDescuento.setProgress(0);
                }else{
                    barritaDescuento.setVisibility(View.VISIBLE);
                }
            }
        });

        barritaDescuento.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(i == 0){
                    ofrecerDescuento.setText(getString(R.string.descuento));
                }else{
                    ofrecerDescuento.setText(getString(R.string.descuento) + " - " + i + "%");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        retiroEnPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { ;

                if(retiroEnPersona.isChecked()){
                    tvDireccionRetiro.setVisibility(View.VISIBLE);
                    etDireccion.setVisibility(View.VISIBLE);
                }else{
                    tvDireccionRetiro.setVisibility(View.GONE);
                    etDireccion.setVisibility(View.GONE);
                    etDireccion.setText("");
                    MainActivity.hideKeyboardFrom(getApplicationContext(),view);
                }

            }
        });

        aceptoTyC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(aceptoTyC.isChecked()){
                    botonPublicar.setClickable(true);
                    botonPublicar.setAlpha(1f);

                }else{
                    botonPublicar.setClickable(false);
                    botonPublicar.setAlpha(0.5f);
                }
            }
        });

        botonCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CategoriasActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                getApplicationContext().startActivity(intent);
            }
        });


        botonPublicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarDatos()){
                    Toast.makeText(getApplicationContext(), "¡Éxito!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Hacemos el botón publicar no-clickeable por defecto
        botonPublicar.setClickable(false);
        botonPublicar.setAlpha(0.5f);

        Bundle categoriaRecibida = getIntent().getExtras();
        CategoriaVo categoriaSeleccionada = null;
        if(categoriaRecibida!=null){
            categoriaSeleccionada=(CategoriaVo) categoriaRecibida.getSerializable("categoria");
            botonCategoria.setText(categoriaSeleccionada.getNombre());
        }



    }

    //Cerrar teclado en caso de estar abierto
    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    public boolean validarDatos(){

        Pattern VALID_EMAIL_ADDRESSREGEX = Pattern.compile("^[A-Z0-9.%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        boolean camposPrincipalesCompletos = !etTitulo.getText().toString().equals("") && !etCorreo.getText().toString().equals("") && !etPrecio.getText().toString().equals("");

        if(retiroEnPersona.isChecked()){
            camposPrincipalesCompletos = camposPrincipalesCompletos && !etDireccion.getText().toString().equals("");
        }

        if(!camposPrincipalesCompletos){
            Toast.makeText(getApplicationContext(), "Campos obligatorios incompletos", Toast.LENGTH_SHORT).show();
            return false;
        }

        //Descuento activado pero no hacemos descuento
        if(ofrecerDescuento.isChecked() && barritaDescuento.getProgress() == 0){
            Toast.makeText(getApplicationContext(), "Por favor seleccione un porcentaje mayor a 0 o quite la opcion de ofrecer descuento de envio.", Toast.LENGTH_LONG).show();
            return false;
        }

        //     Esto no es necesario debido a que el inputType no permite ingresar ningun caracter extraño ni numeros negativos
//        try {
//        Float precio = Float.valueOf(etPrecio.getText().toString());
//            Toast.makeText(getApplicationContext(), "El precio es: " + precio, Toast.LENGTH_SHORT).show();
//
//        }catch (Exception e){
//            Toast.makeText(getApplicationContext(), "Por favor ingrese un número válido.", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//
//        if (precio < 0){
//            Toast.makeText(getApplicationContext(), "El precio debe ser mayor que 0.", Toast.LENGTH_LONG).show();
//            return false;
//        }

        if(!VALID_EMAIL_ADDRESSREGEX.matcher(etCorreo.getText().toString()).find()){
            Toast.makeText(getApplicationContext(), "Ingrese un email válido.", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }
}