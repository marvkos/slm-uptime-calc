package at.technikum.uptimecalc.controller;

import at.technikum.uptimecalc.model.Downtime;
import at.technikum.uptimecalc.service.DowntimeCalculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DowntimeController {

    private final DowntimeCalculator downtimeCalculator;

    public DowntimeController(DowntimeCalculator downtimeCalculator) {
        this.downtimeCalculator = downtimeCalculator;
    }

    @GetMapping("/api/downtime")
    public Downtime getDowntime(@RequestParam float percent) {
        return this.downtimeCalculator.calc(percent);
    }
}
