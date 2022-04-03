package Exeptions;

public class NoReadableFileException extends Exception {
    public NoReadableFileException(String message) {
        super(message);
    }
}
