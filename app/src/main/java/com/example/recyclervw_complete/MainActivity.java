package com.example.recyclervw_complete;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Toy;
import com.example.model.Toys;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvToys;
    private Toys toys;
    private ToyAdapter   adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeviews();

        getAllToys();
        setRecyclerView();
    }

    private void setRecyclerView() {
        ToyAdapter.OnItemClickListener listener = new ToyAdapter.OnItemClickListener(){
            @Override
            public void onItemClicked(Toy toy){
                Toast.makeText(MainActivity.this, "Name : " + String.valueOf(toy.getName()), Toast.LENGTH_LONG).show();
            }
        };

        ToyAdapter.OnItemLongClickListener longlistener = new ToyAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClicked(Toy toy) {
                Toast.makeText(MainActivity.this, "Price : " + String.valueOf(toy.getPrice()), Toast.LENGTH_LONG).show();
                return true;
            }
        };

        adapter = new ToyAdapter(this, toys, R.layout.toy_single_layout, listener, longlistener);
        rvToys.setAdapter(adapter);
        rvToys.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getAllToys() {
        toys = new Toys();
        toys.add(new Toy("Car", 50));
        toys.add(new Toy("Doll", 100));
        toys.add(new Toy("Robot", 150));
        toys.add(new Toy("Monopol", 75));
        toys.add(new Toy("Taki", 80));
        toys.add(new Toy("Lego", 150));

    }

    private void initializeviews() {
        rvToys = findViewById(R.id.rvToys);
    }
}