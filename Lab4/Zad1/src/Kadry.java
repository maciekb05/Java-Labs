import java.util.LinkedList;

public class Kadry {
    LinkedList<Worker> workers;
    Kadry(){
        workers = new LinkedList<>();
    }
    public void addStudent(String pesel, double wynagrodzenieBrutto){
        workers.add(new Student(new Pesel(pesel), wynagrodzenieBrutto));
    }
    public void addFullTime(String pesel, double wynagrodzenieBrutto){
        workers.add(new FulltimeEmployee(new Pesel(pesel), wynagrodzenieBrutto));
    }
    public void delete(String pesel){
        for(Worker worker : workers){
            if(worker.getPesel().getPesel().equals(pesel)){
                workers.remove(worker);
                break;
            }
        }
    }
    public void zmienWynagrodzenieBrutto(String pesel, double noweWynagrodzenieBrutto){
        for(Worker worker : workers) {
            if(worker.getPesel().getPesel().equals(pesel)) {
                worker.setWynagrodzenieBrutto(noweWynagrodzenieBrutto);
                break;
            }
        }
    }
    public double getWynagrodzenieBrutto(String pesel){
        for(Worker worker : workers) {
            if(worker.getPesel().getPesel().equals(pesel)) {
                return worker.getWynagrodzenieBrutto();
            }
        }
        return 0;
    }
    public double getWynagrodzenieNetto(String pesel){
        for(Worker worker : workers) {
            if(worker.getPesel().getPesel().equals(pesel)) {
                return worker.wynagrodzenieNetto();
            }
        }
        return 0;
    }


}
