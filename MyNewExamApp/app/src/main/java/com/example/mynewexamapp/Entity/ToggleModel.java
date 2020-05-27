package com.example.mynewexamapp.Entity;

public class ToggleModel extends QuestionModel {


    public ToggleModel() {
        this.setTableName("toggle");
    }


    @Override
    public void setSelAnsIndex(int selAnsIndex) {
        super.setSelAnsIndex(selAnsIndex);
        switch (selAnsIndex){
            case 0:
                this.setSelAnsContetn("您选择的答案为:是");
                break;
            case 1:
                this.setSelAnsContetn("您选择的答案为:否");
                break;
        }
    }


}
