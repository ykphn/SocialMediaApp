package com.example.SocialMediaApp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.SocialMediaApp.databinding.FragmentHomeBinding;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private ArrayList<PhotoPost> photoPostArrayList;
    private Adaptor myAdaptor;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        photoPostArrayList = new ArrayList<>();

        myAdaptor = new Adaptor(photoPostArrayList);
        binding.recyclerView.setAdapter(myAdaptor);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        createArrayList();
        return view;
    }
    private void createArrayList(){
        photoPostArrayList.add(new PhotoPost(R.drawable.togg,"Recep Tayyip Erdoğan","Eyy Musk! Sen kimsin ya. Yapmışsın çöp tenekesi gibi araba. Gözün az tasarım görsün. "));
        photoPostArrayList.add(new PhotoPost(R.drawable.tesla,"Elon Musk","Bahçeli o külüstür ne be. Gözün araba görsün araba :)"));
        photoPostArrayList.add(new PhotoPost(R.drawable.antika,"Devlet Bahçeli","Ah gençliğim ahh..."));
    }
}