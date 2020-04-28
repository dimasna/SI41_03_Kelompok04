package tech.ezapp.ezadmin;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import tech.ezapp.ezadmin.Model.Post;
import tech.ezapp.ezadmin.PostFragment.OnListFragmentInteractionListener;
import tech.ezapp.ezadmin.dummy.DummyContent.DummyItem;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyPostRecyclerViewAdapter extends FirestoreRecyclerAdapter<Post, MyPostRecyclerViewAdapter.PostViewHolder> {

    public MyPostRecyclerViewAdapter(@NonNull FirestoreRecyclerOptions<Post> options) {
        super(options);
    }

        @Override
        protected void onBindViewHolder(@NonNull final PostViewHolder holder, int position, @NonNull Post model) {
        final String judul = model.getJudul();
            final String deskripsi = model.getDeskripsi();
            long millis = model.getTimestamp().getSeconds() - System.currentTimeMillis();
            long hours =  millis/(1000*60*60);
            long min = (millis/(1000*60))%60;
            final String diff = hours+":"+min;
            final String poster = model.getPoster();
            final String requirement = model.getRequirement();
            final String status = model.getStatus();

            final String id = getSnapshots().getSnapshot(position).getId();




            holder.tvJudul.setText(judul);
            holder.tvDeskripsi.setText(deskripsi);
            holder.tvWaktu.setText(diff);
            holder.cardPost.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent postDetailIntent = new Intent(v.getContext(), PostDetail.class);
                    postDetailIntent.putExtra("judul", judul);
                    postDetailIntent.putExtra("deskripsi", deskripsi);
                    postDetailIntent.putExtra("waktu", diff);
                    postDetailIntent.putExtra("poster", poster);
                    postDetailIntent.putExtra("requirement", requirement);
                    postDetailIntent.putExtra("status", status);
                    postDetailIntent.putExtra("docId", id);


                    v.getContext().startActivity(postDetailIntent);
                }
            });


        }


        @NonNull
        @Override
        public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_post,parent,false);
            return new PostViewHolder(view);
        }
        class PostViewHolder extends RecyclerView.ViewHolder{
            TextView tvJudul;
            TextView tvDeskripsi;
            TextView tvWaktu;
            CardView cardPost;
            ProgressBar progressBar;

            public PostViewHolder(@NonNull View itemView) {
                super(itemView);
                tvJudul = itemView.findViewById(R.id.item_number);
                tvDeskripsi = itemView.findViewById(R.id.content);
                tvWaktu = itemView.findViewById(R.id.waktu);
                cardPost = itemView.findViewById(R.id.cardPost);
                progressBar = itemView.findViewById(R.id.progressBar);
            }
//            void setJudul(String judul){
//                TextView mIdView = mView.findViewById(R.id.item_number);
//                mIdView.setText(judul);
//            }
//            void setDeskripsi(String deskripsi){
//                TextView mContentView = mView.findViewById(R.id.content);
//                mContentView.setText(deskripsi);
//            }
//            void setWaktu(Timestamp timestamp){
//                TextView mWaktu = mView.findViewById(R.id.waktu);



//              long now = System.currentTimeInMillis();
//               CharSequence durasi = DateUtils.getRelativeTimeSpanString(timestamp,now,DateUtils.SECOND_IN_MILLIS,DateUtils.FORMAT_ABBREV_RELATIVE);
               //mWaktu.setText(timestamp.toDate().toString());
            }
        }


