package com.user.controller.apiImpl;

import com.user.api.common.api.Result;
import com.user.api.facade.UserFacade;
import com.user.api.response.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@RestController
public class UserController implements UserFacade {
    // 固定线程池：根据 CPU 核心数自动配置
    private final ExecutorService executor =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private final ScheduledExecutorService scheduler =
            Executors.newSingleThreadScheduledExecutor();

    /**
     * 想要CPU极限拉满用参数 bits=32768&certainty=50&seconds=999999999
     * CPU极低负载参数bits=128&certainty=1&seconds=5
     * @param id
     * @return
     */
    @Override
    public Result<UserResponse> getUserById(@PathVariable(value = "id") Integer id) {
          log.info("hello");
        Integer bits= 32768;
        Integer certainty = 50;
        Integer seconds  = 999999999;
        // 默认参数
        int _bits = bits == null ? 4096 : bits;
        int _certainty = certainty == null ? 20 : certainty;
        int _seconds = seconds == null ? 30 : seconds;

        int threads = Runtime.getRuntime().availableProcessors();

        AtomicBoolean running = new AtomicBoolean(true);
        AtomicLong checks = new AtomicLong(0);

        // 启动 CPU 密集型 worker
        for (int i = 0; i < threads; i++) {
            executor.submit(new PrimeWorker(_bits, _certainty, running, checks));
        }

        // 定时停止任务
        scheduler.schedule(() -> running.set(false), _seconds, TimeUnit.SECONDS);

        return Result.success();
    }
}
// Worker 逻辑（与之前一样）
 class PrimeWorker implements Runnable {
    private final int bits;
    private final int certainty;
    private final AtomicBoolean running;
    private final AtomicLong checks;
    private final SecureRandom rnd = new SecureRandom();

    PrimeWorker(int bits, int certainty, AtomicBoolean running, AtomicLong checks) {
        this.bits = bits;
        this.certainty = certainty;
        this.running = running;
        this.checks = checks;
    }

    @Override
    public void run() {
        while (running.get()) {
            BigInteger candidate = new BigInteger(bits, rnd).setBit(0);
            candidate.isProbablePrime(certainty);
            checks.incrementAndGet();
        }
    }
}