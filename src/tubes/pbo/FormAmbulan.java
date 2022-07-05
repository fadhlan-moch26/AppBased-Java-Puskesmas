package tubes.pbo;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import static tubes.pbo.Register.conn;

public class FormAmbulan extends javax.swing.JFrame {
    static final String DB_URL = "jdbc:mysql://localhost:3306/pbo_tubes";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    private int id_pasien;
    ArrayList<Pasien> arr_pasien = new ArrayList<>();
    ArrayList<Ambulance> arr_ambulance = new ArrayList<>();
    
    public FormAmbulan() {
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
            sql = "SELECT * FROM ambulance";
            rs = stmt.executeQuery(sql);
            while ( rs.next() ) {
                arr_ambulance.add(new Ambulance(rs.getInt("id"), rs.getInt("pasien_id"), rs.getDate("tgl_pemesanan"), rs.getString("alamat")));
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        verif_dialog = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        simpan_button = new javax.swing.JButton();
        batal_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        submit_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tgl_cbox = new javax.swing.JComboBox<>();
        bulan_cbox = new javax.swing.JComboBox<>();
        tahun_cbox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        alamat_textarea = new javax.swing.JTextArea();
        check_button = new javax.swing.JButton();
        label_tersedia = new javax.swing.JLabel();

        verif_dialog.setMinimumSize(new java.awt.Dimension(400, 130));
        verif_dialog.setSize(new java.awt.Dimension(400, 130));

        jPanel2.setMinimumSize(new java.awt.Dimension(260, 140));
        jPanel2.setPreferredSize(new java.awt.Dimension(260, 140));

        simpan_button.setBackground(new java.awt.Color(0, 153, 153));
        simpan_button.setForeground(new java.awt.Color(255, 255, 255));
        simpan_button.setText("Simpan");
        simpan_button.setMaximumSize(new java.awt.Dimension(77, 25));
        simpan_button.setPreferredSize(new java.awt.Dimension(77, 25));
        simpan_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpan_buttonActionPerformed(evt);
            }
        });

        batal_button.setBackground(new java.awt.Color(255, 255, 255));
        batal_button.setForeground(new java.awt.Color(0, 153, 153));
        batal_button.setText("Batal");
        batal_button.setMaximumSize(new java.awt.Dimension(77, 25));
        batal_button.setPreferredSize(new java.awt.Dimension(77, 25));
        batal_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batal_buttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Apakah data sudah benar ?");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(simpan_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(batal_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batal_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout verif_dialogLayout = new javax.swing.GroupLayout(verif_dialog.getContentPane());
        verif_dialog.getContentPane().setLayout(verif_dialogLayout);
        verif_dialogLayout.setHorizontalGroup(
            verif_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verif_dialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        verif_dialogLayout.setVerticalGroup(
            verif_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verif_dialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(60, 60, 60));
        jLabel3.setText("Pemesanan Ambulan");
        jLabel3.setMaximumSize(new java.awt.Dimension(90, 22));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(60, 60, 60));
        jLabel4.setText("Tersedia");

        submit_button.setBackground(new java.awt.Color(0, 153, 153));
        submit_button.setForeground(new java.awt.Color(255, 255, 255));
        submit_button.setText("Submit");
        submit_button.setMaximumSize(new java.awt.Dimension(80, 23));
        submit_button.setMinimumSize(new java.awt.Dimension(80, 23));
        submit_button.setPreferredSize(new java.awt.Dimension(80, 23));
        submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_buttonActionPerformed(evt);
            }
        });

        back_button.setBackground(new java.awt.Color(255, 255, 255));
        back_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/img/arrow_back.png"))); // NOI18N
        back_button.setToolTipText("");
        back_button.setBorderPainted(false);
        back_button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        back_button.setPreferredSize(new java.awt.Dimension(24, 24));
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(60, 60, 60));
        jLabel8.setText("Tanggal Pemesanan");

        tgl_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        bulan_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));

        tahun_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(60, 60, 60));
        jLabel9.setText("Alamat");

        alamat_textarea.setBackground(new java.awt.Color(240, 240, 240));
        alamat_textarea.setColumns(20);
        alamat_textarea.setForeground(new java.awt.Color(100, 100, 100));
        alamat_textarea.setRows(5);
        jScrollPane2.setViewportView(alamat_textarea);

        check_button.setText("Check");
        check_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_buttonActionPerformed(evt);
            }
        });

        label_tersedia.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tgl_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bulan_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tahun_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(label_tersedia)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(check_button))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(submit_button, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tgl_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bulan_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tahun_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(check_button)
                    .addComponent(label_tersedia))
                .addGap(13, 13, 13)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submit_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
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

    private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_buttonActionPerformed
        if ( alamat_textarea.getText().length() == 0 ) {
            JOptionPane optionPane = new JOptionPane(new JLabel("Harap isi alamat",JLabel.CENTER));
            JDialog dialog = optionPane.createDialog("");
            dialog.setSize(400, 130);
            dialog.setLocationRelativeTo(null);
            dialog.setModal(true);
            dialog.setVisible(true);
        } else {
            if ( label_tersedia.getText().matches("Tidak")) {
                JOptionPane optionPane = new JOptionPane(new JLabel("Maaf ambulance pada tanggal tersebut tidak tersedia",JLabel.CENTER));
                JDialog dialog = optionPane.createDialog("");
                dialog.setSize(400, 130);
                dialog.setLocationRelativeTo(null);
                dialog.setModal(true);
                dialog.setVisible(true);
            } else if (label_tersedia.getText().matches("Iya") ){
                boolean door = true;
                String temp;
                if ( bulan_cbox.getSelectedIndex() < 9 ) {
                temp = tahun_cbox.getSelectedItem()+"-0"+(bulan_cbox.getSelectedIndex()+1)+"-"+tgl_cbox.getSelectedItem();
                } else {
                    temp = tahun_cbox.getSelectedItem()+"-"+(bulan_cbox.getSelectedIndex()+1)+"-"+tgl_cbox.getSelectedItem();
                }
                Date tgl_pemesanan = Date.valueOf(temp);
                for ( int i = 0; i < arr_ambulance.size(); i++ ) {
                    if ( tgl_pemesanan.equals(arr_ambulance.get(i).getTgl_pemesanan())){
                        JOptionPane optionPane = new JOptionPane(new JLabel("Harap Melakukan Checking Tanggal Pemesanan",JLabel.CENTER));
                        JDialog dialog = optionPane.createDialog("");
                        dialog.setSize(400, 130);
                        dialog.setLocationRelativeTo(null);
                        dialog.setModal(true);
                        dialog.setVisible(true);
                        door = false;
                        break;
                    }
                }
                if ( door == true ) {
                    verif_dialog.setLocationRelativeTo(null);
                    verif_dialog.setModal(true);
                    verif_dialog.setVisible(true);
                }
            } else {
                JOptionPane optionPane = new JOptionPane(new JLabel("Harap Melakukan Check Tanggal Terlebih Dahulu",JLabel.CENTER));
                JDialog dialog = optionPane.createDialog("");
                dialog.setSize(400, 130);
                dialog.setLocationRelativeTo(null);
                dialog.setModal(true);
                dialog.setVisible(true);
            }
        }
    }//GEN-LAST:event_submit_buttonActionPerformed

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        dispose();
        Home home = new Home();
        home.setLocationRelativeTo(null);
        home.setVisible(true);
        home.setTitle("Aplikasi Puskesmas");
    }//GEN-LAST:event_back_buttonActionPerformed

    private void simpan_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpan_buttonActionPerformed
        verif_dialog.dispose();
        dispose();
        String temp;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();
            int id = arr_ambulance.size()+1;
            String alamat = alamat_textarea.getText();
            if ( bulan_cbox.getSelectedIndex() < 9 ) {
                temp = tahun_cbox.getSelectedItem()+"-0"+(bulan_cbox.getSelectedIndex()+1)+"-"+tgl_cbox.getSelectedItem();
            } else {
                temp = tahun_cbox.getSelectedItem()+"-"+(bulan_cbox.getSelectedIndex()+1)+"-"+tgl_cbox.getSelectedItem();
            }
            Date tgl_pemesanan = Date.valueOf(temp);
            String sql = "INSERT INTO ambulance VALUES('"+id+"','"+id_pasien+"','"+tgl_pemesanan+"','"+alamat+"')";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            JOptionPane optionPane = new JOptionPane(new JLabel("Data berhasil tersimpan",JLabel.CENTER));
            JDialog dialog = optionPane.createDialog("");
            dialog.setSize(400, 130);
            dialog.setLocationRelativeTo(null);
            dialog.setModal(true);
            dialog.setVisible(true);
        } catch (Exception e) {
           e.printStackTrace();
        }
        Home home = new Home();
        home.setLocationRelativeTo(null);
        home.setVisible(true);
        home.setTitle("TUBES GUYS");
    }//GEN-LAST:event_simpan_buttonActionPerformed

    private void batal_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batal_buttonActionPerformed
        verif_dialog.dispose();
    }//GEN-LAST:event_batal_buttonActionPerformed

    private void check_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_buttonActionPerformed
        String temp;
        if ( bulan_cbox.getSelectedIndex() < 9 ) {
            temp = tahun_cbox.getSelectedItem()+"-0"+(bulan_cbox.getSelectedIndex()+1)+"-"+tgl_cbox.getSelectedItem();
        } else {
            temp = tahun_cbox.getSelectedItem()+"-"+(bulan_cbox.getSelectedIndex()+1)+"-"+tgl_cbox.getSelectedItem();
        }
        Date tgl_pemesanan = Date.valueOf(temp);
        for ( int i = 0 ; i < arr_ambulance.size(); i++ ) {
            if ( arr_ambulance.get(i).getTgl_pemesanan().equals(tgl_pemesanan) ) {
                label_tersedia.setText("Tidak");
                break;
            } else {
                label_tersedia.setText("Iya");
            }
        }
    }//GEN-LAST:event_check_buttonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAmbulan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat_textarea;
    private javax.swing.JButton back_button;
    private javax.swing.JButton batal_button;
    private javax.swing.JComboBox<String> bulan_cbox;
    private javax.swing.JButton check_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_tersedia;
    private javax.swing.JButton simpan_button;
    private javax.swing.JButton submit_button;
    private javax.swing.JComboBox<String> tahun_cbox;
    private javax.swing.JComboBox<String> tgl_cbox;
    private javax.swing.JDialog verif_dialog;
    // End of variables declaration//GEN-END:variables
}
