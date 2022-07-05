package tubes.pbo;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

public class ListPasien extends javax.swing.JFrame {
    static final String DB_URL = "jdbc:mysql://localhost:3306/pbo_tubes";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    ArrayList<Pasien> arr_pasien = new ArrayList<>();
    
    public ListPasien() {
        initComponents();
        getContentPane().setBackground(new Color(0,0,0));
        try {
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
        String[] temp = new String[arr_pasien.size()];
        for ( int i = 0; i < arr_pasien.size(); i++ ){
            temp[i] = arr_pasien.get(i).getNama();
        }
        list_pasien.setListData(temp);
        list_pasien.addListSelectionListener((e) -> {
            String nama = arr_pasien.get(list_pasien.getSelectedIndex()).getNama();
            String email = arr_pasien.get(list_pasien.getSelectedIndex()).getEmail();
            String alamat = arr_pasien.get(list_pasien.getSelectedIndex()).getAlamat();
            String tgl_lahir = String.valueOf(arr_pasien.get(list_pasien.getSelectedIndex()).getTgl_lahir());
            label_nama.setText(nama);
            label_alamat.setText(alamat);
            label_email.setText(email);
            label_tglLahir.setText(tgl_lahir);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tutup_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_pasien = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        label_nama = new javax.swing.JLabel();
        label_email = new javax.swing.JLabel();
        label_tglLahir = new javax.swing.JLabel();
        label_alamat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(60, 60, 60));
        jLabel3.setText("List Pasien");
        jLabel3.setMaximumSize(new java.awt.Dimension(90, 22));

        tutup_button.setBackground(new java.awt.Color(0, 153, 153));
        tutup_button.setForeground(new java.awt.Color(255, 255, 255));
        tutup_button.setText("Tutup");
        tutup_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutup_buttonActionPerformed(evt);
            }
        });

        back_button.setBackground(new java.awt.Color(255, 255, 255));
        back_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/img/arrow_back.png"))); // NOI18N
        back_button.setBorderPainted(false);
        back_button.setMargin(new java.awt.Insets(2, 2, 2, 2));
        back_button.setPreferredSize(new java.awt.Dimension(24, 24));
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(list_pasien);

        jLabel4.setText("Nama Pasien ");

        jLabel5.setText("Email");

        jLabel6.setText("Tanggal Lahir");

        jLabel7.setText("Alamat");

        label_nama.setText("---");

        label_email.setText("---");

        label_tglLahir.setText("---");

        label_alamat.setText("---");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tutup_button, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(24, 24, 24)
                        .addComponent(label_nama))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_alamat)
                            .addComponent(label_email)
                            .addComponent(label_tglLahir))))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(label_nama))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(label_email))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(label_tglLahir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(label_alamat))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tutup_button)
                .addContainerGap())
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

    private void tutup_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutup_buttonActionPerformed
        dispose();
        HomeAdmin hAdmin = new HomeAdmin();
        hAdmin.setLocationRelativeTo(null);;
        hAdmin.setTitle("Aplikasi Puskesmas");
        hAdmin.setVisible(true);
    }//GEN-LAST:event_tutup_buttonActionPerformed

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        dispose();
        HomeAdmin hAdmin = new HomeAdmin();
        hAdmin.setLocationRelativeTo(null);;
        hAdmin.setTitle("Aplikasi Puskesmas");
        hAdmin.setVisible(true);
    }//GEN-LAST:event_back_buttonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListPasien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_alamat;
    private javax.swing.JLabel label_email;
    private javax.swing.JLabel label_nama;
    private javax.swing.JLabel label_tglLahir;
    private javax.swing.JList<String> list_pasien;
    private javax.swing.JButton tutup_button;
    // End of variables declaration//GEN-END:variables
}
