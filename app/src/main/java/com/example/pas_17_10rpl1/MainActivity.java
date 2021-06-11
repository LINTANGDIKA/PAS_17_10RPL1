package com.example.pas_17_10rpl1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pas_17_10rpl1.Adapter.TeamAdapter;
import com.example.pas_17_10rpl1.Model.TeamModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private TeamAdapter teamAdapter;
    RecyclerView recyclerView;
    private ArrayList<TeamModel> userlist;
    @BindView(R.id.btn_add)
    ImageView btn_add;
    @BindView(R.id.before)
    TextView before;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("Contact Phone");
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            before.setVisibility(View.INVISIBLE);
            userlist = new ArrayList<>();
            userlist = (ArrayList<TeamModel>) bundle.getSerializable("arrayList");
            recyclerView = (RecyclerView) findViewById(R.id.rv_contact);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            teamAdapter = new TeamAdapter(this, userlist, new TeamAdapter.Callback() {
                @Override
                public void onClick(int position) {
                   Intent move = new Intent(getApplicationContext(),DetailActivity.class);
                   TeamModel teamModel = userlist.get(position);
                   move.putExtra("nama",teamModel.getNama());
                   move.putExtra("notelp",teamModel.getNotelp());
                   move.putExtra("identitas",teamModel.getIdentitas());
                   move.putExtra("gambar",teamModel.getGambar());
                   startActivity(move);
                }
            });

            recyclerView.setAdapter(teamAdapter);
        } else{

            before.setVisibility(View.VISIBLE);}

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent move = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(move);
            }
        });
    }
}