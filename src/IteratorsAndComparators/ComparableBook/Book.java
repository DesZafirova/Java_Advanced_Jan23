package ComparableBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private  int year;
    private List<String> authors;
    public Book(String title, int year, String... authors){
        this.title = title;
        this.year = year;
        this.authors = new ArrayList<>(Arrays.asList(authors));
    }
    public int compareTo(Book otherBook) {
//        if( this.getTitle().compareTo(otherBook.getTitle()) == 0){
//            return Integer.compare(this.getYear(), otherBook.getYear());
//        }
//        return this.getTitle().compareTo(otherBook.getTitle());
        int result = this.getTitle().compareTo(otherBook.getTitle());
        if(result == 0){
            result = Integer.compare(this.getYear(), otherBook.getYear());
        }
        return result;
    }


    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

}

