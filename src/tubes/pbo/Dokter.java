package tubes.pbo;

public class Dokter extends Person implements TaxFee{
    private int id;
    private String jenis_dokter;
    private int fee;
    
    public Dokter(int id, String jenis_dokter, String nama) {
        super(nama);
        super.setKategori("Dokter");
        this.id = id;
        this.jenis_dokter = jenis_dokter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJenis_dokter() {
        return jenis_dokter;
    }

    public void setJenis_dokter(String jenis_dokter) {
        this.jenis_dokter = jenis_dokter;
    }

    public String getNama() {
        return super.getNama();
    }

    public void setNama(String nama) {
        super.setNama(nama);
    }

    public int getFee() {
        return fee;
    }
    
    public String getKategori() {
        return super.getKategori();
    }
    
    @Override
    public int hitungfee() {
        int jumlah;
        if ( getJenis_dokter().matches("Dokter Umum") ) {
            jumlah = (int) (30000*pajak)+30000;
        } else if ( getJenis_dokter().matches("Dokter Gigi") ) {
            jumlah = (int) (45000*pajak)+45000;
        } else {
            jumlah = (int) (60000*pajak)+60000;
        }
        return jumlah;
    }
}
