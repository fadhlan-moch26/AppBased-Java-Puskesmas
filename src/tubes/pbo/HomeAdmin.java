package tubes.pbo;

import javax.swing.*;
import java.awt.*;

public class HomeAdmin extends javax.swing.JFrame {
    
    public HomeAdmin() {
        initComponents();
        getContentPane().setBackground(new Color(0,0,0));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        list_pasien = new javax.swing.JButton();
        logout_button = new javax.swing.JButton();
        list_pegawai = new javax.swing.JButton();
        list_obat = new javax.swing.JButton();
        list_konsultasi = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        profile_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Halo,");
        jLabel3.setMaximumSize(new java.awt.Dimension(90, 22));

        list_pasien.setBackground(new java.awt.Color(0, 153, 153));
        list_pasien.setForeground(new java.awt.Color(255, 255, 255));
        list_pasien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/img/Patient.png"))); // NOI18N
        list_pasien.setText("List pasien");
        list_pasien.setIconTextGap(8);
        list_pasien.setMargin(new java.awt.Insets(8, 14, 8, 14));
        list_pasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list_pasienActionPerformed(evt);
            }
        });

        logout_button.setBackground(new java.awt.Color(255, 255, 255));
        logout_button.setForeground(new java.awt.Color(0, 153, 153));
        logout_button.setText("Logout");
        logout_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_buttonActionPerformed(evt);
            }
        });

        list_pegawai.setBackground(new java.awt.Color(0, 153, 153));
        list_pegawai.setForeground(new java.awt.Color(255, 255, 255));
        list_pegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/img/Doctor.png"))); // NOI18N
        list_pegawai.setText("List Pegawai");
        list_pegawai.setIconTextGap(8);
        list_pegawai.setMargin(new java.awt.Insets(8, 14, 8, 14));
        list_pegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list_pegawaiActionPerformed(evt);
            }
        });

        list_obat.setBackground(new java.awt.Color(0, 153, 153));
        list_obat.setForeground(new java.awt.Color(255, 255, 255));
        list_obat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/img/Medicine.png"))); // NOI18N
        list_obat.setText("List Obat");
        list_obat.setIconTextGap(8);
        list_obat.setMargin(new java.awt.Insets(8, 14, 8, 14));
        list_obat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list_obatActionPerformed(evt);
            }
        });

        list_konsultasi.setBackground(new java.awt.Color(0, 153, 153));
        list_konsultasi.setForeground(new java.awt.Color(255, 255, 255));
        list_konsultasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/img/History.png"))); // NOI18N
        list_konsultasi.setText("List Riwayat Konsultasi");
        list_konsultasi.setIconTextGap(8);
        list_konsultasi.setMargin(new java.awt.Insets(8, 14, 8, 14));
        list_konsultasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list_konsultasiActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Admin");
        jLabel4.setMaximumSize(new java.awt.Dimension(90, 22));

        profile_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/img/Profile.png"))); // NOI18N
        profile_button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        profile_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profile_buttonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/img/Background.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(profile_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(list_pasien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logout_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(list_pegawai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(list_obat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(list_konsultasi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(profile_button))
                .addGap(29, 29, 29)
                .addComponent(list_pasien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(list_pegawai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(list_obat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(list_konsultasi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logout_button, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void list_pasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_pasienActionPerformed
        dispose();
        ListPasien pasien = new ListPasien();
        pasien.setLocationRelativeTo(null);
        pasien.setTitle("Aplikasi Puskesmas");
        pasien.setVisible(true);
    }//GEN-LAST:event_list_pasienActionPerformed

    private void logout_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_buttonActionPerformed
        dispose();
        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        login.setTitle("Aplikasi Puskesmas");
    }//GEN-LAST:event_logout_buttonActionPerformed

    private void list_pegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_pegawaiActionPerformed
        dispose();
        ListPegawai pegawai = new ListPegawai();
        pegawai.setLocationRelativeTo(null);
        pegawai.setTitle("Aplikasi Puskesmas");
        pegawai.setVisible(true);
    }//GEN-LAST:event_list_pegawaiActionPerformed

    private void list_obatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_obatActionPerformed
        dispose();
        ListObat obat = new ListObat();
        obat.setLocationRelativeTo(null);
        obat.setTitle("Aplikasi Puskesmas");
        obat.setVisible(true);
    }//GEN-LAST:event_list_obatActionPerformed

    private void list_konsultasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_konsultasiActionPerformed
        dispose();
        RiwayatKonsultasi rKonsultasi = new RiwayatKonsultasi();
        rKonsultasi.setLocationRelativeTo(null);
        rKonsultasi.setTitle("Aplikasi Puskesmas");
        rKonsultasi.setVisible(true);
    }//GEN-LAST:event_list_konsultasiActionPerformed

    private void profile_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_buttonActionPerformed
        JOptionPane optionPane = new JOptionPane(new JLabel("Akun Ini Tidak Dapat Diubah",JLabel.CENTER));
        JDialog dialog = optionPane.createDialog("");
        dialog.setSize(400, 130);
        dialog.setLocationRelativeTo(null);
        dialog.setModal(true);
        dialog.setVisible(true);
    }//GEN-LAST:event_profile_buttonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton list_konsultasi;
    private javax.swing.JButton list_obat;
    private javax.swing.JButton list_pasien;
    private javax.swing.JButton list_pegawai;
    private javax.swing.JButton logout_button;
    private javax.swing.JButton profile_button;
    // End of variables declaration//GEN-END:variables
}
