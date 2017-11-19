public abstract class Worker {
    private Pesel pesel;
    private double wynagrodzenieBrutto;

    Worker(){}

    Worker(Pesel pesel, double wynagrodzenieBrutto){
        this.pesel = pesel;
        this.wynagrodzenieBrutto = wynagrodzenieBrutto;
    }

    public Pesel getPesel() {
        return pesel;
    }

    public void setPesel(Pesel pesel) {
        this.pesel = pesel;
    }

    public double getWynagrodzenieBrutto() {
        return wynagrodzenieBrutto;
    }

    public void setWynagrodzenieBrutto(double wynagrodzenieBrutto) {
        this.wynagrodzenieBrutto = wynagrodzenieBrutto;
    }

    abstract double wynagrodzenieNetto();
}
