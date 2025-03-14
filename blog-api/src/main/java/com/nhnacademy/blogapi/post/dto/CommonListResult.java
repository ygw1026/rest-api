package com.nhnacademy.blogapi.post.dto;

import java.util.List;

public class CommonListResult<T> {

    private final List<T> content;

    private final long totalCount;

    private final long totalPage;

    public CommonListResult(List<T> content, long totalCount, long totalPage) {
        this.content = content;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
    }

    public List<T> getContent() {
        return content;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public long getTotalPage() {
        return totalPage;
    }

    @Override
    public String toString() {
        return "CommonListResult{" +
                "content=" + content +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                '}';
    }
}
