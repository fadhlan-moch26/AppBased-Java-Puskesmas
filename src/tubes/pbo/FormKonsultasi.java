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

public class FormKonsultasi extends javax.swing.JFrame {
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
    ArrayList<RuangInap> arr_ruang = new ArrayList<>();
    
    public FormKonsultasi() {
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
            } sql = "SELECT * FROM ruang_inap";
            rs = stmt.executeQuery(sql);
            while ( rs.next() ) {
                arr_ruang.add(new RuangInap(rs.getInt("id"), rs.getString("no_ruang"), rs.getInt("pasien_id")));
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        verif_dialog = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        simpan_button = new javax.swing.JButton();
        batal_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        submit_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        drUmum_rdbutton = new javax.swing.JRadioButton();
        drGigi_rdbutton = new javax.swing.JRadioButton();
        bidan_rdbutton = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_keluhan = new javax.swing.JList<>();
        ruanginap_cBox = new javax.swing.JCheckBox();

        verif_dialog.setMinimumSize(new java.awt.Dimension(400, 138));
        verif_dialog.setResizable(false);
        verif_dialog.setSize(new java.awt.Dimension(400, 138));

        jPanel2.setMinimumSize(new java.awt.Dimension(260, 140));
        jPanel2.setPreferredSize(new java.awt.Dimension(260, 140));

        simpan_button.setBackground(new java.awt.Color(0, 153, 153));
        simpan_button.setForeground(new java.awt.Color(255, 255, 255));
        simpan_button.setText("Simpan");
        simpan_button.setPreferredSize(new java.awt.Dimension(77, 25));
        simpan_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpan_buttonActionPerformed(evt);
            }
        });

        batal_button.setBackground(new java.awt.Color(255, 255, 255));
        batal_button.setForeground(new java.awt.Color(0, 153, 153));
        batal_button.setText("Batal");
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
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(simpan_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(batal_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batal_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout verif_dialogLayout = new javax.swing.GroupLayout(verif_dialog.getContentPane());
        verif_dialog.getContentPane().setLayout(verif_dialogLayout);
        verif_dialogLayout.setHorizontalGroup(
            verif_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        verif_dialogLayout.setVerticalGroup(
            verif_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(60, 60, 60));
        jLabel3.setText("Pemesanan Konsultasi");
        jLabel3.setMaximumSize(new java.awt.Dimension(90, 22));

        submit_button.setBackground(new java.awt.Color(0, 153, 153));
        submit_button.setForeground(new java.awt.Color(255, 255, 255));
        submit_button.setText("Submit");
        submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_buttonActionPerformed(evt);
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

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(60, 60, 60));
        jLabel8.setText("Jenis Dokter");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(60, 60, 60));
        jLabel9.setText("Keluhan");

        buttonGroup1.add(drUmum_rdbutton);
        drUmum_rdbutton.setText("Dokter Umum");
        drUmum_rdbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drUmum_rdbuttonActionPerformed(evt);
            }
        });

        buttonGroup1.add(drGigi_rdbutton);
        drGigi_rdbutton.setText("Dokter Gigi");
        drGigi_rdbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drGigi_rdbuttonActionPerformed(evt);
            }
        });

        buttonGroup1.add(bidan_rdbutton);
        bidan_rdbutton.setText("Bidan");
        bidan_rdbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bidan_rdbuttonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(list_keluhan);

        ruanginap_cBox.setText("Pesan ruang inap");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ruanginap_cBox)
                    .addComponent(drUmum_rdbutton)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8)
                    .addComponent(drGigi_rdbutton)
                    .addComponent(bidan_rdbutton)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submit_button))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(drUmum_rdbutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(drGigi_rdbutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bidan_rdbutton)
                .addGap(25, 25, 25)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ruanginap_cBox)
                .addGap(18, 18, 18)
                .addComponent(submit_button)
                .addContainerGap(30, Short.MAX_VALUE))
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
        if ( drGigi_rdbutton.isSelected() || drUmum_rdbutton.isSelected() || bidan_rdbutton.isSelected() ) {
            if ( list_keluhan.isSelectionEmpty()) {
                JOptionPane optionPane = new JOptionPane(new JLabel("Harap memilih jenis keluhan",JLabel.CENTER));
                JDialog dialog = optionPane.createDialog("");
                dialog.setSize(400, 130);
                dialog.setLocationRelativeTo(null);
                dialog.setModal(true);
                dialog.setVisible(true);
            } else {
                if ( ruanginap_cBox.isSelected() ) {
                    boolean penuh = true;
                    for ( int i = 0; i < arr_ruang.size(); i++ ) {
                        if ( arr_ruang.get(i).getPasien_id() == 0 ) {
                            penuh = false;
                            break;
                        }
                    }
                    if ( penuh == true ) {
                        JOptionPane optionPane = new JOptionPane(new JLabel("Ruang Inap penuh",JLabel.CENTER));
                        JDialog dialog = optionPane.createDialog("");
                        dialog.setSize(400, 130);
                        dialog.setLocationRelativeTo(null);
                        dialog.setModal(true);
                        dialog.setVisible(true);
                    } else {
                        verif_dialog.setLocationRelativeTo(null);
                        verif_dialog.setModal(true);
                        verif_dialog.setVisible(true);
                    }
                } else {
                    verif_dialog.setLocationRelativeTo(null);
                    verif_dialog.setModal(true);
                    verif_dialog.setVisible(true);
                }
            }
        } else {
            JOptionPane optionPane = new JOptionPane(new JLabel("Harap memilih jenis konsultasi",JLabel.CENTER));
            JDialog dialog = optionPane.createDialog("");
            dialog.setSize(400, 130);
            dialog.setLocationRelativeTo(null);
            dialog.setModal(true);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_submit_buttonActionPerformed

    private void simpan_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpan_buttonActionPerformed
        verif_dialog.dispose();
        dispose();
        int keluhan_id;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();
            if ( drUmum_rdbutton.isSelected() ){
                keluhan_id = arr_keluhan.get(list_keluhan.getSelectedIndex()).getId();
            } else if ( drGigi_rdbutton.isSelected() ) {
                keluhan_id = arr_keluhan.get(list_keluhan.getSelectedIndex()+5).getId();
            } else {
                keluhan_id = arr_keluhan.get(list_keluhan.getSelectedIndex()+8).getId();
            }
            String sql = "UPDATE pasien "+"SET keluhan_id ="+keluhan_id+" WHERE id = "+id_pasien;
            stmt.executeUpdate(sql);
            if ( ruanginap_cBox.isSelected() ) {
                for ( int i = 0; i < arr_ruang.size(); i++ ) {
                    if ( arr_ruang.get(i).getPasien_id() == 0 ) {
                        sql = "UPDATE ruang_inap "+"SET pasien_id ="+id_pasien+" WHERE id = "+(i+1);
                        stmt.executeUpdate(sql);
                        break;
                    }
                }
            }
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
        home.setTitle("Aplikasi Puskesmas");
    }//GEN-LAST:event_simpan_buttonActionPerformed

    private void batal_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batal_buttonActionPerformed
        verif_dialog.dispose();
    }//GEN-LAST:event_batal_buttonActionPerformed

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        dispose();
        Home home = new Home();
        home.setLocationRelativeTo(null);
        home.setVisible(true);
        home.setTitle("Aplikasi Puskesmas");
    }//GEN-LAST:event_back_buttonActionPerformed

    private void drUmum_rdbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drUmum_rdbuttonActionPerformed
        String temp[] = new String[5];
        for ( int i = 0; i < 5; i++ ) {
            temp[i] = arr_keluhan.get(i).getNama_keluhan();
        }
        list_keluhan.setListData(temp);
    }//GEN-LAST:event_drUmum_rdbuttonActionPerformed

    private void drGigi_rdbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drGigi_rdbuttonActionPerformed
        String temp[] = new String[3];
        for ( int i = 5; i < 8; i++ ) {
            temp[i-5] = arr_keluhan.get(i).getNama_keluhan();
        }
        list_keluhan.setListData(temp);
    }//GEN-LAST:event_drGigi_rdbuttonActionPerformed

    private void bidan_rdbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bidan_rdbuttonActionPerformed
        String temp[] = new String[2];
        for ( int i = 8; i < 10; i++ ) {
            temp[i-8] = arr_keluhan.get(i).getNama_keluhan();
        }
        list_keluhan.setListData(temp);
    }//GEN-LAST:event_bidan_rdbuttonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormKonsultasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JButton batal_button;
    private javax.swing.JRadioButton bidan_rdbutton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton drGigi_rdbutton;
    private javax.swing.JRadioButton drUmum_rdbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> list_keluhan;
    private javax.swing.JCheckBox ruanginap_cBox;
    private javax.swing.JButton simpan_button;
    private javax.swing.JButton submit_button;
    private javax.swing.JDialog verif_dialog;
    // End of variables declaration//GEN-END:variables
}
