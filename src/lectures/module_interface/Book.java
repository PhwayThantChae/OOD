package lectures.module_interface;

public class Book implements Publication {
  private final String title;
  private final String author;
  private final String publisher;
  private final String location;
  private final int year;
  private TypeOfBook bookType;

  /**
   * Constructs a {@code Book} object.
   *
   * @param title     the title of the book
   * @param type      the type of the book
   * @param author    the author of the book
   * @param publisher the publisher of the book
   * @param location  the location of the publisher
   * @param year      the year of publication
   */

  public Book(String title, String author, TypeOfBook type, String publisher,
      String location, int year) {
    if (year < 0) {
      throw new IllegalArgumentException("Year of publication "+
          "cannot be a negative number");
    }
    this.title = title;
    this.bookType = type;
    this.author = author;
    this.publisher = publisher;
    this.location = location;
    this.year = year;
  }

  @Override
  public String citeApa() {
    return author + " (" + year + "). " + title + ". " +
        location + ": " + publisher + ".";
  }

  @Override
  public String citeMla() {
    return author + ". " + title + ". " + location + ": " +
        publisher + ", " + year + ".";
  }

}
