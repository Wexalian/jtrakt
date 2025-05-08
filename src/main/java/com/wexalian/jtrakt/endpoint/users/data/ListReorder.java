package com.wexalian.jtrakt.endpoint.users.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListReorder {
    private final List<Integer> rank = new ArrayList<>();
    
    public ListReorder(Integer[] ranks) {
        rank.addAll(Arrays.asList(ranks));
    }
}
