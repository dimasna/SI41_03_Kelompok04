package tech.ezapp.ezadmin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AkunFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AkunFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AkunFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextView nama;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button btnKeluar;

    private OnFragmentInteractionListener mListener;

    public AkunFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AkunFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AkunFragment newInstance(String param1, String param2) {
        AkunFragment fragment = new AkunFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        HomeActivity activity = (HomeActivity) getActivity();
        SharedPreferences pref = this.getActivity().getSharedPreferences("akun", Context.MODE_PRIVATE);


        View view = inflater.inflate(R.layout.fragment_akun, container, false);
        nama = view.findViewById(R.id.nama);
        nama.setText(pref.getString("email", ""));


        btnKeluar = view.findViewById(R.id.btn_keluar);
        btnKeluar.setOnClickListener(this);

        CardView cardViewbahasa = view.findViewById(R.id.crdBahasaa);
        cardViewbahasa.setOnClickListener(this);

        CardView cardViewsandi = view.findViewById(R.id.crdSandi);
        cardViewsandi.setOnClickListener(this);

        TextView ubahNama = view.findViewById(R.id.ubahnaama);
        ubahNama.setOnClickListener(this);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_keluar:
                FirebaseAuth.getInstance().signOut();
                SharedPreferences sharedPreferences
                        = this.getActivity().getSharedPreferences("akun",
                        Context.MODE_PRIVATE);
                SharedPreferences.Editor myEdit
                        = sharedPreferences.edit();
                myEdit.putBoolean("is_logged_before",false);
                myEdit.commit();
                Intent pindah = new Intent(getActivity(), LoginActivity.class);
                startActivity(pindah);
                break;
            case R.id.crdBahasaa:
                Intent bahasa = new Intent(getActivity(), UbahBahasa.class);
                startActivity(bahasa);
                break;
            case R.id.crdSandi:
                Intent sandi = new Intent(getActivity(), UbahSandi.class);
                startActivity(sandi);
                break;
            case R.id.ubahnaama:
                Intent name = new Intent(getActivity(), NamaUbah.class);
                startActivity(name);
                break;
            default:
                break;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
