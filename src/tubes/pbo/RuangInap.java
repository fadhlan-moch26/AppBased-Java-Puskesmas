package tubes.pbo;

public class RuangInap implements TaxFee{
    private int id;
    private String no_ruang;
    private int pasien_id;
    private int fee;

    public RuangInap(int id, String no_ruang, int pasien_id) {
        this.id = id;
        this.no_ruang = no_ruang;
        this.pasien_id = pasien_id;
    }

    public RuangInap() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo_ruang() {
        return no_ruang;
    }

    public void setNo_ruang(String no_ruang) {
        this.no_ruang = no_ruang;
    }

    public int getPasien_id() {
        return pasien_id;
    }

    public void setPasien_id(int pasien_id) {
        this.pasien_id = pasien_id;
    }
    
    @Override
    public int hitungfee() {
        return (int) ((170000*pajak)+170000);
    }
}
