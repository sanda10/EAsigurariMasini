package Contract;
import java.io.Serializable;

public class Client implements Serializable{
    String nume, prenume, oras;
    int nrTelefon, accidente;
    Contract contract;
    
    public Client(){}
    
    public Client(String nume, String prenume, String oras, int nrTelefon, int accidente, Contract contract){
        this.nume = nume;
        this.prenume = prenume;
        this.oras = oras;
        this.nrTelefon = nrTelefon;
        this.contract = contract;
        this.accidente = accidente;
    }
    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getOras() {
        return oras;
    }

    public int getNrTelefon() {
        return nrTelefon;
    }

    public int getAccidente() {
        return accidente;
    }

    public Contract getContract() {
        return contract;
    }
    
    @Override
    public String toString() {
        return  "Nume: " + nume + '\n' +
                "Prenume: " + prenume + '\n' +
                "Oras: " + oras + '\n' +
                "Nr Telefon: " + nrTelefon + '\n'+
                "Nr accidente in ultimii cinci ani: " + accidente + '\n'+
                "" + contract ;
    }
}
