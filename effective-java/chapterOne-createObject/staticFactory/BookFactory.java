package staticFactory;

public class BookFactory {

    public static Book getBook(String type) {
        if (type.equals("entertainment")) {
            return new EntertainmentBook();
        } else if (type.equals("novel")) {
            return new Novel();
        } else {
            return null;
        }
    }
}

abstract class Book {
    String title;

    String content;
}

class EntertainmentBook extends Book {


}

class Novel extends Book {

}


