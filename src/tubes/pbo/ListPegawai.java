package tubes.pbo;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

public class ListPegawai extends javax.swing.JFrame {
    static final String DB_URL = "jdbc:mysql://localhost:3306/pbo_tubes";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    ArrayList<Dokter> arr_dokter = new ArrayList<>();
    ArrayList<Ambulance> arr_ambulance = new ArrayList<>();
    
    public ListPegawai() {
        initComponents();
        getContentPane().setBackground(new Color(0,0,0));
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM dokter";
            rs = stmt.executeQuery(sql);
            while ( rs.next() ) {
                arr_dokter.add(new Dokter(rs.getInt("id"), rs.getString("jenis_dokter"), rs.getString("nama")));
            }sql = "SELECT * FROM ambulance";
            rs = stmt.executeQuery(sql); 
            while ( rs.next() ) {
                arr_ambulance.add(new Ambulance(rs.getInt("id"), rs.getInt("pasien_id"), rs.getDate("tgl_pemesanan"), rs.getString("alamat")));
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        } String[] temp = new String[(arr_dokter.size()+1)];
        
        temp[0] = arr_ambulance.get(0).getNama();
        for ( int i = 1; i < arr_dokter.size(); i++ ){
            temp[i] = arr_dokter.get(i-1).getNama();
        }
        list_pegawai.setListData(temp);
        list_pegawai.addListSelectionListener((e) -> {
            if ( list_pegawai.getSelectedIndex() == 0 ) {
                label_nama.setText(arr_ambulance.get(0).getNama());
                label_pekerjaan.setText(arr_ambulance.get(0).getKategori());
            } else {
                String nama = arr_dokter.get(list_pegawai.getSelectedIndex()-1).getNama();
                String jenis_dokter = arr_dokter.get(list_pegawai.getSelectedIndex()-1).getJenis_dokter();
                label_nama.setText(nama);
                label_pekerjaan.setText(jenis_dokter); 
            }
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
        list_pegawai = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        label_nama = new javax.swing.JLabel();
        label_pekerjaan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(60, 60, 60));
        jLabel3.setText("List Pegawai");
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

        jScrollPane1.setViewportView(list_pegawai);

        jLabel4.setText("Nama");

        jLabel5.setText("Jenis Pekerjaan");

        label_nama.setText("---");

        label_pekerjaan.setText("---");

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tutup_button, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_pekerjaan)
                            .addComponent(label_nama))))
                .addContainerGap(231, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(label_nama))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(label_pekerjaan)))
                .addGap(26, 26, 26)
                .addComponent(tutup_button)
                .addGap(30, 30, 30))
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
                new ListPegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_nama;
    private javax.swing.JLabel label_pekerjaan;
    private javax.swing.JList<String> list_pegawai;
    private javax.swing.JButton tutup_button;
    // End of variables declaration//GEN-END:variables
}
