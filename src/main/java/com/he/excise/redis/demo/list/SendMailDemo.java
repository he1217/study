package com.he.excise.redis.demo.list;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;

/**
 * 注册之后发送邮件的案例
 */
public class SendMailDemo {

    private Jedis jedis = new Jedis("192.168.3.235");

    /**
     * 让发送邮件任务入队列
     * @param sendMailTask
     */
    public void enqueueSendMailTask(String sendMailTask) {
        if (jedis.exists("send_mail_task_queue")){
            jedis.lpush("send_mail_task_queue", sendMailTask);
        }else {
            jedis.lpush("send_mail_task_queue", sendMailTask);
        }
    }

    /**
     * 阻塞式获取发送邮件任务
     * @return
     */
    public List<String> takeSendMailTask() {
        return jedis.brpop(3, "send_mail_task_queue");
    }
    public static void main(String[] args) {
        SendMailDemo demo = new SendMailDemo();
//        System.out.println("尝试阻塞式的获取发送邮件任务......");

        demo.enqueueSendMailTask("第一个邮件发送任务");
        demo.enqueueSendMailTask("第2个邮件发送任务");
        List<String> sendMailTasks = demo.takeSendMailTask();
        System.out.println(sendMailTasks);
    }

}
