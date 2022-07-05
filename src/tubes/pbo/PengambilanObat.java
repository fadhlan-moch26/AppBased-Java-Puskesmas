package tubes.pbo;

import java.awt.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class PengambilanObat extends javax.swing.JFrame {
    static final String DB_URL = "jdbc:mysql://localhost:3306/pbo_tubes";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    private int id_pasien;
    ArrayList<Pasien> arr_pasien = new ArrayList<>();
    ArrayList<Keluhan> arr_keluhan = new ArrayList<>();
    ArrayList<Dokter> arr_dokter = new ArrayList<>();
    ArrayList<Obat> arr_obat = new ArrayList<>();
    
    public PengambilanObat() {
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
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        if ( arr_pasien.get(id_pasien-1).getKeluhan_id() != 0 ) {
            int keluhan_id = arr_pasien.get(id_pasien-1).getKeluhan_id();
            int dokter_id = arr_keluhan.get(keluhan_id-1).getDokter_id();
            int idx = 0;
            String[] temp = new String[3];
            for ( int i = 0; i < arr_obat.size(); i++ ) {
                if ( keluhan_id == arr_obat.get(i).getKeluhan_id() ) {
                    temp[idx] = arr_obat.get(i).getNama_obat();
                    idx++;
                }
            }
            list_obat.setListData(temp);
            label_dokter.setText(arr_dokter.get(dokter_id-1).getNama());
            Random r = new Random();
            int random = r.nextInt((3-1)+1)+1;
            label_loket.setText(String.valueOf(random));
            label_keluhan.setText(arr_keluhan.get(keluhan_id-1).getNama_keluhan());
        } else {
            label_dokter.setText("---");
            label_loket.setText("---");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        oke_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_obat = new javax.swing.JList<>();
        label_dokter = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        label_loket = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        label_keluhan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setText("Pengambilan Obat");
        jLabel3.setMaximumSize(new java.awt.Dimension(90, 22));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(60, 60, 60));
        jLabel4.setText("Dokter");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(60, 60, 60));
        jLabel5.setText("Obat: ");

        oke_button.setBackground(new java.awt.Color(0, 153, 153));
        oke_button.setForeground(new java.awt.Color(255, 255, 255));
        oke_button.setText("Oke");
        oke_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oke_buttonActionPerformed(evt);
            }
        });

        list_obat.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Null", "Null", "Null" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(list_obat);

        label_dokter.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label_dokter.setForeground(new java.awt.Color(60, 60, 60));
        label_dokter.setText(" ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(60, 60, 60));
        jLabel7.setText("Loket ");

        label_loket.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label_loket.setForeground(new java.awt.Color(60, 60, 60));
        label_loket.setText("-");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(60, 60, 60));
        jLabel6.setText("Keluhan");

        label_keluhan.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_keluhan)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(oke_button, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(label_dokter))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(label_loket))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(133, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(label_dokter))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(label_keluhan))
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(4, 4, 4)
                .addComponent(label_loket)
                .addGap(30, 30, 30)
                .addComponent(oke_button)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void oke_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oke_buttonActionPerformed
        dispose();
        Home home = new Home();
        home.setLocationRelativeTo(null);
        home.setVisible(true);
        home.setTitle("Aplikasi Puskesmas");
    }//GEN-LAST:event_oke_buttonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PengambilanObat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_dokter;
    private javax.swing.JLabel label_keluhan;
    private javax.swing.JLabel label_loket;
    private javax.swing.JList<String> list_obat;
    private javax.swing.JButton oke_button;
    // End of variables declaration//GEN-END:variables
}
