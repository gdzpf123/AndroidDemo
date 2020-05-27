package com.example.mynewexamapp.Entity;




public class QuestionModel extends DBBase{
    private int id;
    private String title;
    private String ans;

    private int questionIndex;
    private int selAnsIndex;
    private String selAnsContetn;
    private QuestionListener listener;

    public QuestionModel() {
        this.setTableName("");
        selAnsIndex = 10000;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public int getQuestionIndex() {
        return questionIndex;
    }

    public void setQuestionIndex(int questionIndex) {
        this.questionIndex = questionIndex;
    }

    public int getSelAnsIndex() {
        return selAnsIndex;
    }

    public void setSelAnsIndex(int selAnsIndex) {
        this.selAnsIndex = selAnsIndex;
        if (listener != null){
            listener.onQuestionDidPickAnswer(selAnsIndex);
        }
    }

    public String getSelAnsContetn() {
        return selAnsContetn;
    }

    public void setSelAnsContetn(String selAnsContetn) {
        this.selAnsContetn = selAnsContetn;
    }

    public QuestionListener getListener() {
        return listener;
    }

    public void setListener(QuestionListener listener) {
        this.listener = listener;
    }
}
