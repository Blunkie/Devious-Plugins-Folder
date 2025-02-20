package net.devious.plugins.clockworks.overlay;

import lombok.Getter;

import java.time.Duration;
import java.time.Instant;

@Getter
public class BotSession {
    private String currentTask;
    private Instant startTime;

    public void startTimer() {
        startTime = Instant.now();
    }

    public String getElapsedTime() {
        Duration time = Duration.between(startTime, Instant.now());
        return convertSecondsToHMmSs(time.toSeconds());
    }

    public void setCurrentTask(String task) {
        currentTask = task;
    }

    private String convertSecondsToHMmSs(long seconds) {
        long s = seconds % 60;
        long m = (seconds / 60) % 60;
        long h = (seconds / (60 * 60)) % 24;
        return String.format("%d:%02d:%02d", h, m, s);
    }
}
