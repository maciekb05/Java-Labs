import java.util.LinkedList;

public class EmailMessage {
    private final String from; //required (must be e-mail)
    private final LinkedList<String> to; //required at least one (must be e-mail)
    private final String subject; //optional
    private final String content; //optional
    private final String mimeType;  // optional
    private final LinkedList<String> cc; //optional
    private final LinkedList<String> bcc; // optional

    private EmailMessage(EmailMessageBuilder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.subject = builder.subject;
        this.content = builder.content;
        this.mimeType = builder.mimeType;
        this.cc = builder.cc;
        this.bcc = builder.bcc;
    }

    public String getFrom() {
        return from;
    }
    public LinkedList<String> getTo() {
        return to;
    }
    public String getSubject() {
        return subject;
    }
    public String getContent() {
        return content;
    }
    public String getMimeType() {
        return mimeType;
    }
    public LinkedList<String> getCc() {
        return cc;
    }
    public LinkedList<String> getBcc() {
        return bcc;
    }

    public static class EmailMessageBuilder {
        private String from; //required (must be e-mail)
        private LinkedList<String> to; //required at least one (must be e-mail)
        private String subject; //optional
        private String content; //optional
        private String mimeType;  // optional
        private LinkedList<String> cc; //optional
        private LinkedList<String> bcc; // optional

        public EmailMessageBuilder(String from, LinkedList<String> to) {
            this.from = from;
            this.to = to;
        }
        public EmailMessageBuilder subject(String subject) {
            this.subject = subject;
            return this;
        }
        public EmailMessageBuilder content(String content) {
            this.content = content;
            return this;
        }
        public EmailMessageBuilder mimeType(String mimeType) {
            this.mimeType = mimeType;
            return this;
        }
        public EmailMessageBuilder cc(LinkedList<String> cc) {
            this.cc = cc;
            return this;
        }
        public EmailMessageBuilder bcc(LinkedList<String> bcc) {
            this.bcc = bcc;
            return this;
        }
        public EmailMessage build() {
            return new EmailMessage(this);
        }

    }
}
