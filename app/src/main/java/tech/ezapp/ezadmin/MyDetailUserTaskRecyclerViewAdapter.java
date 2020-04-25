package tech.ezapp.ezadmin;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import tech.ezapp.ezadmin.DetailUserTaskFragment.OnListFragmentInteractionListener;
import tech.ezapp.ezadmin.Model.Post;
import tech.ezapp.ezadmin.Model.saldoPost;
import tech.ezapp.ezadmin.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyDetailUserTaskRecyclerViewAdapter extends FirestoreRecyclerAdapter<saldoPost, MyDetailUserTaskRecyclerViewAdapter.saldoPostHolder> {

    public MyDetailUserTaskRecyclerViewAdapter(@NonNull FirestoreRecyclerOptions<saldoPost> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final saldoPostHolder holder, int position, @NonNull saldoPost model) {


       // final String id = getSnapshots().getSnapshot(position).getId();

        holder.tvPosting_desc.setText(model.getPosting_title());
        holder.tvPosting_user.setText(model.getPosting_user());
        holder.tvPosting_coins.setText("" + model.getPosting_coins() + "");
        holder.tvPosting_date.setText(model.getPosting_date().toDate().toString());

    }

    @NonNull
    @Override
    public MyDetailUserTaskRecyclerViewAdapter.saldoPostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_detailusertask,parent,false);
        return new MyDetailUserTaskRecyclerViewAdapter.saldoPostHolder(view);
    }
    class saldoPostHolder extends RecyclerView.ViewHolder {
        TextView tvPosting_desc;
        TextView tvPosting_user;
        TextView tvPosting_coins;
        TextView tvPosting_date;

        public saldoPostHolder(@NonNull View itemView) {
            super(itemView);
            tvPosting_desc = itemView.findViewById(R.id.posting_desc);
            tvPosting_user = itemView.findViewById(R.id.posting_user);
            tvPosting_coins = itemView.findViewById(R.id.posting_coins);
            tvPosting_date = itemView.findViewById(R.id.posting_date);
        }
    }
}
