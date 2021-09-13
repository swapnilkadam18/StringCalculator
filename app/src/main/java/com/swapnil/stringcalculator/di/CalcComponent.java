package com.swapnil.stringcalculator.di;

import com.swapnil.stringcalculator.model.CalcRepo;
import com.swapnil.stringcalculator.viewmodel.StringCalcViewModel;

import dagger.Component;

@Component(modules = {CalcRepoModule.class})
public interface CalcComponent {

    void inject(StringCalcViewModel viewModel);

}
