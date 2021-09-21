package com.example.compraventa;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

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
                    MainActivity.hideKeyboardFrom(getBaseContext(),view);
                }

            }
        });

    }

    //Cerrar teclado en caso de estar abierto
    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}