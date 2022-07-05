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

public class DetailPembayaran extends javax.swing.JFrame {
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
    ArrayList<Ambulance> arr_ambulance = new ArrayList<>();
    ArrayList<RuangInap> arr_ruang = new ArrayList<>();
    
    public DetailPembayaran() {
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
        }
        int jumlah = 0, idx_row = 0;
        if ( arr_pasien.get(id_pasien-1).getKeluhan_id() != 0 ){
            int keluhan_id = arr_pasien.get(id_pasien-1).getKeluhan_id();
            int dokter_id = arr_keluhan.get(keluhan_id-1).getDokter_id();
            table_data.setValueAt(arr_dokter.get(dokter_id-1).getJenis_dokter(), 0, 0);
            table_data.setValueAt(arr_dokter.get(dokter_id-1).hitungfee(), 0, 1);
            idx_row++;
            jumlah = jumlah + arr_dokter.get(dokter_id-1).hitungfee();
            for ( int i = 0; i < arr_obat.size(); i++ ) {
                if ( keluhan_id == arr_obat.get(i).getKeluhan_id() ) {
                    table_data.setValueAt(arr_obat.get(i).getNama_obat(), idx_row, 0);
                    table_data.setValueAt(arr_obat.get(i).getHarga(), idx_row, 1);
                    jumlah = jumlah + arr_obat.get(i).getHarga();
                    idx_row++;
                }
            } for ( int  i = 0; i < arr_ruang.size(); i++ ) {
                if ( arr_ruang.get(i).getPasien_id() == id_pasien ) {
                    table_data.setValueAt(arr_ruang.get(i).getNo_ruang(), idx_row, 0);
                    table_data.setValueAt(arr_ruang.get(i).hitungfee(), idx_row, 1);
                    jumlah = jumlah + arr_ruang.get(i).hitungfee();
                    idx_row++;
                }
            }
        } for ( int i = 0; i < arr_ambulance.size(); i++  ) {
            if ( arr_ambulance.get(i).getPasien_di() == id_pasien ) {
                table_data.setValueAt("Ambulance", idx_row, 0);
                table_data.setValueAt(arr_ambulance.get(i).hitungfee(), idx_row, 1);
                jumlah = jumlah + arr_ambulance.get(i).hitungfee();
            }
        }
        label_jumlah.setText("Rp "+String.valueOf(jumlah));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        oke_button = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_data = new javax.swing.JTable();
        label_jumlah = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setText("Detail Pembayaran");
        jLabel3.setMaximumSize(new java.awt.Dimension(90, 22));

        oke_button.setBackground(new java.awt.Color(0, 153, 153));
        oke_button.setForeground(new java.awt.Color(255, 255, 255));
        oke_button.setText("Oke");
        oke_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oke_buttonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(60, 60, 60));
        jLabel7.setText("Total tagihan");

        table_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Subjek", "Tagihan"
            }
        ));
        jScrollPane3.setViewportView(table_data);

        label_jumlah.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oke_button, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_jumlah))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(label_jumlah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(oke_button)
                .addGap(32, 32, 32))
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
        home.setTitle("TUBES GUYS");
    }//GEN-LAST:event_oke_buttonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailPembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_jumlah;
    private javax.swing.JButton oke_button;
    private javax.swing.JTable table_data;
    // End of variables declaration//GEN-END:variables
}
