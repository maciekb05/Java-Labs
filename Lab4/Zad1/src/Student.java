public class Student extends Worker {
    Student(Pesel pesel, double wynagrodzenieBrutto) {
        super(pesel, wynagrodzenieBrutto);
    }
    public double wynagrodzenieNetto(){
        return getWynagrodzenieBrutto()*(0.92);
    }
}
