package com.invext.central;

import java.util.LinkedList;
import java.util.Queue;

public class SupportTeam {
    private String name;
    private Queue<Attendant> attendants;
    private Queue<Request> requestQueue;

    public SupportTeam(String name) {
        this.name = name;
        this.attendants = new LinkedList<>();
        this.requestQueue = new LinkedList<>();
    }

    public void addAttendant(Attendant attendant) {
        attendants.add(attendant);
    }

    public void addRequest(Request request) {
        requestQueue.add(request);
        distributeRequests();
    }

    private void distributeRequests() {
        while (!requestQueue.isEmpty()) {
            Attendant availableAttendant = getAvailableAttendant();
            if (availableAttendant == null) {
                break;
            }
            Request request = requestQueue.poll();
            availableAttendant.addLoad();
            // Assign request to attendant (this would typically involve more logic)
        }
    }

    private Attendant getAvailableAttendant() {
        for (Attendant attendant : attendants) {
            if (attendant.getCurrentLoad() < 3) {
                return attendant;
            }
        }
        return null;
    }
}