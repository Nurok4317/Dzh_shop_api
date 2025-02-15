package com.example.dzh_shop_api.ui.dashboard;


import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import com.example.dzh_shop_api.R;
import com.example.dzh_shop_api.databinding.FragmentBasketBinding;
import com.example.dzh_shop_api.model.ModelM;
import com.example.dzh_shop_api.ui.home.JemAdapter;

import java.util.ArrayList;

public class BasketFragment extends Fragment {
    FragmentBasketBinding binding;
    private ArrayList<ModelM> basketProducts;
    JemAdapter adapter;
    NavController navController;
    Double totalSum = 1.1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentBasketBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        if(getArguments() != null){
            basketProducts = new ArrayList<>();
            basketProducts = getArguments().getParcelableArrayList("basket");

        }
        if(basketProducts != null){
            binding.placeHolder.setVisibility(View.GONE);
            adapter = new JemAdapter(requireActivity(), basketProducts);
            binding.rvBasket.setAdapter(adapter);
        } else {
            binding.placeHolder.setVisibility(View.VISIBLE);
        }
        try {
            for (int i = 0; i < basketProducts.size(); i++){
                totalSum += basketProducts.get(i).getModelPrice();
            }
            binding.basketTotalCount.setText(String.valueOf(totalSum - 1.1));
        } catch (NullPointerException e){
            binding.basketTotalCount.setText("0.0");
            binding.placeHolder.setVisibility(View.VISIBLE);
        }

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        adapter = new JemAdapter(requireActivity(), basketProducts);
//        binding.rvBasket.setAdapter(adapter);


        binding.btnBack.setOnClickListener(v -> {
            navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.action_basketFragment_to_navigation_home);
        });

        binding.btnPay.setOnClickListener(v1 -> {
            navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.navigation_payment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}