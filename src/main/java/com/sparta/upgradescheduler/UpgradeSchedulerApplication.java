package com.sparta.upgradescheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class UpgradeSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpgradeSchedulerApplication.class, args);
    }

}
