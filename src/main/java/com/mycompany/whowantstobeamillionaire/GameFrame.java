/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.whowantstobeamillionaire;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class GameFrame extends javax.swing.JFrame {
    private static int[] winAmounts = new int[] {0,0,500,1000,2000,3000,5000,10000,15000,25000,50000,100000,200000,400000,800000,1500000,3000000};
    DbAdapter dbAdapter = new DbAdapter("jdbc:sqlite:db\\millionaire.db");
    private Random rnd = new Random();
    int Level = 0;
    int cheetCount;
    Boolean useRightToMistake;
    Question currentQuestion;
    JButton[] answerBtns;
    JButton[] cheetBtns;

    /**
     * Creates new form GameFrame
     */
    public GameFrame() {
        initComponents();
        InitializeBtns();
        startGame();
    }
    private void InitializeBtns(){
        answerBtns = new JButton[] { btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4 };
        cheetBtns = new JButton[] { bntFiftyFifty, btnPeopleHelp, 
            btnChangeQuestion, btnRightToMistake };
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstLevel = new javax.swing.JList<>();
        lblQuestionText = new javax.swing.JLabel();
        btnAnswer1 = new javax.swing.JButton();
        btnAnswer3 = new javax.swing.JButton();
        btnAnswer2 = new javax.swing.JButton();
        btnAnswer4 = new javax.swing.JButton();
        bntFiftyFifty = new javax.swing.JButton();
        btnPeopleHelp = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        btnGetMoney = new javax.swing.JButton();
        btnChangeQuestion = new javax.swing.JButton();
        btnRightToMistake = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        btnWinners = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon("image\\picture.jpg"));
        jLabel1.setText("jLabel1");

        lstLevel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lstLevel.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "3 000 000", "1 500 000", "   800 000", "   400 000", "   200 000", "   100 000", "     50 000", "     25 000", "     15 000", "     10 000", "       5 000", "       3 000", "       2 000", "       1 000", "          500" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstLevel.setName("lstLevel"); // NOI18N
        jScrollPane1.setViewportView(lstLevel);

        lblQuestionText.setText("jLabel2");
        lblQuestionText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblQuestionText.setName("lblQuestionText"); // NOI18N

        btnAnswer1.setText("btnAnswer1");
        btnAnswer1.setActionCommand("1");
        btnAnswer1.setName("btnAnswer1"); // NOI18N
        btnAnswer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswer1ActionPerformed(evt);
            }
        });

        btnAnswer3.setText("btnAnswer3");
        btnAnswer3.setActionCommand("3");
        btnAnswer3.setName("btnAnswer3"); // NOI18N
        btnAnswer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswer3ActionPerformed(evt);
            }
        });

        btnAnswer2.setText("btnAnswer2");
        btnAnswer2.setActionCommand("2");
        btnAnswer2.setName("btnAnswer2"); // NOI18N
        btnAnswer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswer2ActionPerformed(evt);
            }
        });

        btnAnswer4.setText("btnAnswer4");
        btnAnswer4.setActionCommand("4");
        btnAnswer4.setName("btnAnswer4"); // NOI18N
        btnAnswer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswer4ActionPerformed(evt);
            }
        });

        bntFiftyFifty.setText("50/50");
        bntFiftyFifty.setName("btn50_50"); // NOI18N
        bntFiftyFifty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntFiftyFiftyActionPerformed(evt);
            }
        });

        btnPeopleHelp.setText("Помощь зала");
        btnPeopleHelp.setName("btnHallHelp"); // NOI18N
        btnPeopleHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeopleHelpActionPerformed(evt);
            }
        });

        jButton9.setText("Звонок друга");
        jButton9.setName("btnCallFriend"); // NOI18N

        btnGetMoney.setText("Забрать деньги");
        btnGetMoney.setName("btnGetMonney"); // NOI18N
        btnGetMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetMoneyActionPerformed(evt);
            }
        });

        btnChangeQuestion.setText("Замена вопроса");
        btnChangeQuestion.setName("btnChangeQuestion"); // NOI18N
        btnChangeQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeQuestionActionPerformed(evt);
            }
        });

        btnRightToMistake.setText("Право на ошибку");
        btnRightToMistake.setName("btnRightToMistake"); // NOI18N
        btnRightToMistake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRightToMistakeActionPerformed(evt);
            }
        });

        jLabel2.setText("Введите свое имя");

        btnWinners.setText("Рекорды");
        btnWinners.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWinnersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQuestionText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnswer1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnswer3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnswer2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnswer4, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnGetMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPeopleHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bntFiftyFifty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnChangeQuestion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRightToMistake, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnWinners)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bntFiftyFifty)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPeopleHelp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addGap(7, 7, 7)
                        .addComponent(btnChangeQuestion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRightToMistake)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGetMoney)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnWinners)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(lblQuestionText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnswer1)
                    .addComponent(btnAnswer3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnswer2)
                    .addComponent(btnAnswer4))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnswer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswer1ActionPerformed
        btnAnswerActionPerformed(evt);
    }//GEN-LAST:event_btnAnswer1ActionPerformed

    private void btnAnswer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswer2ActionPerformed
        btnAnswerActionPerformed(evt);
    }//GEN-LAST:event_btnAnswer2ActionPerformed

    private void btnAnswer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswer3ActionPerformed
        btnAnswerActionPerformed(evt);
    }//GEN-LAST:event_btnAnswer3ActionPerformed

    private void btnAnswer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswer4ActionPerformed
        btnAnswerActionPerformed(evt);
    }//GEN-LAST:event_btnAnswer4ActionPerformed

    private void bntFiftyFiftyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntFiftyFiftyActionPerformed
        bntFiftyFifty.setEnabled(false);
        int count = 0;
        while (count<2){
            int n = rnd.nextInt(4);
            String ac = answerBtns[n].getActionCommand();
            if (!currentQuestion.CheckAnswer(ac) && answerBtns[n].isEnabled()){
                answerBtns[n].setEnabled(false);
                count++;
            }
        }
        CheckCheetCount();
    }//GEN-LAST:event_bntFiftyFiftyActionPerformed

    private void btnPeopleHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeopleHelpActionPerformed
        btnPeopleHelp.setEnabled(false);
        List<Integer> activAnswers = new ArrayList<Integer>();
        for(JButton btn: answerBtns){
            if (btn.isEnabled()){
                activAnswers.add(Integer.valueOf(btn.getActionCommand()) - 1);
            }
        }
        Integer[] voteResult = GetVoteResult(activAnswers);
        for(JButton btn: answerBtns){
            Integer i = Integer.valueOf(btn.getActionCommand()) - 1;
            if(btn.isEnabled()){
                btn.setText(String.format("%s: %d %%",btn.getText(),voteResult[i]));
            }
        }
        CheckCheetCount();
    }//GEN-LAST:event_btnPeopleHelpActionPerformed

    private void btnChangeQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeQuestionActionPerformed
        Level--;
        NextStep();
        btnChangeQuestion.setEnabled(false);
        CheckCheetCount();
    }//GEN-LAST:event_btnChangeQuestionActionPerformed

    private void btnRightToMistakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRightToMistakeActionPerformed
        useRightToMistake = true;
        btnRightToMistake.setEnabled(false);
        CheckCheetCount();
    }//GEN-LAST:event_btnRightToMistakeActionPerformed

    private void btnGetMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetMoneyActionPerformed
        if (Level < 2)
            JOptionPane.showMessageDialog(this, "Вы не ответили ни на один вопрос!");
        else finishGame();
    }//GEN-LAST:event_btnGetMoneyActionPerformed

    private void btnWinnersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWinnersActionPerformed
        Object[][] data = dbAdapter.GetWinnersList();
        WinnersFrame winFrame = new WinnersFrame(data);
        winFrame.setVisible(true);
    }//GEN-LAST:event_btnWinnersActionPerformed

    private void CheckCheetCount(){
        if(++cheetCount == 4) setEnableCheetBtns(false);
    }
    
    private Integer[] GetVoteResult(List<Integer> activAnswers){
        Integer[] voteResult = new Integer[4];
        Integer rigthAnswerVote = GetRigthAnswerVote(activAnswers.size());
        Integer residue = 100 - rigthAnswerVote;
        Integer basehAnswerVote = residue/(activAnswers.size() - 1);
        for(int i = 0;i < 4; i++){
            if(i == currentQuestion.RightAnswerIndex()){
                voteResult[i] = rigthAnswerVote;
            }else if(activAnswers.contains(i)){
                int addition = rnd.nextInt(Level) - Level/2;
                int value = basehAnswerVote + addition < residue ? 
                        basehAnswerVote + addition : residue;
                residue -= value;
                voteResult[i] = value;
            }
        }
        return voteResult;
    }
    
    private Integer GetRigthAnswerVote(int answerCount){
        double power = (double)answerCount/-9;
        return (int)(100 * Math.pow(Level, power));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrame().setVisible(true);
            }
        });
    }

    private void ShowQuestion(Question q){
        lblQuestionText.setText(q.Text);
        for(int i = 0;i < 4; i++){
            answerBtns[i].setText(q.Answers[i]);
        }
    }

    private void NextStep(){
        for(JButton btn: answerBtns) btn.setEnabled(true);
        Level++;
        currentQuestion = this.dbAdapter.GetQuestionByLevel(Level);
        ShowQuestion(currentQuestion);
        lstLevel.setSelectedIndex(lstLevel.getModel().getSize()-Level);
    }
    
    private void startGame(){
        Level = 0;
        cheetCount = 0;
        useRightToMistake = false;
        NextStep();
        setEnableCheetBtns(true);
    }

    private void setEnableCheetBtns(Boolean value){
        for(JButton btn: cheetBtns)
            btn.setEnabled(value);
    }

    private void btnAnswerActionPerformed(java.awt.event.ActionEvent evt) {                                           
        JButton btn = (JButton)evt.getSource();
        if (currentQuestion.CheckAnswer(evt.getActionCommand())){
            useRightToMistake = false;
            if (Level < 15) NextStep();
            else finishGame();
        }
        else if(useRightToMistake){
            useRightToMistake = false;
            btn.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Неверный ответ! Попробуйте снова");
        }
        else{
            JOptionPane.showMessageDialog(this, "Неверный ответ!");
            startGame();
        }
    }
    
    private void finishGame(){
        String name = tfName.getText();
        if (IsEmptyString(name)){
            name = JOptionPane.showInputDialog(this,"Для записи в кинигу рекордов введите Ваше имя");
            tfName.setText(name);
        }
        if (IsEmptyString(name)){
            JOptionPane.showMessageDialog(this, String.format(
                    "Поздравляем! Ваш выигрыш составил %d рублей! Но, к сожалению, рекорд не будет записан",
                    winAmounts[Level]));
        }
        else{
            dbAdapter.SaveWinner(name, winAmounts[Level]);
            JOptionPane.showMessageDialog(this, String.format(
                    "Поздравляем %s! Ваш выигрыш составил %d рублей!", name,
                    winAmounts[Level]));
        }
        startGame();
    }
    
    private boolean IsEmptyString(String string){
        return string == null || string.trim().isEmpty();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntFiftyFifty;
    private javax.swing.JButton btnAnswer1;
    private javax.swing.JButton btnAnswer2;
    private javax.swing.JButton btnAnswer3;
    private javax.swing.JButton btnAnswer4;
    private javax.swing.JButton btnChangeQuestion;
    private javax.swing.JButton btnGetMoney;
    private javax.swing.JButton btnPeopleHelp;
    private javax.swing.JButton btnRightToMistake;
    private javax.swing.JButton btnWinners;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblQuestionText;
    private javax.swing.JList<String> lstLevel;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
