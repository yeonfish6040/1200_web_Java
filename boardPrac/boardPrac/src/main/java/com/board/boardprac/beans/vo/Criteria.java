package com.board.boardprac.beans.vo;

import lombok.Data;

@Data
public class Criteria {
    private int pageNum;
    private int amount;

    public Criteria() {
        this(1, 10);
    }

    public Criteria(int pageNum) { this(pageNum, 10); }

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

}