package com.example.yo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.yo.databinding.FragmentFragmento3Binding;

import java.io.IOException;
import java.io.InputStream;

public class fragmento3 extends Fragment {

    private FragmentFragmento3Binding binding;

    public fragmento3() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFragmento3Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadImageFromAssets("example_image.png");

        binding.linkedinButton.setOnClickListener(v -> openUrl("https://www.linkedin.com/in/carlos-berrios-758646313?trk=contact-info"));
        binding.whatsappButton.setOnClickListener(v -> openUrl("https://wa.me/56997628610"));
        binding.gmailButton.setOnClickListener(v -> openEmail("cberriost@gmail.com", "Felicidades te sacaste un azul en el Sprint del modulo 4 :D"));
        binding.onlyfansButton.setOnClickListener(v -> openUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSdXSg5TX9sgOHJDPycZsf63HEXX6Lb4luhmg&s"));
    }

    private void loadImageFromAssets(String fileName) {
        try {
            InputStream inputStream = getActivity().getAssets().open(fileName);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            binding.linkedInImageView.setImageBitmap(bitmap);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private void openEmail(String email, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + email));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
