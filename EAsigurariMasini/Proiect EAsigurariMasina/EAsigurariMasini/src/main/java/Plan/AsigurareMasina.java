package Plan;

public class AsigurareMasina extends Asigurare{
    @Override 
    public float getAsigurare(){
        return 0.05f;
    }
    @Override 
    public float getAcoperire(){
        return 0.9f;
    }
    @Override 
    public float getPlafon(){
        return 6;
    }
    public String[] acoperireAsigurareMasina = {
            "Accidentarea masinii"
    };
}
