package Medical;


public class Ordinance {


    String medicament;
    String Posologie;
    public Ordinance(String medicament, String posologie) {
        this.medicament = medicament;
        Posologie = posologie;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public void setPosologie(String posologie) {
        Posologie = posologie;
    }
    public String getMedicament() {
        return medicament;
    }

    public String getPosologie() {
        return Posologie;
    }
}
