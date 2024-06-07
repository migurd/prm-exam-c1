package com.example.prm_examen_c1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class CalculadoraActivity extends AppCompatActivity {
    private EditText inNum1, inNum2;
    private TextView outResultado;
    private Button btnSum, btnMinus, btnMult, btnDiv, btnClean, btnBack;
    private Calculadora calc = new Calculadora();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora);

        init();

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    calc.setNum1(Float.parseFloat(inNum1.getText().toString()));
                    calc.setNum2(Float.parseFloat(inNum2.getText().toString()));
                    if (inNum1.getText().toString().isEmpty() || inNum1.getText().toString().isEmpty())
                        throw new IllegalArgumentException("Inserte valores, por favor.");
                    outResultado.setText(floatToString(calc.suma()));
                } catch (IllegalArgumentException error) {
                    Toast.makeText(CalculadoraActivity.this, "Inserte valores, por favor",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    calc.setNum1(Float.parseFloat(inNum1.getText().toString()));
                    calc.setNum2(Float.parseFloat(inNum2.getText().toString()));
                    if (inNum1.getText().toString().isEmpty() || inNum1.getText().toString().isEmpty())
                        throw new IllegalArgumentException("Inserte valores, por favor.");
                    outResultado.setText(floatToString(calc.resta()));
                } catch (IllegalArgumentException error) {
                    Toast.makeText(CalculadoraActivity.this, "Inserte valores, por favor.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    calc.setNum1(Float.parseFloat(inNum1.getText().toString()));
                    calc.setNum2(Float.parseFloat(inNum2.getText().toString()));
                    if (inNum1.getText().toString().isEmpty() || inNum1.getText().toString().isEmpty())
                        throw new IllegalArgumentException("Inserte valores, por favor.");
                    outResultado.setText(floatToString(calc.multiplicacion()));
                } catch (IllegalArgumentException error) {
                    Toast.makeText(CalculadoraActivity.this, "Inserte valores, por favor.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    calc.setNum1(Float.parseFloat(inNum1.getText().toString()));
                    calc.setNum2(Float.parseFloat(inNum2.getText().toString()));
                    if (inNum1.getText().toString().isEmpty() || inNum1.getText().toString().isEmpty())
                        throw new IllegalArgumentException("Inserte valores, por favor.");
                    if (calc.getNum2() == 0)
                        outResultado.setText("Inválido");
                    else
                        outResultado.setText(floatToString(calc.division()));
                } catch (IllegalArgumentException error) {
                    Toast.makeText(CalculadoraActivity.this, "Inserte valores, por favor.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inNum1.setText("");
                inNum2.setText("");
                outResultado.setText("");
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void init() {
        inNum1 = (EditText)findViewById(R.id.inNum1);
        inNum2 = (EditText)findViewById(R.id.inNum2);
        outResultado = (TextView) findViewById(R.id.outResultado);
        btnSum = (Button)findViewById(R.id.btnSum);
        btnMinus = (Button)findViewById(R.id.btnMinus);
        btnMult = (Button)findViewById(R.id.btnMult);
        btnDiv = (Button)findViewById(R.id.btnDiv);
        btnClean = (Button)findViewById(R.id.btnLimpiar);
        btnBack = (Button)findViewById(R.id.btnRegresar);


    }

    public String floatToString(float num) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(num);
    }
}