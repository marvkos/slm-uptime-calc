package at.technikum.uptimecalc.service;

import at.technikum.uptimecalc.model.Downtime;
import org.springframework.stereotype.Service;

@Service
public class DowntimeCalculator {

    private static float SECONDS_IN_A_DAY = 86400.0f;

    public Downtime calc(float percent) {
        long dailySeconds = (long) (SECONDS_IN_A_DAY * (1.0 - (percent / 100.f)));

        Downtime downtime = new Downtime(
                toDateString(dailySeconds),
                toDateString(dailySeconds * 7),
                toDateString(dailySeconds * (365/12)),
                toDateString(dailySeconds * (365/4)),
                toDateString(dailySeconds * 365)
        );

        return downtime;
    }

    private String toDateString(long seconds) {
        long s = seconds;

        // days
        long d = (long) Math.floor(s / (24 * 3600));
        s -= d * 24 * 3600;

        // hours
        long h = (long) Math.floor(s / 3600);
        s -= h * 3600;

        // minutes
        long m = (long) Math.floor(s / 60);
        s -= m * 60;

        return "%dd %dh %dm %ds".formatted(d, h, m, s);
    }
}
