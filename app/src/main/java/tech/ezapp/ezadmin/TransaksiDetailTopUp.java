package tech.ezapp.ezadmin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import tech.ezapp.ezadmin.dummy.DummyContent;

public class TransaksiDetailTopUp extends AppCompatActivity {
    private TopUpAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi_detail_top_up);

        recyclerView = findViewById(R.id.topUpLists);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new TopUpAdapter(DummyContent.ITEMS));
    }
}
