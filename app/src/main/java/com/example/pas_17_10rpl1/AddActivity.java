package com.example.pas_17_10rpl1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pas_17_10rpl1.Adapter.TeamAdapter;
import com.example.pas_17_10rpl1.Model.TeamModel;
import com.google.android.material.textfield.TextInputEditText;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddActivity extends AppCompatActivity {
    @BindView(R.id.rv_add)
    Button rv_add;
    @BindView(R.id.tv_name)
    TextInputEditText tv_name;
    @BindView(R.id.tv_number)
    TextInputEditText tv_number;
    @BindView(R.id.tv_identitas)
    TextInputEditText tv_identitas;
    Bundle bundle;
    private TeamAdapter teamAdapter;
    private ArrayList<TeamModel> userlist;
    private String name, number, identitas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);
        rv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               name = tv_name.getText().toString();
               number = tv_number.getText().toString();
               identitas = tv_identitas.getText().toString();

                if(name.trim().isEmpty() || number.trim().isEmpty() || identitas.trim().isEmpty()) {
                   Toast.makeText(getApplicationContext(),"Jangan Ada Spasi!", Toast.LENGTH_SHORT).show();
               }
               else{
                   TeamModel teamModel = new TeamModel(name,number,identitas,"https://www.seekpng.com/png/detail/143-1435868_headshot-silhouette-person-placeholder.png");

                    userlist = new ArrayList<>();
                    userlist.add(new TeamModel(name, number, identitas, "https://www.seekpng.com/png/detail/143-1435868_headshot-silhouette-person-placeholder.png"));
                   tv_name.setText("");
                   tv_number.setText("");
                   tv_identitas.setText("");
                   Toast.makeText(getApplicationContext(),"Data Sudah Di Tambahkan!", Toast.LENGTH_SHORT).show();
                   Intent move = new Intent(getApplicationContext(), MainActivity.class);
                   move.putExtra("arrayList", userlist);
                   startActivity(move);
               }
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent move = new Intent(getApplicationContext(), MainActivity.class);
        move.putExtra("arrayList", userlist);
        startActivity(move);
    }
}