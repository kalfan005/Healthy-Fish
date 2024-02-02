package com.example.healthyfish.Screen7.Fragment2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.healthyfish.R;
import com.example.healthyfish.Screen7.GridAdapter1;
import com.example.healthyfish.Screen7.Griditem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Backwaterfish#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Backwaterfish extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Backwaterfish() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Backwaterfish.
     */
    // TODO: Rename and change types and number of parameters
    public static Backwaterfish newInstance(String param1, String param2) {
        Backwaterfish fragment = new Backwaterfish();
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
        View view = inflater.inflate(R.layout.fragment_backwaterfish, container, false);
        List<Griditem1>gridItems2= new ArrayList<>();
        gridItems2.add(new Griditem1(R.drawable.sardinefish,"Sardine/Chaala/Mathi(1kg to 1.9kg)","199.00/500g"));
        gridItems2.add(new Griditem1(R.drawable.solefish,"Solefish/Manthal(large)6+Count/kg","299.00/500g"));
        gridItems2.add(new Griditem1(R.drawable.emperorfish,"Emperorfish/Vilameen/Eri(large)(180g to 310g)","199.00/500g"));
        gridItems2.add(new Griditem1(R.drawable.sirloin,"Sirloin Fish/Varikashnam(100kg to 240kg)","179.00/500g"));

        // Initialize RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewfag3);

        // Set layout manager
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        // Set adapter
        GridAdapter1 gridAdapter = new GridAdapter1(requireContext(), gridItems2);
        recyclerView.setAdapter(gridAdapter);
        return view;
    }
}