package com.example.yo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.yo.databinding.FragmentFragmentoImagenBinding;

import java.io.IOException;
import java.io.InputStream;

public class FragmentoImagen extends Fragment {


    private FragmentFragmentoImagenBinding binding;

    public FragmentoImagen() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFragmentoImagenBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        loadImageFromAssets("example_image.png");
    }

    private void loadImageFromAssets(String fileName) {
        try {
            InputStream inputStream = getActivity().getAssets().open(fileName);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            binding.imageView.setImageBitmap(bitmap);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        binding = null;
    }
}
