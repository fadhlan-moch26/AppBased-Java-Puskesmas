package tubes.pbo;

public class Keluhan {
    private int id;
    private String nama_keluhan;
    private int dokter_id;

    public Keluhan(int id, String nama_keluhan, int dokter_id) {
        this.id = id;
        this.nama_keluhan = nama_keluhan;
        this.dokter_id = dokter_id;
    }

    public Keluhan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_keluhan() {
        return nama_keluhan;
    }

    public void setNama_keluhan(String nama_keluhan) {
        this.nama_keluhan = nama_keluhan;
    }

    public int getDokter_id() {
        return dokter_id;
    }

    public void setDokter_id(int dokter_id) {
        this.dokter_id = dokter_id;
    }
}
