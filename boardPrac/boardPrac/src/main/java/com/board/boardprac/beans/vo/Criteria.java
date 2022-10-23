package com.board.boardprac.beans.vo;

import com.board.boardprac.DevController.logger;
import lombok.Data;

@Data
public class Criteria {

    private logger log = new logger();
    private int pageNum;
    private int amount;
    private String type;
    private String keyword;

    public Criteria() {
        this(1, 10);
    }

    public Criteria(int pageNum) { this(pageNum, 10); }

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    public String[] getTypeArr() {
        return type == null ? new String[] {} : type.split("");
    }

}
