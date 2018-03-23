package ua.osb.bdcalculation.services;

import lombok.experimental.var;
import lombok.val;
import ua.osb.bdcalculation.dto.DateDTO;
import ua.osb.bdcalculation.dto.DaysTillBirthdayDTO;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class CalculationServiceImpl implements CalculationService {

    @Override
    public DaysTillBirthdayDTO calculateFor(DateDTO dateDTO) {
        val birthDate = constructDate(dateDTO);
        val currentDate = LocalDate.now();
        val birthdayForCurrentYear = birthDate.withYear(LocalDate.now().getYear());

        if (currentDate.isBefore(birthdayForCurrentYear)) {
            return calculateForUpcomingThisYear(birthdayForCurrentYear, currentDate);
        } else {
            return calculateForUpcomingNextYear(birthdayForCurrentYear, currentDate);
        }
    }

    DaysTillBirthdayDTO calculateForUpcomingThisYear(LocalDate birthDateForCurrentYear, LocalDate currentDate) {
        Integer numberOfDays = (int) DAYS.between(currentDate, birthDateForCurrentYear);
        return new DaysTillBirthdayDTO(numberOfDays);
    }

    DaysTillBirthdayDTO calculateForUpcomingNextYear(LocalDate birthdayForCurrentYear, LocalDate currentDate) {
        val birthdayNextYear = birthdayForCurrentYear.plusYears(1);
        return calculateForUpcomingThisYear(birthdayNextYear, currentDate);
    }

    /**
     * @param dateDTO
     * @return LocalDate object
     * @throws java.time.DateTimeException if dto contains illegal data
     */
    private LocalDate constructDate(DateDTO dateDTO) {
        return LocalDate.of(
                dateDTO.getYear(),
                dateDTO.getMonth(),
                dateDTO.getDay()
        );
    }
}
