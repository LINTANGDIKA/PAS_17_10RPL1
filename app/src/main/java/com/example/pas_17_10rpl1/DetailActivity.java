package com.example.pas_17_10rpl1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {
    Bundle bundle;
    @BindView(R.id.nama)
    TextView nama;
    @BindView(R.id.notelp)
    TextView notelp;
    @BindView(R.id.image)
    CircleImageView image;
    @BindView(R.id.identitas)
    TextView identitas;
    String nama1, notelp1, gambar, identitas1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        bundle = getIntent().getExtras();
        if(bundle != null) {
            ButterKnife.bind(this);
            nama1 = bundle.getString("nama");
            notelp1 = bundle.getString("notelp");
            gambar = bundle.getString("gambar");
            identitas1 = bundle.getString("identitas");
            nama.setText(nama1);
            notelp.setText(notelp1);
            identitas.setText(identitas1);
            Picasso.get()
                    .load(gambar)
                    .error(R.drawable.ic_baseline_person_24)
                    .into(image);
        }
    }
}