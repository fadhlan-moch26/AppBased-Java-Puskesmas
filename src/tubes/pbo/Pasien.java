package tubes.pbo;

import java.util.Date;

public class Pasien extends Person{
    private int id;
    private String email;
    private String username;
    private String password;
    private Date tgl_lahir;
    private String alamat;
    private int keluhan_id;

    public Pasien(int id, String nama, String email, String username, String password, Date tgl_lahir, String alamat, int keluhan_id) {
        super(nama);
        super.setKategori("Pasien");
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.tgl_lahir = tgl_lahir;
        this.alamat = alamat;
        this.keluhan_id = keluhan_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return super.getNama();
    }

    public void setNama(String nama) {
        super.setNama(nama);
    }
    
    public String getKategori() {
        return super.getKategori();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(Date tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getKeluhan_id() {
        return keluhan_id;
    }

    public void setKeluhan_id(int keluhan_id) {
        this.keluhan_id = keluhan_id;
    }
}