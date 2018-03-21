package ua.osb.bdcalculation.services;

import ua.osb.bdcalculation.dto.DateDTO;
import ua.osb.bdcalculation.dto.DaysTillBirthdayDTO;

public interface CalculationService {
    DaysTillBirthdayDTO calculateFor(DateDTO date);
}