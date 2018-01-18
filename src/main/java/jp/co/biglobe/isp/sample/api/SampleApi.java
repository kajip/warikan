package jp.co.biglobe.isp.sample.api;

import jp.co.biglobe.isp.sample.service.GreetingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * API層的な何か。SpringBoot を実行するとこいつが呼ばれる
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@RestController
public class SampleApi {

    private final GreetingService service;

    @RequestMapping("/hello")
    @ResponseBody
    public String run(String... args) throws Exception {
        String result = service.greeting().hello();
        log.info("{}", result);

        return result;
    }
}
