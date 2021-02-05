package pl.pjatk.store.exception;

public class ArticleException extends Exception {

    public ArticleException(int id) {
        super("fuck, id is " + String.valueOf(id));
    }
}
