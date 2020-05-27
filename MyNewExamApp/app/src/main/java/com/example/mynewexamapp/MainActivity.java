package com.example.mynewexamapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mynewexamapp.Dao.ExamDBHelper;
import com.example.mynewexamapp.Entity.QuestionListener;
import com.example.mynewexamapp.Entity.QuestionModel;
import com.example.mynewexamapp.Entity.RadioModel;
import com.example.mynewexamapp.Entity.ToggleModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, QuestionListener {

    private List<QuestionModel> questionArr;
    private int curShowIndex =0;

    private Button preBtn,nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preBtn = findViewById(R.id.btnPro);
        nextBtn = findViewById(R.id.btnNext);
        questionArr = new ArrayList<>();

        preBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);

        reloadQuestions();
    }


    private void reloadQuestions(){
        ToggleModel toggle = new ToggleModel();
        RadioModel radio = new RadioModel();

        ArrayList toggleArr = ExamDBHelper.findAll(toggle);
        ArrayList radioArr = ExamDBHelper.findAll(radio);

        questionArr.addAll(toggleArr);
        questionArr.addAll(radioArr);

        for (int i=0;i<questionArr.size();i++)
        {
            QuestionModel question = questionArr.get(i);
            question.setQuestionIndex(i+1);
            question.setListener(this);
        }

        showQuestion(0);

    }

    private void showQuestion(int index){
        QuestionModel question = questionArr.get(index);

        //切换页面
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        QuestionFragment fragment = new QuestionFragment(question); //可以通过构造方法，将QuestionEntity 传入
        transaction.replace(R.id.flContainer, fragment);
        transaction.commit();

        if (index==0){
            preBtn.setVisibility(View.GONE);
        }else if(index == (questionArr.size()-1) ){
            nextBtn.setVisibility(View.GONE);
        }else{
            preBtn.setVisibility(View.VISIBLE);
            nextBtn.setVisibility(View.VISIBLE);
        }

    }

    private void preAction(){
        if (curShowIndex==0){
            return;
        }

        curShowIndex--;
        showQuestion(curShowIndex);
    }

    private void nextAction(){
        if (curShowIndex == (questionArr.size()-1) ){
            return;
        }

        curShowIndex++;
        showQuestion(curShowIndex);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPro:
                preAction();
                break;

            case R.id.btnNext:
                nextAction();
                break;
        }
    }

    @Override
    public void onQuestionDidPickAnswer(int ansIndex) {
        nextAction();
    }
}
