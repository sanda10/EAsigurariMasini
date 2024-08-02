package Plan;

public class Asistenta extends Asigurare{
    @Override 
    public float getAsigurare(){
        return 0.05f;
    }
    @Override 
    public float getAcoperire(){
        return 0.8f;
    }
    @Override 
    public float getPlafon(){
        return 8;
    }
    public String[] acoperireAsigurareAsistenta = {
            "Incendiu",
            "Furt",
            "Transport",
            "Inlocuire Masina"
    };
}
