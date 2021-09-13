package com.swapnil.stringcalculator.di;

import com.swapnil.stringcalculator.model.CalcRepo;

import dagger.Module;
import dagger.Provides;

@Module
class CalcRepoModule {

    @Provides
    static CalcRepo provideRepoObj(){
        return new CalcRepo();
    }
}
