package k.example.bottomsheet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    RatingBar ratingBar;
    EditText text;

    Button post;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState){
        return  inflater.inflate(R.layout.bottom_sheet_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ratingBar=view.findViewById(R.id.ratingBar2);
        text=view.findViewById(R.id.txt_dics);

        post=view.findViewById(R.id.btn_post);
        post.setOnClickListener(v -> {


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
            String currentDateandTime = sdf.format(new Date());


            String dics=text.getText().toString();
            if (dics.isEmpty()){
                text.setError("This part can not be empty");
                text.requestFocus();
            }else {

                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra("rate", ratingBar.getRating());
                intent.putExtra("dics", dics);
                intent.putExtra("date", currentDateandTime);
                startActivity(intent);
            }

        });



    }
}
