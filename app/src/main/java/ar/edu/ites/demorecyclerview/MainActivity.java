package ar.edu.ites.demorecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ar.edu.ites.demorecyclerview.models.Producto;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter adapter;
    private List<Producto> dataset = new ArrayList<Producto>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(layoutManager);

        this.cargarDatos();

        adapter = new Adapter(dataset);
        recyclerView.setAdapter(adapter);
    }

    private void cargarDatos() {
        dataset.add(new Producto(1, "Aceite Cocinero 900 cc", 152.0f, "Cocinero", "https://maxiconsumo.com/media/catalog/product/cache/8313a15b471f948db4d9d07d4a9f04a2/3/0/300.jpg"));
        dataset.add(new Producto(2, "Cafe La Morenita 200 gr", 320.0f, "La Moreinta", "https://www.delmayoristaacasa.com.ar/wp-content/uploads/2022/11/DSC_3042-1.jpg"));
        dataset.add(new Producto(3, "Gaseosa Fanta 1 lt", 260.0f, "Fanta", ""));
        dataset.add(new Producto(4, "Azucar Ledesma 500 gr", 135.0f, "Ledesma", ""));
    }
}