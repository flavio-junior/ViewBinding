package br.com.viewbinding;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import br.com.viewbinding.databinding.ActivityMainJavaBinding;

public class MainActivityJava extends AppCompatActivity {

    private ActivityMainJavaBinding binding;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainJavaBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();

        this.binding.btnContador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador++;
                binding.tvContador.setText("Contador: " + contador);
            }
        });

    }
}
