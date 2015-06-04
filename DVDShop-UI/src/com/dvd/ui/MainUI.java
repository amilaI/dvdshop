package com.dvd.ui;

import com.dvd.domain.User;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class MainUI extends javax.swing.JFrame {

    
    private User dvdUser;
    /**
     * Creates new form ShopUI
     */
    public MainUI(User user)  {
        initComponents();
        welcomeLabel.setText("Hi " + user.getUserName() + "!!");
        dvdUser = user;
        if(user.getUserType().equals("emp")){
            memberLabel.setText("DVD Shop - Employee Login");
        }else if (user.getUserType().equals("mem")){
            memberLabel.setText("DVD Shop - Member Login");
            searchDVDBtn.setText("Seach DVD / Locate DVD");
            addDVDBtn.setVisible(false);
            updateBtn.setVisible(false);
            addUserBtn.setVisible(false);
            
            
        }else{
            dispose();
        }
//        BufferedImage bi = null;
//        try {
//            bi = ImageIO.read(getClass().getResource("pic1.png"));
//        } catch (IOException ex) {
//            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        ImageIcon image = new ImageIcon(bi);
//        picLabel.setIcon(image);
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
        memberLabel = new java.awt.Label();
        welcomeLabel = new javax.swing.JLabel();
        addDVDBtn = new javax.swing.JButton();
        searchDVDBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        picLabel = new javax.swing.JLabel();
        addUserBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(106, 161, 172));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(23, 193, 111));
        jPanel1.setForeground(new java.awt.Color(74, 74, 74));

        memberLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        memberLabel.setFont(new java.awt.Font("Ubuntu Medium", 1, 36)); // NOI18N
        memberLabel.setForeground(new java.awt.Color(254, 254, 254));

        welcomeLabel.setFont(new java.awt.Font("Ubuntu Medium", 0, 24)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(254, 254, 254));
        welcomeLabel.setText("Hi John!! ");

        addDVDBtn.setText("Add DVD");
        addDVDBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDVDBtnActionPerformed(evt);
            }
        });

        searchDVDBtn.setText("Search DVD");
        searchDVDBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDVDBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("Update Inventory");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        picLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pic2.jpg"))); // NOI18N

        addUserBtn.setText("Add User");
        addUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(picLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(welcomeLabel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addDVDBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(searchDVDBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(memberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(memberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(welcomeLabel)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(addDVDBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchDVDBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(picLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        memberLabel.getAccessibleContext().setAccessibleName("Welcome to DVD Shop");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
         new UpdateInventory().setVisible(true);
    }//GEN-LAST:event_updateBtnActionPerformed

    private void searchDVDBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDVDBtnActionPerformed
        new SearchDVD(dvdUser).setVisible(true);
    }//GEN-LAST:event_searchDVDBtnActionPerformed

    private void addDVDBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDVDBtnActionPerformed
        new AddDVD().setVisible(true);
    }//GEN-LAST:event_addDVDBtnActionPerformed

    private void addUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserBtnActionPerformed
        new AddUser().setVisible(true);
    }//GEN-LAST:event_addUserBtnActionPerformed

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
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDVDBtn;
    private javax.swing.JButton addUserBtn;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label memberLabel;
    private javax.swing.JLabel picLabel;
    private javax.swing.JButton searchDVDBtn;
    private javax.swing.JButton updateBtn;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}