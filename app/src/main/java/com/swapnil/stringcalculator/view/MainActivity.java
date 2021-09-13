package com.swapnil.stringcalculator.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.swapnil.stringcalculator.R;
import com.swapnil.stringcalculator.viewmodel.StringCalcViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etInputField;
    private Button calculate;
    private TextView tvStringCalcResponse;

    StringCalcViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInputField = findViewById(R.id.etRequestString);
        calculate = findViewById(R.id.btnCalculate);
        tvStringCalcResponse = findViewById(R.id.tvResponse);

        viewModel = new ViewModelProvider(this).get(StringCalcViewModel.class);

        calculate.setOnClickListener(this);
        observeResponse();
    }

    private void observeResponse() {
        viewModel.dataFromRepo.observe(this, integer -> {
            tvStringCalcResponse.setText("Result: "+integer.toString());
        });
    }

    @Override
    public void onClick(View view) {
        try {
            viewModel.getStringCalculations(etInputField.getText().toString());
        } catch (Exception e) {
            //exception for negative scenario
            tvStringCalcResponse.setText(e.getLocalizedMessage());
        }
    }
}