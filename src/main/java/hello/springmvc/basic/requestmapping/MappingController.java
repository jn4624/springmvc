package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 기본 요청
     * HTTP 메서드 모두 허용
     */
    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    /**
     * 특정 HTTP 메서드 요청만 허용
     */
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    /**
     * 편리한 축약 애노테이션
     */
    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mappingGetV2");
        return "ok";
    }

    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     * @PathVariable("userId") String userId -> @PathVariable String userId
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId = {}", data);
        return "ok";
    }

    /**
     * PathVariable 다중 사용
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable("userId") String userId, @PathVariable("orderId") Long orderId) {
        log.info("mappingPath userId = {}, orderId = {}", userId, orderId);
        return "ok";
    }

    /**
     * 특정 파라미터 조건 매핑
     * params="mode"
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug" (! = )
     * params={"mode=debug", "data=good"}
     * URL 매핑 정보와 파라미터 정보가 일치해야 정상적으로 요청된다.
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 특정 헤더 조건 매핑
     * params="mode"
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug" (! = )
     * URL 매핑 정보와 헤더 정보가 일치해야 정상적으로 요청된다.
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * 미디어 타입 조건 매핑 - HTTP 요청
     * Content-Type 헤더 기반 추가 매핑 MediaType
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsume() {
        log.info("mappingConsume");
        return "ok";
    }

    /**
     * 미디어 타입 조건 매핑 - HTTP 요청
     * Accept 헤더 기반 MediaType
     * produces="text/html"
     * produces="!text/html"
     * produces="text/*"
     * produces="*\/*"
     * MediaType.TEXT_HTML_VALUE
     */
    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduce() {
        log.info("mappingProduce");
        return "ok";
    }
}
