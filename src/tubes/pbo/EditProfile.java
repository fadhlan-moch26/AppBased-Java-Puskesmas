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
import java.sql.Date;

public class EditProfile extends javax.swing.JFrame {
    static final String DB_URL = "jdbc:mysql://localhost:3306/pbo_tubes";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    ArrayList<Pasien> arr_pasien = new ArrayList<>();
    private int id_pasien;
    
    public EditProfile() {
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
        username_field = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        register_button = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        name_field = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        email_field = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        alamat_textarea = new javax.swing.JTextArea();
        tgl_cbox = new javax.swing.JComboBox<>();
        bulan_cbox = new javax.swing.JComboBox<>();
        tahun_cbox = new javax.swing.JComboBox<>();
        back_button = new javax.swing.JButton();
        password_field = new javax.swing.JPasswordField();

        verif_dialog.setMinimumSize(new java.awt.Dimension(400, 130));
        verif_dialog.setSize(new java.awt.Dimension(400, 130));

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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(simpan_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(batal_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        verif_dialogLayout.setVerticalGroup(
            verif_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verif_dialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(60, 60, 60));
        jLabel3.setText("Edit Profile");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(60, 60, 60));
        jLabel4.setText("Username");

        username_field.setBackground(new java.awt.Color(240, 240, 240));
        username_field.setForeground(new java.awt.Color(100, 100, 100));
        username_field.setToolTipText("");
        username_field.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 4, true));
        username_field.setCaretColor(new java.awt.Color(240, 240, 240));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(60, 60, 60));
        jLabel5.setText("Password");

        register_button.setBackground(new java.awt.Color(0, 153, 153));
        register_button.setForeground(new java.awt.Color(255, 255, 255));
        register_button.setText("Simpan");
        register_button.setMaximumSize(new java.awt.Dimension(80, 23));
        register_button.setMinimumSize(new java.awt.Dimension(80, 23));
        register_button.setPreferredSize(new java.awt.Dimension(80, 23));
        register_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_buttonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(60, 60, 60));
        jLabel6.setText("Nama Lengkap");

        name_field.setBackground(new java.awt.Color(240, 240, 240));
        name_field.setForeground(new java.awt.Color(100, 100, 100));
        name_field.setToolTipText("");
        name_field.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 4, true));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(60, 60, 60));
        jLabel7.setText("Email");

        email_field.setBackground(new java.awt.Color(240, 240, 240));
        email_field.setForeground(new java.awt.Color(100, 100, 100));
        email_field.setToolTipText("");
        email_field.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 4, true));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(60, 60, 60));
        jLabel8.setText("Tanggal Lahir");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(60, 60, 60));
        jLabel9.setText("Alamat");

        alamat_textarea.setBackground(new java.awt.Color(240, 240, 240));
        alamat_textarea.setColumns(20);
        alamat_textarea.setForeground(new java.awt.Color(100, 100, 100));
        alamat_textarea.setRows(5);
        jScrollPane2.setViewportView(alamat_textarea);

        tgl_cbox.setBackground(new java.awt.Color(240, 240, 240));
        tgl_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        bulan_cbox.setBackground(new java.awt.Color(240, 240, 240));
        bulan_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));

        tahun_cbox.setBackground(new java.awt.Color(240, 240, 240));
        tahun_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022" }));

        back_button.setBackground(new java.awt.Color(255, 255, 255));
        back_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/img/arrow_back.png"))); // NOI18N
        back_button.setBorderPainted(false);
        back_button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        back_button.setPreferredSize(new java.awt.Dimension(24, 24));
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        password_field.setBackground(new java.awt.Color(240, 240, 240));
        password_field.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 4, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(username_field, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(name_field, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(email_field, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(register_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tgl_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bulan_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tahun_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(password_field)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tgl_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bulan_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tahun_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(register_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
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

    private void register_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_buttonActionPerformed
        if ( username_field.getText().length() == 0 || password_field.getPassword().length == 0 || name_field.getText().length() == 0 || email_field.getText().length() == 0) {
            JOptionPane optionPane = new JOptionPane(new JLabel("Harap Isi data register",JLabel.CENTER));
            JDialog dialog = optionPane.createDialog("");
            dialog.setSize(400, 130);
            dialog.setLocationRelativeTo(null);
            dialog.setModal(true);
            dialog.setVisible(true);
        } else {
           if ( alamat_textarea.getText().length() == 0 ) {
                JOptionPane optionPane = new JOptionPane(new JLabel("Harap isi alamat",JLabel.CENTER));
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
        }
    }//GEN-LAST:event_register_buttonActionPerformed

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        dispose();
        Home home = new Home();
        home.setLocationRelativeTo(null);
        home.setTitle("Aplikasi Tubes");
        home.setVisible(true);
    }//GEN-LAST:event_back_buttonActionPerformed

    private void simpan_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpan_buttonActionPerformed
        verif_dialog.dispose();
        dispose();
        String temp;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();
            String nama = name_field.getText();
            String username = username_field.getText();
            String password = password_field.getText();
            String email = email_field.getText();
            String alamat = alamat_textarea.getText();
            if ( bulan_cbox.getSelectedIndex() < 9 ) {
                temp = tahun_cbox.getSelectedItem()+"-0"+(bulan_cbox.getSelectedIndex()+1)+"-"+tgl_cbox.getSelectedItem();
            } else {
                temp = tahun_cbox.getSelectedItem()+"-"+(bulan_cbox.getSelectedIndex()+1)+"-"+tgl_cbox.getSelectedItem();
            }
            Date tgl_lahir = Date.valueOf(temp);
            String sql = "UPDATE pasien SET nama = '"+nama+"', email = '"+email+"', password = '"+password+"', alamat = '"+alamat+"', tgl_lahir = '"+tgl_lahir+"', username = '"+username+"' WHERE id = "+id_pasien;
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
        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        login.setTitle("TUBES");
    }//GEN-LAST:event_simpan_buttonActionPerformed

    private void batal_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batal_buttonActionPerformed
        verif_dialog.dispose();
    }//GEN-LAST:event_batal_buttonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat_textarea;
    private javax.swing.JButton back_button;
    private javax.swing.JButton batal_button;
    private javax.swing.JComboBox<String> bulan_cbox;
    private javax.swing.JTextField email_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField name_field;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JButton register_button;
    private javax.swing.JButton simpan_button;
    private javax.swing.JComboBox<String> tahun_cbox;
    private javax.swing.JComboBox<String> tgl_cbox;
    private javax.swing.JTextField username_field;
    private javax.swing.JDialog verif_dialog;
    // End of variables declaration//GEN-END:variables
}
