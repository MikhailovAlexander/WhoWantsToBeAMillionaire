/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.whowantstobeamillionaire;

/**
 *
 * @author User
 */
public class Question {
    public String Text;
    String[] Answers = new String[4];
    public String RightAnswer;
    public int Level;
    public Question(String[] s){
            Text = s[0];
            for (int i=0; i<4; i++)
                Answers[i]= s[i+1];
            RightAnswer=s[5];
            Level = Integer.parseInt(s[6]);
        }
    public Question(String text, String answer1, String answer2, String answer3,
            String answer4, String rightAnswer, Integer level){
            Text = text;
            Answers = new String[] {answer1, answer2, answer3, answer4};
            RightAnswer = rightAnswer;
            Level = level;
        }
    public Question(){
        Text = "undefined";
    }
    public Boolean CheckAnswer(String answer){
        return this.RightAnswer.equals(answer);
    }
    
    public Integer RightAnswerIndex(){
        return Integer.parseInt(RightAnswer) - 1;
    }
}
