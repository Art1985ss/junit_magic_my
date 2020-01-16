package lv.javaguru.junit.workshop.lesson_3.validation;

public interface UserRepository {
    public boolean usedLast3Times(String password);
}
