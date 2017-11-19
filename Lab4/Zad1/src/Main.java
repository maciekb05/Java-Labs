public class Main {
    public static void main(String[] args) {
        Pesel p = new Pesel("97070205112");
        if (Pesel.check(p))
            System.out.println("Pesel is correct!");
        else
            System.out.println("Pesel is incorrect!!!");
    }
}
