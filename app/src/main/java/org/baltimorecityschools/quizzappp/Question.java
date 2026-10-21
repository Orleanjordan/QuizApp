package org.baltimorecityschools.quizzappp;

import androidx.annotation.NonNull;

public class Question {
    private String qPrompt;
    private boolean correctAns;

    public Question(){
        qPrompt = "unknown";
        correctAns = false;
    }

    public Question (String newqPrompt, boolean newcorrectAns){
        qPrompt = newqPrompt;
        correctAns = newcorrectAns;
    }

    public String getqPrompt() {
        return qPrompt;
    }

    public boolean getcorrectAns() {
        return correctAns;
    }

    public void setqPrompt(String newqPrompt){
        qPrompt = newqPrompt;
    }

    public void setCorrectAns(boolean newcorrectAns){
        correctAns = newcorrectAns;
    }



    
    @Override
    public String toString() {
        return "Question{" +
                "qPrompt='" + qPrompt + '\'' +
                '}';
    }
}
