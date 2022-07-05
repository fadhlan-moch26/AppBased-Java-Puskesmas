package tubes.pbo;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class RiwayatKonsultasi extends javax.swing.JFrame {
    static final String DB_URL = "jdbc:mysql://localhost:3306/pbo_tubes";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    ArrayList<Pasien> arr_pasien = new ArrayList<>();
    ArrayList<Keluhan> arr_keluhan = new ArrayList<>();
    ArrayList<Dokter> arr_dokter = new ArrayList<>();
    ArrayList<Obat> arr_obat = new ArrayList<>();
    ArrayList<Ambulance> arr_ambulance = new ArrayList<>();
    ArrayList<RuangInap> arr_ruang = new ArrayList<>();
    
    public RiwayatKonsultasi() {
        initComponents();
        getContentPane().setBackground(new Color(0,0,0));
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM pasien";
            rs = stmt.executeQuery(sql);
            while ( rs.next() ) {
                arr_pasien.add(new Pasien(rs.getInt("id"), rs.getString("nama"), rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getDate("tgl_lahir"), rs.getString("alamat"), rs.getInt("keluhan_id")));
            } sql = "SELECT * FROM dokter";
            rs = stmt.executeQuery(sql);
            while ( rs.next() ) {
                arr_dokter.add(new Dokter(rs.getInt("id"), rs.getString("jenis_dokter"), rs.getString("nama")));
            } sql = "SELECT * FROM keluhan";
            rs = stmt.executeQuery(sql);
            while ( rs.next() ) {
                arr_keluhan.add(new Keluhan(rs.getInt("id"), rs.getString("nama_keluhan"), rs.getInt("dokter_id")));
            } sql = "SELECT * FROM obat";
            rs = stmt.executeQuery(sql);
            while ( rs.next() ) {
                arr_obat.add(new Obat(rs.getInt("id"), rs.getString("nama_obat"), rs.getInt("keluhan_id"), rs.getInt("harga")));
            } sql = "SELECT * FROM ambulance";
            rs = stmt.executeQuery(sql);
            while ( rs.next() ) {
                arr_ambulance.add(new Ambulance(rs.getInt("id"), rs.getInt("pasien_id"), rs.getDate("tgl_pemesanan"), rs.getString("alamat")));
            } sql = "SELECT * FROM ruang_inap";
            rs = stmt.executeQuery(sql);
            while ( rs.next() ) {
                arr_ruang.add(new RuangInap(rs.getInt("id"), rs.getString("no_ruang"), rs.getInt("pasien_id")));
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        } String[] temp = new String[arr_pasien.size()];
        for ( int i = 0; i < arr_pasien.size(); i++ ){
            temp[i] = arr_pasien.get(i).getNama();
        }
        list_pasien.setListData(temp);
        list_pasien.addListSelectionListener((e) -> {
            String nama = arr_pasien.get(list_pasien.getSelectedIndex()).getNama();
            String dokter = "---";
            String keluhan = "---";
            label_obat1.setText("---");
            label_obat2.setText(" ");
            label_obat3.setText(" ");
            int jumlah = 0;
            if ( arr_pasien.get(list_pasien.getSelectedIndex()).getKeluhan_id() != 0 ){
                int keluhan_id = arr_pasien.get(list_pasien.getSelectedIndex()).getKeluhan_id();
                int dokter_id = arr_keluhan.get(keluhan_id-1).getDokter_id();
                dokter = arr_dokter.get(dokter_id-1).getNama();
                keluhan = arr_keluhan.get(keluhan_id-1).getNama_keluhan();
                jumlah = jumlah + arr_dokter.get(dokter_id-1).hitungfee();
                int idx = 0;
                for ( int i = 0; i < arr_obat.size(); i++ ) {
                    if ( keluhan_id == arr_obat.get(i).getKeluhan_id() ) {
                        jumlah = jumlah + arr_obat.get(i).getHarga();
                        if ( idx == 0 ) {
                            label_obat1.setText(arr_obat.get(i).getNama_obat());
                            idx++;
                        } else if ( idx == 1 ) {
                            label_obat2.setText(arr_obat.get(i).getNama_obat());
                            idx++;
                        } else {
                            label_obat3.setText(arr_obat.get(i).getNama_obat());
                            idx++;
                        }
                    }
                } for ( int  i = 0; i < arr_ruang.size(); i++ ) {
                    if ( arr_ruang.get(i).getPasien_id() == arr_pasien.get(list_pasien.getSelectedIndex()).getId() ) {
                        jumlah = jumlah + arr_ruang.get(i).hitungfee();
                    }
                }
            } for ( int i = 0; i < arr_ambulance.size(); i++  ) {
                if ( arr_ambulance.get(i).getPasien_di() == arr_pasien.get(list_pasien.getSelectedIndex()).getId() ) {
                    jumlah = jumlah + arr_ambulance.get(i).hitungfee();
                    label_ambulance.setText("Memesan Ambulance");
                    break;
                } else {
                    label_ambulance.setText("Tidak Memesan Ambulance");
                }
            }
            label_dokter.setText(dokter);
            label_nama.setText(nama);
            label_keluhan.setText(keluhan);
            label_tagihan.setText("Rp "+Integer.toString(jumlah));
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        close_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_pasien = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        label_ambulance = new javax.swing.JLabel();
        label_tagihan = new javax.swing.JLabel();
        label_dokter = new javax.swing.JLabel();
        label_keluhan = new javax.swing.JLabel();
        label_nama = new javax.swing.JLabel();
        label_obat1 = new javax.swing.JLabel();
        label_obat2 = new javax.swing.JLabel();
        label_obat3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(60, 60, 60));
        jLabel3.setText("Riwayat Konsultasi");
        jLabel3.setMaximumSize(new java.awt.Dimension(90, 22));

        close_button.setBackground(new java.awt.Color(0, 153, 153));
        close_button.setForeground(new java.awt.Color(255, 255, 255));
        close_button.setText("Tutup");
        close_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_buttonActionPerformed(evt);
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

        jLabel4.setText("Nama");

        jLabel5.setText("Keluhan");

        jLabel8.setText("Dokter");

        jLabel12.setText("Obat");

        label_ambulance.setText(" ");

        label_tagihan.setText("---");

        label_dokter.setText("---");

        label_keluhan.setText("---");

        label_nama.setText("---");

        label_obat1.setText("---");

        label_obat2.setText(" ");

        label_obat3.setText(" ");

        jLabel15.setText("Total Tagihan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(close_button, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_obat3)
                            .addComponent(label_obat2)
                            .addComponent(label_nama)
                            .addComponent(label_keluhan)
                            .addComponent(label_dokter)
                            .addComponent(label_obat1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(label_ambulance))
                        .addGap(18, 18, 18)
                        .addComponent(label_tagihan)))
                .addGap(240, 240, 240))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(label_nama))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(label_keluhan))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(label_dokter))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(label_obat1))
                        .addGap(6, 6, 6)
                        .addComponent(label_obat2)
                        .addGap(4, 4, 4)
                        .addComponent(label_obat3)
                        .addGap(12, 12, 12)
                        .addComponent(label_ambulance)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(label_tagihan)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(close_button)
                .addGap(12, 12, 12))
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

    private void close_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_buttonActionPerformed
        dispose();
        HomeAdmin hAdmin = new HomeAdmin();
        hAdmin.setLocationRelativeTo(null);;
        hAdmin.setTitle("Aplikasi Puskesmas");
        hAdmin.setVisible(true);
    }//GEN-LAST:event_close_buttonActionPerformed

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        dispose();
        HomeAdmin hAdmin = new HomeAdmin();
        hAdmin.setLocationRelativeTo(null);;
        hAdmin.setTitle("Aplikasi Puskesmas");
        hAdmin.setVisible(true);
    }//GEN-LAST:event_back_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(RiwayatKonsultasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RiwayatKonsultasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RiwayatKonsultasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RiwayatKonsultasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RiwayatKonsultasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JButton close_button;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_ambulance;
    private javax.swing.JLabel label_dokter;
    private javax.swing.JLabel label_keluhan;
    private javax.swing.JLabel label_nama;
    private javax.swing.JLabel label_obat1;
    private javax.swing.JLabel label_obat2;
    private javax.swing.JLabel label_obat3;
    private javax.swing.JLabel label_tagihan;
    private javax.swing.JList<String> list_pasien;
    // End of variables declaration//GEN-END:variables
}
