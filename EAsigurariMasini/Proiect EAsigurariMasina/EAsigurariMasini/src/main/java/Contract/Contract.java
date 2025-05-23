package Contract;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract implements Serializable{
    static int nrContract = 0;
    Vehicul vehicul;
    List<String> listaAcoperireAsigurari = new ArrayList<>();
    
    List<Float> listaAsigurare = new ArrayList<>();
    List<Float> listaAcoperire = new ArrayList<>();
    List<Float> listaPlafon = new ArrayList<>();
    
    int lunaValabilitate;
    LocalDate dataContractului;
    
    public Contract (Vehicul vehicul, List<String> listaAcoperireAsigurari, List<Float> listaAsigurare, List<Float> listaAcoperire, List<Float> listaPlafon, int lunaValabilitate, LocalDate dataContractului){
        nrContract += 1;
        this.vehicul = vehicul;
        this.listaAcoperireAsigurari = listaAcoperireAsigurari;
        this.listaAsigurare = listaAsigurare;
        this.listaAcoperire = listaAcoperire;
        this.listaPlafon = listaPlafon;
        this.lunaValabilitate = lunaValabilitate;
        this.dataContractului = dataContractului;
    }
    public int getNrContract() {
        return nrContract;
    }
    
    public Vehicul getVehicul() {
        return vehicul;
    }

    public List<String> getListaAcoperireAsigurari() {
        return listaAcoperireAsigurari;
    }

    public List<Float> getListaAsigurare() {
        return listaAsigurare;
    }

    public List<Float> getListaAcoperire() {
        return listaAcoperire;
    }

    public List<Float> getListaPlafon() {
        return listaPlafon;
    }

    public int getLunaValabilitate() {
        return lunaValabilitate;
    }

    public LocalDate getDataContractului() {
        return dataContractului;
    }
    @Override
    public String toString() {
        return  "Numar contract: " + nrContract +
                "\n" + vehicul +
                "\nLuni valabilitate: " + lunaValabilitate;

    }
}
