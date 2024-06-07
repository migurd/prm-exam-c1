package com.example.prm_examen_c1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText inUser;
    private EditText inPass;
    private Button btnIngresar;
    private Button btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        init();

        String user = getString(R.string.name);
        String pass = getString(R.string.pass);

        try {
            if (inUser.getText().toString().equals(user) || inPass.getText().toString().equals(pass))
                throw new IllegalArgumentException("Usuario o contraseña incorrectos.");
            else {
                Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
                startActivity(intent);
            }
        } catch(IllegalArgumentException error) {
            Toast.makeText(MainActivity.this, error.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void init() {
        inUser = (EditText) findViewById(R.id.inUsuario);
        inPass = (EditText) findViewById(R.id.inPassword);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnSalir = (Button) findViewById(R.id.btnSalir);
    }
}