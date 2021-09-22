package com.example.compraventa;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
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
    private Spinner categoria;
    private Switch ofrecerDescuento;
    private SeekBar barritaDescuento;
    private CheckBox retiroEnPersona;
    private CheckBox aceptoTyC;
    private Button botonPublicar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvDireccionRetiro = (TextView) findViewById(R.id.direccionRetiroTV);
        etTitulo = (EditText) findViewById(R.id.tituloET);
        etDescripcion = (EditText) findViewById(R.id.descripcionET);
        etCorreo = (EditText) findViewById(R.id.correoET);
        etPrecio = (EditText) findViewById(R.id.precioET);
        etDireccion = (EditText) findViewById(R.id.direccionRetiroET);
        categoria = (Spinner) findViewById(R.id.categoriaSpinner);
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


        botonPublicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarDatos()){
                    Toast.makeText(getApplicationContext(), "¡Éxito!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Bundle categoriaRecibida = getIntent().getExtras();
        CategoriaVo categoriaSeleccionada = null;
        if(categoriaRecibida!=null){
            categoriaSeleccionada=(CategoriaVo) categoriaRecibida.getSerializable("categoria");
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