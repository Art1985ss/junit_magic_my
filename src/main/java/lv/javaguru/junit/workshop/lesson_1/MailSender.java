package lv.javaguru.junit.workshop.lesson_1;

public interface MailSender {
    void sendMail(double income) throws MailWasNotSent;
}
