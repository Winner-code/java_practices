
import com.entity.User;
import com.rabbit.RabbitPublisherApp;
import com.rabbit.fanoutsender.UserMessageSender;
import com.rabbit.directsender.LogMessageSender;
import com.rabbit.topicsender.TopicMessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

/**
 * 消息发送者测试类型
 */
@SpringBootTest(classes = {RabbitPublisherApp.class})
@RunWith(SpringRunner.class)
public class TestPublisher {
    @Autowired(required = false)
    private LogMessageSender sender;
    @Autowired(required = false)
    private UserMessageSender userMessageSender;
    @Autowired(required = false)
    private TopicMessageSender topicMessageSender;

    private String exchange = "log-ex-direct";
    private String rkInfo = "direct-rk-info";
    private String rkError = "direct-rk-error";
    private String rkWarn = "direct-rk-warn";

    @Test
    public void testSendMessage2Topic(){
        // 随机数%6
        // 0 rk - user.rk.sms *.rk.*  *.rk.sms
        // 1 rk - user.rk.email   *.rk.* *.rk.email
        // 2 rk - order.rk.sms *.rk.*  *.rk.sms
        // 3 rk - order.rk.email  *.rk.* *.rk.email
        // 4 rk - reg.rk.sms *.rk.*  *.rk.sms
        // 5 rk - reg.rk.qq  *.rk.*
        Random r = new Random();
        for(int i = 0; i < 10; i++){
            int rInt = r.nextInt(100);
            if(rInt%6 == 0){
                this.topicMessageSender.send("ex-topic",
                        "user.rk.sms",
                        "用户登录验证码是123456 - 发送短信");
            }else if(rInt%6 == 1){
                this.topicMessageSender.send("ex-topic",
                        "user.rk.email",
                        "用户登录验证码是123456 - 发送到邮箱");
            }else if(rInt%6 == 2){
                this.topicMessageSender.send("ex-topic",
                        "order.rk.sms",
                        "订单下订成功 - 发送短信");
            }else if(rInt%6 == 3){
                this.topicMessageSender.send("ex-topic",
                        "order.rk.email",
                        "订单下订成功 - 发送到邮箱");
            }else if(rInt%6 == 4){
                this.topicMessageSender.send("ex-topic",
                        "reg.rk.sms",
                        "注册验证码是654321 - 发送短信");
            }else if(rInt%6 == 5){
                this.topicMessageSender.send("ex-topic",
                        "reg.rk.qq",
                        "注册验证码是654321 - 发送QQ信息");
            }
        }
    }

    @Test
    public void testSendUserMessage2Fanout(){
        for(int i = 0; i < 3; i++){
            User user = new User();
            user.setId((long) i);
            user.setName("姓名 - " + i);
            user.setAge(20+i);

            this.userMessageSender.send(user);
        }
    }

    @Test
    public void testSend2Consumers(){
        for(int i = 0; i < 10; i++){
            this.sender.sendMessage(exchange, rkInfo, "info消息"+i);
            this.sender.sendMessage(exchange, rkError, "error消息"+i);
            this.sender.sendMessage(exchange, rkWarn, "warn消息"+i);
        }
    }

    @Test
    public void testdirect(){
        Random r = new Random();
        // 发送10条消息。
        for(int i = 0 ; i < 10; i++){
            // rInt%3 - 0：投递消息到info；1：投递消息到error；2：投递消息到warn
            int rInt = r.nextInt(100);
            if(rInt%3 == 0){
                this.sender.sendMessage(exchange, rkInfo, "发送Info日志消息 - index="+i+"；rInt="+rInt);
            }else if(rInt%3 == 1){
                this.sender.sendMessage(exchange, rkError, "发送error日志消息 - index="+i+"；rInt="+rInt);
            }else{
                this.sender.sendMessage(exchange, rkWarn, "发送warn日志消息 - index="+i+"；rInt="+rInt);
            }
        }
    }
}
