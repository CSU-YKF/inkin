package cn.csu.ykf.inkin.console;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.csu.ykf.inkin.console.mapper")
public class InkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(InkinApplication.class, args);
    }

}
