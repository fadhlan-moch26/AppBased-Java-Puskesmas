package tubes.pbo;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Home extends javax.swing.JFrame {
    static final String DB_URL = "jdbc:mysql://localhost:3306/pbo_tubes";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    ArrayList<Pasien> arr_pasien = new ArrayList<>();
    private int id_pasien;
    
    public Home() {
        initComponents();
        getContentPane().setBackground(new Color(0,0,0));
        try {
            FileInputStream readData = new FileInputStream("id.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);
            id_pasien = readStream.readInt();
            readStream.close();
            
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM pasien";
            rs = stmt.executeQuery(sql);
            while ( rs.next() ) {
                arr_pasien.add(new Pasien(rs.getInt("id"), rs.getString("nama"), rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getDate("tgl_lahir"), rs.getString("alamat"), rs.getInt("keluhan_id")));
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        } 
        label_nama.setText(" ");
        String temp = arr_pasien.get(id_pasien-1).getNama();
        int idx = temp.indexOf(' ');
        if ( idx == -1 ) {
            label_nama.setText(temp);
        } else {
            String firstname = temp.substring(0, idx);
            label_nama.setText(firstname);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ambulance_menu = new javax.swing.JButton();
        logout_button = new javax.swing.JButton();
        konsult_menu = new javax.swing.JButton();
        obat_menu = new javax.swing.JButton();
        payment_menu = new javax.swing.JButton();
        label_nama = new javax.swing.JLabel();
        edit_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Halo,");
        jLabel3.setMaximumSize(new java.awt.Dimension(90, 22));

        ambulance_menu.setBackground(new java.awt.Color(0, 153, 153));
        ambulance_menu.setForeground(new java.awt.Color(255, 255, 255));
        ambulance_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/img/Ambulance.png"))); // NOI18N
        ambulance_menu.setText("Pemesanan Ambulan");
        ambulance_menu.setIconTextGap(8);
        ambulance_menu.setMargin(new java.awt.Insets(8, 14, 8, 14));
        ambulance_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ambulance_menuActionPerformed(evt);
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

        konsult_menu.setBackground(new java.awt.Color(0, 153, 153));
        konsult_menu.setForeground(new java.awt.Color(255, 255, 255));
        konsult_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/img/Doctor.png"))); // NOI18N
        konsult_menu.setText("Pemesanan Konsultasi");
        konsult_menu.setIconTextGap(8);
        konsult_menu.setMargin(new java.awt.Insets(8, 14, 8, 14));
        konsult_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konsult_menuActionPerformed(evt);
            }
        });

        obat_menu.setBackground(new java.awt.Color(0, 153, 153));
        obat_menu.setForeground(new java.awt.Color(255, 255, 255));
        obat_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/img/Medicine.png"))); // NOI18N
        obat_menu.setText("Pengambilan Obat");
        obat_menu.setIconTextGap(8);
        obat_menu.setMargin(new java.awt.Insets(8, 14, 8, 14));
        obat_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obat_menuActionPerformed(evt);
            }
        });

        payment_menu.setBackground(new java.awt.Color(0, 153, 153));
        payment_menu.setForeground(new java.awt.Color(255, 255, 255));
        payment_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/img/Money.png"))); // NOI18N
        payment_menu.setText("Pembayaran");
        payment_menu.setIconTextGap(8);
        payment_menu.setMargin(new java.awt.Insets(8, 14, 8, 14));
        payment_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_menuActionPerformed(evt);
            }
        });

        label_nama.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        label_nama.setForeground(new java.awt.Color(0, 153, 153));
        label_nama.setText("<nama_user>");
        label_nama.setMaximumSize(new java.awt.Dimension(90, 22));

        edit_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/img/Profile.png"))); // NOI18N
        edit_button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_buttonActionPerformed(evt);
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
                        .addComponent(edit_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ambulance_menu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logout_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(konsult_menu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(obat_menu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(payment_menu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
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
                        .addComponent(label_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(edit_button))
                .addGap(29, 29, 29)
                .addComponent(ambulance_menu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(konsult_menu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(obat_menu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(payment_menu)
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

    private void ambulance_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ambulance_menuActionPerformed
        dispose();
        FormAmbulan ambulance = new FormAmbulan();
        ambulance.setLocationRelativeTo(null);
        ambulance.setVisible(true);
        ambulance.setTitle("Aplikasi Puskesmas");
    }//GEN-LAST:event_ambulance_menuActionPerformed

    private void logout_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_buttonActionPerformed
        dispose();
        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        login.setTitle("Aplikasi Puskesmas");
    }//GEN-LAST:event_logout_buttonActionPerformed

    private void konsult_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konsult_menuActionPerformed
        dispose();
        FormKonsultasi konsult = new FormKonsultasi();
        konsult.setLocationRelativeTo(null);
        konsult.setVisible(true);
        konsult.setTitle("Aplikasi Puskesmas");
    }//GEN-LAST:event_konsult_menuActionPerformed

    private void obat_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obat_menuActionPerformed
        dispose();
        PengambilanObat obat = new PengambilanObat();
        obat.setLocationRelativeTo(null);
        obat.setVisible(true);
        obat.setTitle("Aplikasi Puskesmas");
    }//GEN-LAST:event_obat_menuActionPerformed

    private void payment_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_menuActionPerformed
        dispose();
        DetailPembayaran payment = new DetailPembayaran();
        payment.setLocationRelativeTo(null);
        payment.setVisible(true);
        payment.setTitle("Aplikasi Puskesmas");
    }//GEN-LAST:event_payment_menuActionPerformed

    private void edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_buttonActionPerformed
        dispose();
        EditProfile edit = new EditProfile();
        edit.setLocationRelativeTo(null);
        edit.setVisible(true);
        edit.setTitle("Aplikasi Puskesmas");
    }//GEN-LAST:event_edit_buttonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ambulance_menu;
    private javax.swing.JButton edit_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton konsult_menu;
    private javax.swing.JLabel label_nama;
    private javax.swing.JButton logout_button;
    private javax.swing.JButton obat_menu;
    private javax.swing.JButton payment_menu;
    // End of variables declaration//GEN-END:variables
}
