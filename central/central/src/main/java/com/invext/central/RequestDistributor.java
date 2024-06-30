package com.invext.central;

import java.util.HashMap;
import java.util.Map;

public class RequestDistributor {
    private Map<String, SupportTeam> teams;

    public RequestDistributor() {
        teams = new HashMap<>();
        teams.put("Cartões", new SupportTeam("Cartões"));
        teams.put("Empréstimos", new SupportTeam("Empréstimos"));
        teams.put("Outros Assuntos", new SupportTeam("Outros Assuntos"));
    }

    public void addAttendant(Attendant attendant) {
        SupportTeam team = teams.get(attendant.getTeam());
        if (team != null) {
            team.addAttendant(attendant);
        }
    }

    public void handleRequest(Request request) {
        String type = request.getType();
        SupportTeam team;

        switch (type) {
            case "Problemas com cartão":
                team = teams.get("Cartões");
                break;
            case "Contratação de empréstimo":
                team = teams.get("Empréstimos");
                break;
            default:
                team = teams.get("Outros Assuntos");
                break;
        }

        if (team != null) {
            team.addRequest(request);
        }
    }
}