package k.example.bottomsheet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import k.example.bottomsheet.adapter.Rating_adapter;
import k.example.bottomsheet.model.Rating_item;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_port;
    Rating_adapter adapter;
    List<Rating_item> mdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_rate=findViewById(R.id.btn_rate);
        btn_rate.setOnClickListener(v -> {
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bottomSheet.show(getSupportFragmentManager(),
                    "ModalBottomSheet");
        });

        String dics=getIntent().getStringExtra("dics");
        String date=getIntent().getStringExtra("date");
        float rate=getIntent().getFloatExtra("rate",0);

        rv_port=findViewById(R.id.rcView);
        mdata=new ArrayList<>();

        if (dics!=null) {
            mdata.add(new Rating_item(rate, dics,date));
        }
        adapter=new Rating_adapter(mdata);
        rv_port.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        rv_port.setAdapter(adapter);

    }
}