package ua.osb.bdcalculation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.osb.bdcalculation.dto.DateDTO;
import ua.osb.bdcalculation.dto.DaysTillBirthdayDTO;
import ua.osb.bdcalculation.services.CalculationService;

@RestController
@RequestMapping(value = "/app")
public class BirthdayCalculationController {

    @Autowired
    private CalculationService calculator;

    @PostMapping(value = "/calculate", produces = "application/json")
    public DaysTillBirthdayDTO calculateDaysTillBirthday(@RequestBody DateDTO date) {
        return calculator.calculateFor(date);
    }

    @RequestMapping(value = "/heartBeat", method = RequestMethod.GET)
    public ResponseEntity<String> heartBeat(){
        return new ResponseEntity<String>("ACK", HttpStatus.OK);
    }
}
