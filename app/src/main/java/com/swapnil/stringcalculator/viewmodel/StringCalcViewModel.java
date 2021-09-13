package com.swapnil.stringcalculator.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.swapnil.stringcalculator.di.DaggerCalcComponent;
import com.swapnil.stringcalculator.model.CalcRepo;

import javax.inject.Inject;

public class StringCalcViewModel extends ViewModel{

    @Inject
    CalcRepo calcRepo;

    public MutableLiveData<Integer> dataFromRepo = new MutableLiveData<Integer>();

    public StringCalcViewModel() {
        DaggerCalcComponent.create().inject(this);
    }

    public void getStringCalculations(String input) throws Exception {
        dataFromRepo.setValue(calcRepo.add(input));
    }
}
