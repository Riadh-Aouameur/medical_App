package medical;

public class Parameters {
    String type;
    HealthParameters a1 = null ;
    HealthParameters1 a2 = null;

    public Parameters(String a1, String type) {
        this.type = type;
        if(this.type.equals("t1")){
            this.a1 = new HealthParameters(a1);
        }else if (this.type.equals("t2")){
            this.a2 = new HealthParameters1(a1);

        }else {
            System.out.println("type not found");
        }


    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HealthParameters getA1() {
        return a1;
    }

    public void setA1(HealthParameters a1) {
        this.a1 = a1;
    }

    public HealthParameters1 getA2() {
        return a2;
    }

    public void setA2(HealthParameters1 a2) {
        this.a2 = a2;
    }
}
