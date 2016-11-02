package com.beimin.eveapi.response;

import java.util.ArrayList;
import java.util.List;

public abstract class ApiListResponse<B> extends ApiResponse {
    private final List<B> items = new ArrayList<B>();

    public void add(final B item) {
        items.add(item);
    }

    public List<B> getAll() {
        return items;
    }
}
