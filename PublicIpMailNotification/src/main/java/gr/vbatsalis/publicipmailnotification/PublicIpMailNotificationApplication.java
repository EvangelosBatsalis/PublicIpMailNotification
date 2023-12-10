package gr.vbatsalis.publicipmailnotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PublicIpMailNotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublicIpMailNotificationApplication.class, args);
    }

}
