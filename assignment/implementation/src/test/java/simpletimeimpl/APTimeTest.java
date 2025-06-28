package simpletimeimpl;

import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import simpletimeapi.Duration;

/**
 *
 * @author jorge
 */
public class APTimeTest {

    @Test
    public void createConstructor() {
        //Arrange
        APTime time = new APTime(0);
        //Assert
        assertThat(time).isInstanceOf(APTime.class);
    }

    @Test
    public void addTimeOnlyMinutesTest() {
        APTime time = new APTime(60);
        //Act
        int expectedMinutes = 60;
        //Assert
        assertThat(time.asMinutes()).isEqualTo(expectedMinutes);
    }

    @Test
    public void addTimeTest() {
//        System.out.println("Test add time test");
        APTime time = new APTime(60);
        APTime expectedTime = new APTime(0);
        //Act
        time.addTime(expectedTime);
        int expectedMinutes = 60;
        //Assert
        assertThat(time.asMinutes()).isEqualTo(expectedMinutes);
    }

    @Test
    public void timeIsBeforeTest() {
//        System.out.println("Test time is before");

        APTime actualTime = new APTime(50);
        APTime expectedTime = new APTime(60);
        //Act
        //Assert
        assertThat(actualTime.isBefore(expectedTime)).isTrue();
    }

    @Test
    public void timeIsBeforeOrEqualTest() {
//        System.out.println("Test time is before or equal");

        APTime actualTime = new APTime(60);
        APTime expectedTime = new APTime(60);
        //Act
        //Assert
        assertThat(actualTime.isBeforeOrEqual(expectedTime)).isTrue();
    }

    @Test
    public void timeGetMinutesTest() {
//        System.out.println("Test as minutes");
        APTime time = new APTime(120);
        //Act
        int expectedMinutes = 120;
        //Assert
        assertThat(time.asMinutes()).isEqualTo(expectedMinutes);
    }

    @Test
    public void timeUntilTest() {
//        System.out.println("Test as minutes");
        APTime actualTime = new APTime(120);
        APTime expectedTime = new APTime(130);
        //Act
        Duration expectedDuration = actualTime.until(expectedTime);

        //Assert
        assertThat(expectedDuration.asMinutes()).isEqualTo(10);
    }

    @ParameterizedTest
    @CsvSource({
        "500,-1",
        "600, 1",
        "599, 0"
    })
    public void compareToTest(int minutes, int expectedResult) {
        //Arrange
        APTime actualTime = new APTime(minutes);
        APTime expectedTime = new APTime(599);
        //Act
        //assert
        assertThat(actualTime.compareTo(expectedTime)).isEqualTo(expectedResult);
    }

    @Test
    public void equalsAndHashCodeTest() {
        //Arrange
        APTime firstTime = new APTime(60);
        APTime secondTime = new APTime(60);
        //Act
        //assert
        SoftAssertions.assertSoftly(softly -> {
            //TODO write assertions
            softly.assertThat(firstTime.equals(secondTime) && secondTime.equals(firstTime)).isTrue();
            softly.assertThat(firstTime.hashCode() == secondTime.hashCode()).isTrue();
        });
    }

    @Test
    public void toStringTest() {
        //Arrange
        APTime actualTime = new APTime(60);
        //Act
//        actualTime.addTime(60);
        String expectedString = "01:00";
        //assert
        assertThat(actualTime.toString()).contains(expectedString);
    }
}
