package com.model;

import java.util.ArrayList;
import java.util.List;

public class NGORepresentative extends User {
    private List<Request> requests;

    public NGORepresentative(String userId, String name, String email) {
        super(userId, name, email);
        this.requests = new ArrayList<>();
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void addRequest(Request request) {
        requests.add(request);
    }
}

