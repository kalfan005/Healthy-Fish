package com.example.healthyfish.Screen6.Fragment1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.codebyashish.autoimageslider.AutoImageSlider;
import com.codebyashish.autoimageslider.Enums.ImageActionTypes;
import com.codebyashish.autoimageslider.Enums.ImageScaleType;
import com.codebyashish.autoimageslider.ExceptionsClass;
import com.codebyashish.autoimageslider.Interfaces.ItemsListener;
import com.codebyashish.autoimageslider.Models.ImageSlidesModel;
import com.example.healthyfish.R;
import com.example.healthyfish.Screen6.Gridview.GridAdapter;
import com.example.healthyfish.Screen6.Gridview.GridItem;
import com.example.healthyfish.Screen7.Freshfish;
import com.example.healthyfish.Screen7.GridAdapter1;
import com.example.healthyfish.Screen7.Griditem1;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements ItemsListener{

    private ItemsListener listener;

    TextView viewall,viewall2;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        listener = (ItemsListener) this;


        ArrayList<ImageSlidesModel> autoImageList = new ArrayList<>();
        AutoImageSlider autoImageSlider = view.findViewById(R.id.autoImageSlider);

        try {
            autoImageList.add(new ImageSlidesModel(R.drawable.homefish));
        } catch (ExceptionsClass e) {
            throw new RuntimeException(e);
        }
        try {
            autoImageList.add(new ImageSlidesModel(R.drawable.homefish2));
        } catch (ExceptionsClass e) {
            throw new RuntimeException(e);
        }
        try {
            autoImageList.add(new ImageSlidesModel(R.drawable.homefish3));
        } catch (ExceptionsClass e) {
            throw new RuntimeException(e);
        }


        autoImageSlider.setImageList(autoImageList, ImageScaleType.FIT);


        autoImageSlider.setDefaultAnimation();


        autoImageSlider.onItemClickListener(listener);


        List<GridItem> gridItems = new ArrayList<>();
        gridItems.add(new GridItem(R.drawable.hake, "Fresh Fish"));
        gridItems.add(new GridItem(R.drawable.fishh2, "Seer Fish"));
        gridItems.add(new GridItem(R.drawable.icon_shell_fish, "Crab"));
        gridItems.add(new GridItem(R.drawable.fishh1, "pomfret"));

        // Initialize GridView
        GridView gridView = view.findViewById(R.id.gridView);

        // Set adapter
        GridAdapter gridAdapter = new GridAdapter(requireContext(),gridItems);
        gridView.setAdapter(gridAdapter);


        List<Griditem1>gridItems2= new ArrayList<>();
        gridItems2.add(new Griditem1(R.drawable.catlagoogle,"Catla(1kg to 1.9kg)","199.00/500g"));
        gridItems2.add(new Griditem1(R.drawable.mackerelgoole,"Indian Mackerel/Ayala/Bangada/Ayila(large)6+Count/kg","299.00/500g"));
        gridItems2.add(new Griditem1(R.drawable.vermilion,"Pink Perch/Kilimeen/Sankara Meen/Thread Finned Bream(large)(180g to 310g)","199.00/500g"));
        gridItems2.add(new Griditem1(R.drawable.jalebigoogle,"Tilapia/Jilebi Fish(100kg to 240kg)","179.00/500g"));

        // Initialize RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewfagg);

        // Set layout manager
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        // Set adapter
        GridAdapter1 gridAdapter1 = new GridAdapter1(requireContext(), gridItems2);
        recyclerView.setAdapter(gridAdapter1);



        viewall = view.findViewById(R.id.viewall);

        viewall2 = view.findViewById(R.id.viewall2);
        viewall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), Freshfish.class);
                startActivity(intent);

            }
        });

        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = CategoryFragment.newInstance(null,null);
                loadfragment(fragment);
            }


            private void loadfragment(Fragment fragment) {
                FragmentManager manager= getActivity().getSupportFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.frame,fragment);
                transaction.commit();
            }
        });


        return view;

    }

    @Override
    public void onItemChanged(int position) {

    }

    @Override
    public void onTouched(ImageActionTypes actionTypes, int position) {

    }

    @Override
    public void onItemClicked(int position) {

    }


}