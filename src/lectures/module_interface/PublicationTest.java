package lectures.module_interface;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class PublicationTest {
  private Publication rushdie;
  private Publication turing;
  private Publication ccis;

  @Before
  public void setup() {
    rushdie = new Book("Midnight's Children", "Salman Rushdie", TypeOfBook.PAPERBACK,
        "Jonathan Cape", "London", 1980);

    turing = new Article("Computing machinery and intelligence", "A. M. Turing", "Mind", 59, 236,
        1950);

    ccis = new Webpage("Khoury College at Northeastern University",
        "https://www.khoury.northeastern.edu/", "10th August 2022");
  }

  @Test
  public void testCiteApa() {
    String expectedOutput = "Salman Rushdie (1980). Midnight's Children. London: Jonathan Cape.";
    assertEquals(expectedOutput, rushdie.citeApa());

    expectedOutput =
        "A. M. Turing (1950). Computing machinery and " + "intelligence. Mind, 59(236).";
    assertEquals(expectedOutput, turing.citeApa());

    expectedOutput = "Khoury College at Northeastern University. Retrieved 10th August "
        + "2022, from https://www.khoury.northeastern.edu/.";
    assertEquals(expectedOutput, ccis.citeApa());
  }

  @Test
  public void testCiteMla() {

    String expectedOutput =
        "Salman Rushdie. Midnight's Children. London: " + "Jonathan Cape, 1980.";
    assertEquals(expectedOutput, rushdie.citeMla());

    expectedOutput =
        "A. M. Turing. \"Computing machinery and " + "intelligence.\" Mind 59.236 (1950).";
    assertEquals(expectedOutput, turing.citeMla());

    expectedOutput = "\"Khoury College at Northeastern University.\" Web. 10th August "
        + "2022 <https://www.khoury.northeastern.edu/>.";
    assertEquals(expectedOutput, ccis.citeMla());
  }

  @Test
  public void testIfInvalidYear() {
    Publication rushdie;

    try {
      rushdie = new Book("Midnight's Children", "Salman Rushdie", TypeOfBook.HARDCOVER,
          "Jonathan Cape", "London", 1980);
      //normal tests for the rushdie object
    } catch (IllegalArgumentException e) {
      fail("An exception should not have been thrown");
    }

    try {
      rushdie = new Book("Midnight's Children", "Salman Rushdie", TypeOfBook.HARDCOVER,
          "Jonathan Cape", "London", -1980);
      fail("The above line should have thrown an exception");
    } catch (IllegalArgumentException e) {
      //do not do anything except catch the exception and let the test continue
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidYear2() {
    rushdie = new Book("Midnight's Children", "Salman Rushdie", TypeOfBook.HARDCOVER,
        "Jonathan Cape", "London", -1980);
  }
}
