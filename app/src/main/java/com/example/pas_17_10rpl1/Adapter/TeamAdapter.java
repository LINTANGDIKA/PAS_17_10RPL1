package com.example.pas_17_10rpl1.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_17_10rpl1.MainActivity;
import com.example.pas_17_10rpl1.Model.TeamModel;
import com.example.pas_17_10rpl1.R;
import com.squareup.picasso.Picasso;

import java.net.CookieHandler;
import java.util.ArrayList;
import javax.security.auth.callback.Callback;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.UserViewHolder>{

    private Context context;
    private Callback callback;
    int posku;
    View viewku;
    private ArrayList<TeamModel> userlist;

    public interface Callback {
        void onClick(int position);
    }

    public TeamAdapter(MainActivity mainActivity, ArrayList<TeamModel> userlist, Callback callback) {
        this.userlist = userlist;
        this.callback = callback;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rv_list, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.nama.setText(userlist.get(position).getNama());
        holder.noTelp.setText(userlist.get(position).getNotelp());
        holder.status.setText(userlist.get(position).getIdentitas());
        Picasso.get()
                .load(userlist.get(position).getGambar())
                .error(R.mipmap.ic_launcher_round)
                .into(holder.image)

        ;
    }

    @Override
    public int getItemCount() {
        return (userlist != null) ? userlist.size() : 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        ImageView image;
        TextView nama, noTelp, status;
        CardView contact;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            viewku = itemView;
            itemView.setOnCreateContextMenuListener(this);
            this.image = itemView.findViewById(R.id.image);
            this.nama = itemView.findViewById(R.id.nama);
            this.noTelp = itemView.findViewById(R.id.notelp);
            this.contact = itemView.findViewById(R.id.contact);
            this.status = itemView.findViewById(R.id.status);
            contact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onClick(getAdapterPosition());
                }
            });
        }

        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

            MenuItem Edit = menu.add(Menu.NONE, 1, 1, "Edit");
            MenuItem Delete = menu.add(Menu.NONE, 2, 2, "Delete");

            Edit.setOnMenuItemClickListener(onlickcontextmenu);
            Delete.setOnMenuItemClickListener(onlickcontextmenu);
        }
    }


    private final MenuItem.OnMenuItemClickListener onlickcontextmenu = new MenuItem.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch (item.getItemId()) {
                case 1:
                    //Do stuff
                    Toast.makeText(viewku.getContext(), "Edit data di posisi "+posku, Toast.LENGTH_SHORT).show();
                    break;

                case 2:
                    //Delete data, butuh konfirmasi dialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(viewku.getContext());
                    builder.setMessage("Are you sure you want to delete data?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    userlist.remove(posku);
                                    notifyDataSetChanged();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                            //Set your icon here
                            .setTitle("Delete data")
                            .setIcon(R.mipmap.ic_launcher);
                    AlertDialog alert = builder.create();
                    alert.show();//showing the dialog

                    break;
            }
            return true;
        }
    };
}
