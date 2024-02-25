package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LEVEL: TRACE > DEBUG > INFO > WARN > ERROR
 */
@Slf4j
@RestController
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);

        log.trace("trace log = {}", name);
        log.debug("debug log = {}", name);
        log.info("info log = {}", name);
        log.warn("warn log = {}", name);
        log.error("error log = {}", name);

        /**
         * 아래처럼 log를 사용하면 level설정에 따라서 log는 출력되지 않지만
         * 문자열 연산은 무조건 일어나게 되어 쓸모 없는 리소스를 사용하게 된다.
         */
        log.trace("String concat log = " + name);

        return "ok";
    }
}
