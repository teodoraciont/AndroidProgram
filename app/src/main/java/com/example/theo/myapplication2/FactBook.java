package com.example.theo.myapplication2;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class FactBook {
    private String[] mFacts = {
            "1.Ants stretch when they wake up in the morning.",
            "2.Ostriches can run faster than horses.",
            "3.Olympic gold medals are actually made mostly of silver.",
//            "You are born with 300 bones; by the time you are an adult you will have 206.",
//            "It takes about 8 minutes for light from the Sun to reach Earth.",
//            "Some bamboo plants can grow almost a meter in just one day.",
//            "The state of Florida is bigger than England.",
//            "Some penguins can leap 2-3 meters out of the water.",
//            "On average, it takes 66 days to form a new habit.",
//            "Mammoths still walked the earth when the Great Pyramid was being built."
    };
    public String[] getFacts(){
        return mFacts;
    }
    public String getFact() {
        String fact = "";
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mFacts.length);
        fact = mFacts[randomNumber];
        return fact;
    }
    public int searchFact (String key){
        int i=0;
        for(String item : mFacts){
            i++;
            if  (key!=null){
                if(key.equals(item)) {
                   return i;
                }
            }
        }
        return -1;
    }
    public String getFactByIndex(int index){
        if (index<mFacts.length && index>=0){
            return mFacts[index];
        }
        return null;
    }

    public String[] removeElements( String deleteMe) {
        List result = new LinkedList();
        int number=0;
        for(String item : mFacts){
            if  (deleteMe!=null){
                if(!deleteMe.equals(item)) {
                    result.add(item);
                }
                else{
                    number++;
                }
            }
        }
        mFacts = Arrays.copyOf(mFacts, mFacts.length-number);
        return (String[]) result.toArray(mFacts);
    }


    public String[] showAllFacts() {
       return mFacts;
    }

    public String showAllFactsLikeOneString() {
        String allFacts = "";
        for(String item : mFacts){
            if (item!=null){
                allFacts = allFacts +"  "+ item ;
            }
        }
        allFacts = allFacts +"  "+ mFacts.length ;
        return allFacts;
    }

}
