package com.invext.central;

import java.util.concurrent.atomic.AtomicInteger;

public class Attendant {
    private final String id;
    private final String team;
    private final AtomicInteger currentLoad;

    public Attendant(String id, String team) {
        this.id = id;
        this.team = team;
        this.currentLoad = new AtomicInteger(0);
    }

    public String getId() {
        return id;
    }

    public String getTeam() {
        return team;
    }

    public int getCurrentLoad() {
        return currentLoad.get();
    }

    public boolean addLoad() {
        if (currentLoad.get() < 3) {
            currentLoad.incrementAndGet();
            return true;
        }
        return false;
    }

    public void removeLoad() {
        currentLoad.decrementAndGet();
    }
}
