package com.example.mynewexamapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mynewexamapp.Entity.QuestionModel;
import com.example.mynewexamapp.Entity.RadioModel;
import com.example.mynewexamapp.Entity.ToggleModel;

public class QuestionFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {

    private QuestionModel questionModel;

    private TextView titleLab;
    private TextView contentLab;
    private TextView selAnsLab;
    private RadioButton ans1;
    private RadioButton ans2;
    private RadioButton ans3;
    private RadioButton ans4;
    RadioGroup ansGroup;

    public QuestionFragment(QuestionModel question) {
        questionModel = question;
    }


    //用于填充Fragment布局文件
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question_fragment, container, false);
    }

    //布局View创建好之后，调用
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        titleLab = view.findViewById(R.id.questionTitle);
        contentLab = view.findViewById(R.id.questionContent);
        selAnsLab = view.findViewById(R.id.selAns);
        ans1 = view.findViewById(R.id.ans1);
        ans2 = view.findViewById(R.id.ans2);
        ans3 = view.findViewById(R.id.ans3);
        ans4 = view.findViewById(R.id.ans4);
        ansGroup = view.findViewById(R.id.ansGroup);
        ansGroup.setOnCheckedChangeListener(this);

        refresh();
    }

    private void refresh(){
        titleLab.setText("第"+questionModel.getQuestionIndex()+"题");
        contentLab.setText(questionModel.getTitle());
        if (questionModel.getSelAnsIndex() != 10000){
            selAnsLab.setText(questionModel.getSelAnsContetn());
        }else{
            selAnsLab.setText("请选择答案");
        }

        if (questionModel instanceof RadioModel){
            ans1.setText(((RadioModel) questionModel).getAnsA());
            ans2.setText(((RadioModel) questionModel).getAnsB());
            ans3.setText(((RadioModel) questionModel).getAnsC());
            ans4.setText(((RadioModel) questionModel).getAnsD());

        }else if (questionModel instanceof ToggleModel){
            ans1.setText("是");
            ans2.setText("否");
            ans3.setVisibility(View.GONE);
            ans4.setVisibility(View.GONE);
        }

        if (questionModel.getSelAnsIndex() != 10000){
            switch (questionModel.getSelAnsIndex()){
                case 0:
                    ans1.setChecked(true);
                    break;
                case 1:
                    ans2.setChecked(true);
                    break;
                case 2:
                    ans3.setChecked(true);
                    break;
                case 3:
                    ans4.setChecked(true);
                    break;
            }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.ans1:
                questionModel.setSelAnsIndex(0);
                break;
            case R.id.ans2:
                questionModel.setSelAnsIndex(1);
                break;
            case R.id.ans3:
                questionModel.setSelAnsIndex(2);
                break;
            case R.id.ans4:
                questionModel.setSelAnsIndex(3);
                break;
            default:
                break;
        }

        refresh();
    }
}
