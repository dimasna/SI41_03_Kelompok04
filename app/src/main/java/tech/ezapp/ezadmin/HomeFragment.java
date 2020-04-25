package tech.ezapp.ezadmin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextView nama;

    //View myFragment;
    //ViewPager viewPager;
  //  TabLayout tabLayout;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        loadFragment(new PostFragment());
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.post_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        HomeActivity activity = (HomeActivity) getActivity();

        String email = activity.getEmail();

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        nama = view.findViewById(R.id.nama);
        nama.setText(email);


      //  viewPager = myFragment.findViewById(R.id.viewPager);
     //   tabLayout = myFragment.findViewById(R.id.tabLayout);

return view;
      //  return myFragment;
    }

   // @Override
   // public void onActivityCreated(@Nullable Bundle savedInstanceState) {
     //   super.onActivityCreated(savedInstanceState);

      //  setUpViewPager(viewPager);
      //  tabLayout.setupWithViewPager(viewPager);

      //  tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
       //     @Override
        //    public void onTabSelected(TabLayout.Tab tab) {

       //     }

     //       @Override
       //     public void onTabUnselected(TabLayout.Tab tab) {

       //     }

        //    @Override
        //    public void onTabReselected(TabLayout.Tab tab) {

        //    }
      //  });
    //}

    //private void setUpViewPager(ViewPager viewPager) {
        //ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());

      //  adapter.addFragment
    //}

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
