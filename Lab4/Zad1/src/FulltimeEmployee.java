public class FulltimeEmployee extends Worker {
    FulltimeEmployee(Pesel pesel, double wynagrodzenieBrutto){
        super(pesel, wynagrodzenieBrutto);
    }
    public double wynagrodzenieNetto(){
        return getWynagrodzenieBrutto()*(0.77);
    }
}
