package com.he.study.mybatis.entity.model;

import java.util.Date;

public class MyRule {
    private Integer id;

    private String logic;

    private Date date;

    private String repairname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogic() {
        return logic;
    }

    public void setLogic(String logic) {
        this.logic = logic == null ? null : logic.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRepairname() {
        return repairname;
    }

    public void setRepairname(String repairname) {
        this.repairname = repairname == null ? null : repairname.trim();
    }
}