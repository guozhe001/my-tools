package com.guozhe.practice.notify;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.*;

/**
 * Server酱通知实现类 https://sct.ftqq.com/
 *
 * @author guozhe
 */
@Slf4j
public class NotifyServiceFtImpl implements NotifyService<FtNotifyRequest, FtNotifyResponse> {

    private final String notifyUrl;

    private static final ExecutorService executorService = new ThreadPoolExecutor(1, 2, 60L, TimeUnit.SECONDS,
        new LinkedBlockingQueue<>(), new ThreadFactoryBuilder().setNameFormat("notify%s").build());

    private final RestTemplate restTemplate;

    public NotifyServiceFtImpl(RestTemplate restTemplate, String notifyUrl) {
        this.restTemplate = restTemplate;
        this.notifyUrl = notifyUrl;
    }

    @Override
    public FtNotifyResponse notify(FtNotifyRequest request) {
        String urlWithTitle = String.format("%s?title=%s&desp=%s", notifyUrl, request.getTitle(), request.getDesp());
        return notifyAsynchronous(urlWithTitle, request);
    }

    private FtNotifyResponse notifyAsynchronous(String urlWithTitle, FtNotifyRequest request) {
        Future<FtNotifyResponse> submit = executorService.submit(() -> notify(urlWithTitle, request));
        try {
            return submit.get();
        } catch (InterruptedException | ExecutionException e) {
            if (log.isErrorEnabled()) {
                log.error("notify Exception, urlWithTitle={}, request={}", urlWithTitle, JSON.toJSONString(request), e);
            }
        }
        return null;
    }

    private FtNotifyResponse notify(String urlWithTitle, FtNotifyRequest request) {
        log.info("url={} request body={}", urlWithTitle, JSON.toJSONString(request));
        return restTemplate.postForObject(urlWithTitle, request, FtNotifyResponse.class);
    }

}
