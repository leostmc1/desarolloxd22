package com.leo.desarolloxd;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Encuesta#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Encuesta extends Fragment {
    private int[] questions = {R.string.q1, R.string.q2, R.string.q3, R.string.q4, R.string.q5};
    private boolean[] answers = {true, true, true, true, true};
    private int curQuestionIdx = 0;
    private TextView txtQuestion;

    private Button btnNext;

    private Button btnTrue;

    private Button btnFalse;

    private Button resultado;

    private int score = 0;
    public Encuesta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Encuesta.
     */
    // TODO: Rename and change types and number of parameters
    public static Encuesta newInstance(String param1, String param2) {
        Encuesta fragment = new Encuesta();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_encuesta, container, false);
        txtQuestion = (TextView) root.findViewById(R.id.pregunta);
        txtQuestion.setText(questions[curQuestionIdx]);
        btnNext = (Button) root.findViewById(R.id.bottonsiguiente);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curQuestionIdx = (curQuestionIdx + 1) % questions.length;
                nextQuestion();
            }
        });
        btnTrue = (Button) root.findViewById(R.id.bottonsi);
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });
        btnFalse = (Button) root.findViewById(R.id.bottonno);
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });
        resultado = (Button) root.findViewById(R.id.botonresultado);
        resultado.setVisibility(View.GONE);
        resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostratresultado();
            }
        });
        return root;
    }

    private void mostratresultado() {
        if(score==20){
            Toast.makeText(getContext(), "Usted tiene un resfriado", Toast.LENGTH_LONG).show();
        }
        else if(score==40){
            Toast.makeText(getContext(), "Usted tiene un resfriado", Toast.LENGTH_LONG).show();
        }
        else if(score==60){
            Toast.makeText(getContext(), "Puede que tenga covid", Toast.LENGTH_LONG).show();
        }
        else if(score==80){
            Toast.makeText(getContext(), "Vaya al doctor para un chequeo", Toast.LENGTH_LONG).show();
        }
        else if(score==100){
            Toast.makeText(getContext(), "Es urgente que vaya al doctor", Toast.LENGTH_LONG).show();
        }
    }

    private void nextQuestion() {
        if(curQuestionIdx==4){
            txtQuestion.setVisibility(View.GONE);
            btnFalse.setVisibility(View.GONE);
            btnNext.setVisibility(View.GONE);
            btnTrue.setVisibility(View.GONE);
            resultado.setVisibility(View.VISIBLE);
        }
        txtQuestion.setText(questions[curQuestionIdx]);
    }
    private boolean checkAnswer(boolean answer) {
        String q = txtQuestion.getText().toString().trim();
        if (answer == answers[curQuestionIdx]) {
            score = score + 20;
            Toast.makeText(getContext(), R.string.correct_answer, Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getContext(), R.string.wrong_answer, Toast.LENGTH_SHORT).show();
        }
        return answers[curQuestionIdx];
    }
}