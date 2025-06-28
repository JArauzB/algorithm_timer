/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpletime;

//import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import simpletimeapi.Time;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import simpletimeapi.Duration;

/**
 *
 * @author jorge
 */
public class APFactoryTest {

    @Test
    void createTimeTest() {
        APFactory factory = new APFactory();

        Time actualTime = factory.createTime(0, 120);

        assertThat(actualTime.asMinutes()).isEqualTo(120);
    }

    @ParameterizedTest
    @CsvSource({
        "-3,0",
        "1441,0",})
    void createTimeExceptionTest(int hours, int minutes) {
        APFactory factory = new APFactory();

        ThrowingCallable code = () -> {
            factory.createTime(hours, minutes);
        };

        assertThatThrownBy(code)
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void createDurationHourTimeTest() {
        APFactory factory = new APFactory();

        Duration actualTime = factory.createDuration(1, 30);

        assertThat(actualTime.asMinutes()).isEqualTo(90);
    }

    @Test
    void createDurationMinutesTest() {
        APFactory factory = new APFactory();

        Duration actualTime = factory.createDuration(30);

        assertThat(actualTime.asMinutes()).isEqualTo(30);
    }

    @Test
    void timeBetweenTest() {
        APFactory factory = new APFactory();

        Time time1 = factory.createTime(9, 35);
        Time time2 = factory.createTime(9, 15);
        Duration expectedDuration = time1.until(time2);
        assertThat(expectedDuration.asMinutes()).isEqualTo(1420);
    }
    @Test
    void testAddTime() {
        APFactory factory = new APFactory();

        Time time1 = factory.createTime(9, 15);
        Time time2 = factory.createTime(0, 5);
        Time resultTime = factory.createTime(9, 20);
        
        Time expectedResult = time1.addTime(time2.asMinutes());
        assertThat(expectedResult.toString()).isEqualTo(resultTime.toString());
    }
    
    @Test
    void testMethodInvocations() {
        APFactory factory = new APFactory();

        Time time1 = factory.createTime(23, 59);
        Time time2 = factory.createTime(0, 5);
        Time resultTime = factory.createTime(0, 4);
        
        Time expectedTime = time1.addTime(time2);
        assertThat(expectedTime.toString()).isEqualTo(resultTime.toString());
    }
    
    @Test
    void testMethodInvocations2() {
        APFactory factory = new APFactory();

        Time time1 = factory.createTime(12, 35);
        Time time2 = factory.createTime(2, 3);
        Time resultTime = factory.createTime(14, 38);
        
        Time expectedTime = time1.addTime(time2);
        assertThat(expectedTime.toString()).isEqualTo(resultTime.toString());
    }
}
