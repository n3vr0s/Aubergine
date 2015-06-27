package com.n3vr0s.aubergine.app.communications.responses;

import com.n3vr0s.aubergine.app.communications.pojos.BeerPojo;

import java.util.List;

public class BeerResponse {

    public int currentPage;
    public int numberOfPages;
    public int totalResults;
    public String status;
    public List<BeerPojo> data;
}