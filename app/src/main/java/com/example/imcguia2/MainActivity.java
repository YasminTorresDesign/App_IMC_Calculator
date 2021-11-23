package com.example.imcguia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtPeso, edtEstatura;
    private TextView txtImc, txtBajo, txtNormal, txtSobrepeso, txtObesidad1, txtObesidad2, txtObesidad3,
            txtCategoria, txtIdeal;
    private Button btnCalcular, btnBorrar;
    double peso, estatura, imc;
    private RadioButton btnMasculino, btnFemenino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPeso = (EditText) findViewById(R.id.edtPeso);
        edtEstatura = (EditText) findViewById(R.id.edtEstatura);
        txtImc = (TextView) findViewById(R.id.txtImc);
        txtBajo = (TextView) findViewById(R.id.txtBajo);
        txtNormal= (TextView) findViewById(R.id.txtNormal);
        txtSobrepeso = (TextView) findViewById(R.id.txtSobrepeso);
        txtObesidad1 = (TextView) findViewById(R.id.txtObesidad1);
        txtObesidad2 = (TextView) findViewById(R.id.txtObesidad2);
        txtObesidad3 = (TextView) findViewById(R.id.txtObesidad3);
        btnFemenino = (RadioButton) findViewById(R.id.btnFemenino);
        btnMasculino = (RadioButton) findViewById(R.id.btnMasculino);
        txtCategoria = (TextView) findViewById(R.id.txtCategoria);
        txtIdeal = (TextView) findViewById(R.id.txtIdeal);
        btnCalcular = (Button) findViewById(R.id.btncalcular);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);
        btnCalcular.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                peso = Double.parseDouble(edtPeso.getText().toString());
                estatura = Double.parseDouble(edtEstatura.getText().toString());
                imc = peso/(estatura*estatura);
                txtImc.setText("IMC:  "+redondear(imc));
                //borrar();
                //validacion para la categoria
                if(imc<18.5){
                    txtCategoria.setBackgroundColor(Color.parseColor("#728FCE"));
                    txtCategoria.setText("Bajo Peso");
                }if(imc>=18.5 && imc<25){
                    txtCategoria.setBackgroundColor(Color.parseColor("#4CC417"));
                    txtCategoria.setText("Peso Normal");
                }if(imc>=25 && imc<30){
                    txtCategoria.setBackgroundColor(Color.parseColor("#FFFF00"));
                    txtCategoria.setText("Sobrepeso");
                }if(imc>=30 && imc<35){
                    txtCategoria.setBackgroundColor(Color.parseColor("#E9AB17"));
                    txtCategoria.setText("Obesidad I");
                }if(imc>=35 && imc<40){
                    txtCategoria.setBackgroundColor(Color.parseColor("#FF4500"));
                    txtCategoria.setText("Obesidad II");
                }if(imc>=40) {
                    txtCategoria.setBackgroundColor(Color.parseColor("#FF0000"));
                    txtCategoria.setText("Obesidad III");
                }

                //validacion peso ideal femenino
                if (estatura>1.45 && btnFemenino.isChecked()){
                    txtIdeal.setText("45.0 Kg-52.0 Kg");
                }if (estatura>1.52 && btnFemenino.isChecked()){
                    txtIdeal.setText("46.0 Kg-54.0 Kg");
                }if (estatura>1.60 && btnFemenino.isChecked()){
                    txtIdeal.setText("50.0 Kg-60.0 Kg");
                }if (estatura>1.65 && btnFemenino.isChecked()){
                    txtIdeal.setText("53.0 Kg-63.0 Kg");
                }if (estatura>1.70 && btnFemenino.isChecked()){
                    txtIdeal.setText("58.0 Kg-67.0 Kg");
                }if (estatura>1.75 && btnFemenino.isChecked()){
                    txtIdeal.setText("61.0 Kg-72.0 Kg");
                }

                //validacion peso ideal masculino
                if (estatura>1.5 && btnMasculino.isChecked()){
                    txtIdeal.setText("45.0 Kg-56.0 Kg");
                }if (estatura>1.55 && btnMasculino.isChecked()){
                    txtIdeal.setText("53.0 Kg-59.0 Kg");
                }if (estatura>1.60 && btnMasculino.isChecked()){
                    txtIdeal.setText("51.0 Kg-64.0 Kg");
                }if (estatura>1.65 && btnMasculino.isChecked()){
                    txtIdeal.setText("54.0 Kg-68.0 Kg");
                }if (estatura>1.70 && btnMasculino.isChecked()){
                    txtIdeal.setText("58.0 Kg-72.0 Kg");
                }if (estatura>1.75 && btnMasculino.isChecked()){
                    txtIdeal.setText("61.0 Kg-76.0 Kg");
                }if (estatura>1.80 && btnMasculino.isChecked()){
                    txtIdeal.setText("65.0 Kg-81.0 Kg");
                }


            }
        });
        btnBorrar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                borrar();
            }
        });
    }

    public void borrar(){
        edtPeso.setText("");
        edtEstatura.setText("");
        txtImc.setText("IMC:   ");
        txtCategoria.setText("");
        txtCategoria.setBackgroundColor(Color.parseColor("#FFFFFF"));
        txtIdeal.setText("");
        txtIdeal.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }

    public double redondear(double n) {
        double res;
        int valor = 0;
        valor = (int) (n * 100);
        res = (double) valor / 100;
        return res;

    }
}