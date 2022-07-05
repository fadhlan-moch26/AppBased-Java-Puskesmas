package tubes.pbo;

public class Obat {
    private int id;
    private String nama_obat;
    private int keluhan_id;
    private int harga;

    public Obat(int id, String nama_obat, int keluhan_id, int harga) {
        this.id = id;
        this.nama_obat = nama_obat;
        this.keluhan_id = keluhan_id;
        this.harga = harga;
    }

    public Obat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public int getKeluhan_id() {
        return keluhan_id;
    }

    public void setKeluhan_id(int keluhan_id) {
        this.keluhan_id = keluhan_id;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}