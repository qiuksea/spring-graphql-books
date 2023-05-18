package qi.danvega.books.model;

public record Author(Integer id, String firstName, String lastName) {

    public String fullName(){
        return firstName + " " + lastName;
    }
}
