package com.swapnil.stringcalculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

public class CalcRepo {

    private static final Pattern negativeFinder =
            Pattern.compile("-[0-9]*");

    private static final Pattern numbersFinder =
            Pattern.compile("[0-9]*");

    @Inject
    public CalcRepo() {
    }

    public int add(String input) throws Exception{
        if(input.isEmpty()){
            return 0;
        }
        int negativeNumber = isNumNegative(input);
        if(negativeNumber < 0){
            throw new Exception("Negatives not allowed. : "+negativeNumber);
        }else{
            return addNumbers(input);
        }
    }

    public int addNumbers(String input) {
        int count = 0;
        List<Integer> summationList = new ArrayList<>();
        Matcher matcher = numbersFinder.matcher(input);
        while(matcher.find()){
            try{
                int val = Integer.parseInt(matcher.group());
                summationList.add(val);
            }catch (NumberFormatException exp){
                //ignore, since we are aware there will be some special characters.
            }
        }
        for(int i = 0; i < summationList.size(); i++){
            if(summationList.get(i) <= 1000){
                count = count + summationList.get(i);
            }
        }
        return count;
    }

    public int isNumNegative(String input) {
        Matcher matcher = negativeFinder.matcher(input);
        if(matcher.find()){
            //found, returning first found element
            return Integer.parseInt(matcher.group());
        }else{
            //not found
            return 0;
        }
    }
}
