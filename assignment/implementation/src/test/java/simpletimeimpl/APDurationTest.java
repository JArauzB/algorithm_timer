/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpletimeimpl;

//import static org.junit.jupiter.api.Assertions.fail;
import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author jorge
 */
public class APDurationTest {

    @Test
    public void addNewDurationTest() {
        System.out.println("TEST DURATION CLASS (plus())");
        //Arrange
        APDuration actualDuration = new APDuration(25);
        APDuration expectedDuration = new APDuration(1, 5);
        //Act
        int expectedMinutes = 90;
        //assert
        assertThat(actualDuration.plus(expectedDuration).asMinutes()).isEqualTo(expectedMinutes);
    }

    @Test
    public void getHoursTest() {
        System.out.println("TEST DURATION CLASS (getHours())");
        //Arrange
        APDuration actualDuration = new APDuration(1, 0);
        //Act
        int expectedHours = 1;
        //assert
        assertThat(actualDuration.getHours()).isEqualTo(expectedHours);
    }

    @Test
    public void getAsMinutesTest() {
        System.out.println("TEST DURATION CLASS (getMinutes())");
        //Arrange
        APDuration actualDuration = new APDuration(125);
        //Act
        int expectedMinutes = 5;
        //assert
        assertThat(actualDuration.getMinutes()).isEqualTo(expectedMinutes);
    }

    @Test
    public void getSubtractedMinutesTest() {
        System.out.println("TEST DURATION CLASS (getMinutes() + negative minutes)");
        //Arrange
        APDuration actualDuration = new APDuration(1, -49);
        //Act
        int expectedMinutes = 11;
        //assert
        assertThat(actualDuration.asMinutes()).isEqualTo(expectedMinutes);
    }

    @ParameterizedTest
    @CsvSource({
        "0,500,-1",
        "10,0, 1",
        "9, 59, 0"
    })
    public void compareToTest(int hours, int minutes, int expectedResult) {
        System.out.println("TEST DURATION CLASS (compareTo())");
        //Arrange
        APDuration actualDuration = new APDuration(hours, minutes);
        APDuration expectedDuration = new APDuration(9, 59);
        //Act
        //assert
        assertThat(actualDuration.compareTo(expectedDuration)).isEqualTo(expectedResult);
    }

    @Test
    public void equalsAndHashCodeTest() {
        System.out.println("TEST DURATION CLASS (equals and hashCode())");
        //Arrange
        APDuration firstDuration = new APDuration(1, 10);
        APDuration secondDuration = new APDuration(1, 10);
        //Act
        //assert
        SoftAssertions.assertSoftly(softly -> {
            //TODO write assertions
            softly.assertThat(firstDuration.equals(secondDuration) && secondDuration.equals(firstDuration)).isTrue();
            softly.assertThat(firstDuration.hashCode() == secondDuration.hashCode()).isTrue();
        });
    }
    
    @Test
    public void toStringTest() {
        System.out.println("TEST DURATION CLASS (toString())");
        //Arrange
        APDuration actualDuration = new APDuration(1, 0);
        //Act
        String expectedString = "minutes=60";
        //assert
        assertThat(actualDuration.toString()).contains(expectedString);
    }
}
