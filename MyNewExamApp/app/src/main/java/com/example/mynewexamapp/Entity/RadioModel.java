package com.example.mynewexamapp.Entity;



public class RadioModel extends QuestionModel {

    private String ansA;
    private String ansB;
    private String ansC;
    private String ansD;

    @Override
    public void setSelAnsIndex(int selAnsIndex) {
        super.setSelAnsIndex(selAnsIndex);
        switch (selAnsIndex){
            case 0:
                this.setSelAnsContetn("您选择的答案为:A");
                break;
            case 1:
                this.setSelAnsContetn("您选择的答案为:B");
                break;
            case 2:
                this.setSelAnsContetn("您选择的答案为:C");
                break;
            case 3:
                this.setSelAnsContetn("您选择的答案为:D");
                break;
        }
    }

    public RadioModel() {
        this.setTableName("radio");
    }

    public String getAnsA() {
        return ansA;
    }

    public void setAnsA(String ansA) {
        this.ansA = "A：" + ansA;
    }

    public String getAnsB() {
        return ansB;
    }

    public void setAnsB(String ansB) {
        this.ansB =  "B：" +  ansB;
    }

    public String getAnsC() {
        return ansC;
    }

    public void setAnsC(String ansC) {
        this.ansC =  "C：" + ansC;
    }

    public String getAnsD() {
        return ansD;
    }

    public void setAnsD(String ansD) {
        this.ansD =  "D：" + ansD;
    }

}
