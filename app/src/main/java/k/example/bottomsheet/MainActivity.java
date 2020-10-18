package k.example.bottomsheet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;

import k.example.bottomsheet.adapter.Rating_adapter;
import k.example.bottomsheet.model.Rating_item;

public class MainActivity extends AppCompatActivity implements BottomSheetDialog.BottomSheetListener {

    RecyclerView rv_comment;
    Rating_adapter adapter;
    private List<Rating_item> mdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mdata = new ArrayList<>();
        rv_comment = findViewById(R.id.rcView);
        Button btn_rate = findViewById(R.id.btn_rate);


        BottomSheetDialog bottomSheet = new BottomSheetDialog();

        btn_rate.setOnClickListener(v -> {
            bottomSheet.show(getSupportFragmentManager(), "ModalBottomSheet");
        });

    }


    @Override
    public void onButtonClicked(String dics, String currentDateandTime, float rating) {
        Rating_item rating_item = new Rating_item();
        rating_item.setRating(rating);
        rating_item.setDes(dics);
        rating_item.setDate(currentDateandTime);
        mdata.add(rating_item);

        adapter = new Rating_adapter(mdata, this);
        rv_comment.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_comment.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


}