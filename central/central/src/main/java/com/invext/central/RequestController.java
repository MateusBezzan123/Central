package com.invext.central;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    @Autowired
    private RequestDistributor distributor;

    @PostMapping
    public void createRequest(@RequestBody Request request) {
        distributor.handleRequest(request);
    }

    @PostMapping("/attendants")
    public void addAttendant(@RequestBody Attendant attendant) {
        distributor.addAttendant(attendant);
    }
}