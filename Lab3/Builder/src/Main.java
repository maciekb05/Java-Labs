import java.util.LinkedList;

public class Main {
    static EmailMessage getEmailMessage() {
        LinkedList<String> to = new LinkedList<String>();
        to.add("bielech@student.agh.edu.pl");
        //to.add("maciej.bielech@gmail.com");
        //to.add("maciek.bielech@hotmail.com");
        LinkedList<String> cc = new LinkedList<String>();
        cc.add("maciej.bielech@gmail.com");

        LinkedList<String> bcc = new LinkedList<String>();
        bcc.add("maciek.bielech@hotmail.com");

        return new
                EmailMessage.EmailMessageBuilder("maciektestjava@gmail.com", to)
                .subject("Temat")
                .content("<h1>Zawartość w HTML'u</h1> </br>" +
                        "<ul><li>Punkt pierwszy</li><li>Punkt drugi</li></ul> </br>" +
                        "<align>")
                .mimeType("text/html; charset=utf-8")
                //.cc(cc)
                //.bcc(bcc)
                .build();
    }
    public static void main(String[] args) {
        EmailMessage message = getEmailMessage();
        Sending.sendEmail(message);
    }
}
