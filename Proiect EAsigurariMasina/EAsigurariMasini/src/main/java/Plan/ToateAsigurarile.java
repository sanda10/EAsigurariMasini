package Plan;

public class ToateAsigurarile extends Asigurare{
    @Override 
    public float getAsigurare(){
        return 0.075f;
    }
    @Override 
    public float getAcoperire(){
        return 1f;
    }
    @Override 
    public float getPlafon(){
        return 10;
    }
    public String[] acoperireToateAsigurarile = {
            "Incendiu",
            "Furt",
            "Accidentarea altui conducator",
            "Accidentarea masinii",
            "Accidentare conducator",
            "Transport",
            "Inlocuirea masinii"
    };
}
