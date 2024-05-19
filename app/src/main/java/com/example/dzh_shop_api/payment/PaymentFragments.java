package com.example.dzh_shop_api.payment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dzh_shop_api.R;
import com.example.dzh_shop_api.databinding.FragmentPaymentBinding;

public class PaymentFragment extends Fragment {

    FragmentPaymentBinding binding;
    NavController navController;

    public PaymentFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPaymentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.cardMbank.setOnClickListener(v1 -> {



            String PlayStoreUrl = "https://play.google.com/store/apps/details?id=com.maanavan.mb_kyrgyzstan";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(PlayStoreUrl));
            startActivity(intent);

        });

        binding.cardPaypal.setOnClickListener(v2 -> {
            String PlayStoreUrl = "https://play.google.com/store/apps/details?id=com.pay24.app";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(PlayStoreUrl));
            startActivity(intent);
        });

        binding.cardVisa.setOnClickListener(v3 -> {
            String PlayStoreUrl = "https://play.google.com/store/apps/details?id=com.conferma.trippay.visacommercialpay";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(PlayStoreUrl));
            startActivity(intent);
        });

        binding.o.setOnClickListener(v4 -> {
            String PlayStoreUrl = "https://play.google.com/store/apps/details?id=com.mastercard.mcglobalevents";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(PlayStoreUrl));
            startActivity(intent);
        });

        binding.btnBack.setOnClickListener(v5 -> {
            navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.action_basketFragment_to_navigation_home);
        });
    }
}