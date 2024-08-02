package Contract;
import java.io.Serializable;

public class Vehicul implements Serializable{
    String nrInmatriculare;
    int anMasina;
    String producator;
    int valoareEstimata;
    int normaPoluare;
    
    public Vehicul(String nrInmatriculare, int anMasina, String producator, int valoareEstimata, int normaPoluare){
        this.nrInmatriculare = nrInmatriculare;
        this.anMasina = anMasina;
        this.producator = producator;
        this.valoareEstimata = valoareEstimata;
        this.normaPoluare = normaPoluare;
    }
    public String GetNrInmatriculare() {
        return nrInmatriculare;
    }

    public void setNrInmatriculare(String nrInmatriculare) {
        this.nrInmatriculare = nrInmatriculare;
    }

    public int getAnMasina() {
        return anMasina;
    }

    public void setAnMasina(int anMasina) {
        this.anMasina = anMasina;
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public int getValoareEstimata() {
        return valoareEstimata;
    }

    public void setValoareEstimata(int valoareEstimata) {
        this.valoareEstimata = valoareEstimata;
    }

    public int getNormaPoluare() {
        return normaPoluare;
    }

    public void setNormaPoluare(int normaPoluare) {
        this.normaPoluare = normaPoluare;
    }
    @Override
    public String toString() {
        return  "Numar inmatriculare: " + nrInmatriculare +
                "\nAnul masinii: " + anMasina +
                "\nProducator: " + producator +
                "\nValoare estimata: " + valoareEstimata +
                "\nNorma de poluare: " + normaPoluare;
    }
}
