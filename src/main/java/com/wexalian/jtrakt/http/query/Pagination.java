package com.wexalian.jtrakt.http.query;

public final class Pagination {
    private final int page;
    private final int limit;
    
    private Pagination(int page, int limit) {
        this.page = page;
        this.limit = limit;
    }
    
    public int getPage() {
        return page;
    }
    
    public int getLimit() {
        return limit;
    }
    
    public static Pagination of(int page, int limit) {
        if (page == 1 && limit == 10) return null; //default
        return new Pagination(page, limit);
    }
}
