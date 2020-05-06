package com.he.study.designexample.action.responsibility;

public class Director extends Approver {
    public Director(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 50000) {
            System.out.println("主任" + this.name + "审批采购单："
                    + request.getNumber()
                    + "，金额：" + request.getAmount() + "元，采购目的：" + request.getPurpose() + "。");
        } else {
            this.successor.processRequest(request);
        }
    }
}

class VicePresident extends Approver {
    public VicePresident(String name) {
        super(name);
    }//具体请求处理方法

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 100000) {
            System.out.println("副董事长" + this.name + "审批采购单："
                    + request.getNumber() + "，金额："
                    + request.getAmount() + "元，采购目的：" + request.getPurpose() + "。");
            // 处理请求
            } else {
            //转发请求
            this.successor.processRequest(request);
        }
    }
}
class President extends Approver {
    public President(String name) {
        super(name);
    }//具体请求处理方法

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 100000) {
            System.out.println("董事长" + this.name + "审批采购单："
                    + request.getNumber() + "，金额："
                    + request.getAmount() + "元，采购目的：" + request.getPurpose() + "。");
            // 处理请求
        } else {
            //转发请求
            this.successor.processRequest(request);
        }
    }
}
class Congress extends Approver {
    public Congress(String name) {
        super(name);
    }//具体请求处理方法

    @Override
    public void processRequest(PurchaseRequest request) {
        System.out.println("召开董事会审批采购单：" + request.getNumber()+ "，金额："
                + request.getAmount() + "元，采购目的：" + request.getPurpose() + "。");
    }
}