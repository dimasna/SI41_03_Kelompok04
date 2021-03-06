package tech.ezapp.ezadmin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapterselesai extends RecyclerView.Adapter<taskHolder> {

    detail_taskSelesai detail_taskSelesai;
    ArrayList<Model1> model1ArrayList;

    public myAdapterselesai(tech.ezapp.ezadmin.detail_taskSelesai detail_taskSelesai, ArrayList<Model1> model1ArrayList) {
        this.detail_taskSelesai = detail_taskSelesai;
        this.model1ArrayList = model1ArrayList;
    }

    @NonNull
    @Override
    public taskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(detail_taskSelesai.getBaseContext());
        View view = layoutInflater.inflate(R.layout.row, parent, false);
        return new taskHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull taskHolder holder, int position) {

        holder.mTitleTask.setText(model1ArrayList.get(position).getTitle());
        holder.mDeskripsi.setText(model1ArrayList.get(position).getDescription());
        holder.mWaktu.setText(model1ArrayList.get(position).getWaktu());

    }

    @Override
    public int getItemCount() {
        return model1ArrayList.size();
    }
}

