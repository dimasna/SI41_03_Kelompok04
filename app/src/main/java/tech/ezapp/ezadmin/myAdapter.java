package tech.ezapp.ezadmin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<taskHolder> {

    detail_taskBerjalan detail_taskBerjalan;
    ArrayList<Model> modelArrayList;

    public myAdapter(tech.ezapp.ezadmin.detail_taskBerjalan detail_taskBerjalan, ArrayList<Model> modelArrayList) {
        this.detail_taskBerjalan = detail_taskBerjalan;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public taskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(detail_taskBerjalan.getBaseContext());
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
