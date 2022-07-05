package tubes.pbo;

import java.sql.Date;

public class Ambulance extends Person implements TaxFee{
    private int id;
    private int pasien_di;
    private Date tgl_pemesanan;
    private String alamat;
    private final int fee = 500000;

    public Ambulance(int id, int pasien_di, Date tgl_pemesanan, String alamat) {
        super("Agus Spartagus R.");
        super.setKategori("Driver Ambulance");
        this.id = id;
        this.pasien_di = pasien_di;
        this.tgl_pemesanan = tgl_pemesanan;
        this.alamat = alamat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPasien_di() {
        return pasien_di;
    }

    public void setPasien_di(int pasien_di) {
        this.pasien_di = pasien_di;
    }

    public Date getTgl_pemesanan() {
        return tgl_pemesanan;
    }

    public void setTgl_pemesanan(Date tgl_pemesanan) {
        this.tgl_pemesanan = tgl_pemesanan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public void setNama(String nama) {
        super.setNama(nama);
    }
    
    public String getNama() {
        return super.getNama();
    }
    
    public String getKategori() {
        return super.getKategori();
    }
        
    @Override
    public int hitungfee() {
        return (int) (this.fee*pajak)+this.fee;
    }

    public int getFee() {
        return fee;
    }
}