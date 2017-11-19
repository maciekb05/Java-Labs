public class MainKadry {
    public static void main(String[] args) {
        Kadry szef = new Kadry();
        szef.addFullTime("97070205112", 5500.50);
        szef.addStudent("11122233344", 1400);
        szef.addFullTime("12345678901",1000);
        szef.delete("12345678901");
        szef.zmienWynagrodzenieBrutto("11122233344", 1200);
        System.out.println(szef.getWynagrodzenieBrutto("11122233344"));
        System.out.println(szef.getWynagrodzenieNetto("11122233344"));
        System.out.println(szef.getWynagrodzenieNetto("97070205112"));
        szef.addFullTime("97340205112", 2000);
        szef.addStudent("11122232344", 3473.342);
        szef.addFullTime("12335678901",3242.4234);
        Sort.sort(szef.workers);
        System.out.println("Sorted");
        for(Worker worker : szef.workers){
            System.out.println(worker.getWynagrodzenieBrutto());
        }
    }
}
