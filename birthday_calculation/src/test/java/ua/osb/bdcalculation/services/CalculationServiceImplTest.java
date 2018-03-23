package ua.osb.bdcalculation.services;


import org.junit.jupiter.api.Test;
import ua.osb.bdcalculation.dto.DaysTillBirthdayDTO;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculationServiceImplTest {

    @Test
    void testCorrectCalculationForBirthdayThisYear() {
        LocalDate birthday = LocalDate.of(2018, 3, 24);
        LocalDate currentDay = LocalDate.of(2018, 3, 22);

        DaysTillBirthdayDTO result = new CalculationServiceImpl().calculateForUpcomingThisYear(birthday, currentDay);

        assertEquals(2, (int)result.getNumberOfDays());
    }
}