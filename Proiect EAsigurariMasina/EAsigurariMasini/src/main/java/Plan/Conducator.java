
package Plan;

public class Conducator extends Asigurare{
    @Override 
    public float getAsigurare(){
        return 0.05f;
    }
    @Override 
    public float getAcoperire(){
        return 0.7f;
    }
    @Override 
    public float getPlafon(){
        return 6;
    }
    public String[] acoperireAsigurareConducator = {
            "Accidentare conducator"
    };
}
