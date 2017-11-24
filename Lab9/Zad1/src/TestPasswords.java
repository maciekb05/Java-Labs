public class TestPasswords {
    public static void main(String[] args) throws Exception {
        Passwords passy = new Passwords();
        for(String s : passy.getPasswords()) {
            System.out.println(s);
        }
    }
}
