package tech.ezapp.ezadmin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapterbatal extends RecyclerView.Adapter<taskHolder> {

    detail_taskDibatalkan detail_taskDibatalkan;
    ArrayList<Model> modelArrayList;

    public myAdapterbatal(tech.ezapp.ezadmin.detail_taskDibatalkan detail_taskDibatalkan, ArrayList<Model> modelArrayList) {
        this.detail_taskDibatalkan = detail_taskDibatalkan;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public taskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(detail_taskDibatalkan.getBaseContext());
        View view = layoutInflater.inflate(R.layout.row, parent, false);
        return new taskHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull taskHolder holder, int position) {

        holder.mTitleTask.setText(modelArrayList.get(position).getTitle());
        holder.mDeskripsi.setText(modelArrayList.get(position).getDescription());
        holder.mWaktu.setText(modelArrayList.get(position).getWaktu());

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }
}

