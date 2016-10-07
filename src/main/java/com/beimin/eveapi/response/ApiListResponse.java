package com.beimin.eveapi.response;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class ApiListResponse<B> extends ApiResponse {
    private final Set<B> items = new LinkedHashSet<B>();

    public void add(final B item) {
        items.add(item);
    }

    public Set<B> getAll() {
        return items;
    }
}