package tech.ezapp.ezadmin;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class taskHolder extends RecyclerView.ViewHolder {

    public TextView mTitleTask, mDeskripsi, mWaktu;


    public taskHolder(@NonNull View itemView) {
        super(itemView);

        mTitleTask = itemView.findViewById(R.id.titleTask);
        mDeskripsi = itemView.findViewById(R.id.deskripsi);
        mWaktu = itemView.findViewById(R.id.waktuTask);
    }
}
