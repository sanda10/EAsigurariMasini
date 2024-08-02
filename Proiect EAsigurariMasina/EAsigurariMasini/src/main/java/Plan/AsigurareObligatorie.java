package Plan;

public class AsigurareObligatorie extends Asigurare{
    @Override 
    public float getAsigurare(){
        return 0.01f;
    }
    @Override 
    public float getAcoperire(){
        return 0.6f;
    }
    @Override 
    public float getPlafon(){
        return 4;
    }
    public String[] acoperireAsigurareObligatorie = {
            "Accidentarea altui coducator"
    };
}
