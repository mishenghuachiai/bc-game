package com.user.controller.apiImpl;

import com.user.api.common.api.Result;
import com.user.api.facade.UserFacade;
import com.user.api.response.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@RestController
public class UserController implements UserFacade {
    private final String basePath = "E:/testIOMax/io_stress_test_";
    private final int threadCount = 100;      // 🔥 IO 压测线程数（推荐 >= CPU 数 * 4）
    private final int blockSizeMB = 50;       // 🔥 每次写多少 MB
    private volatile boolean running = false;
    private ExecutorService executorService;
    /**
     * 只要传id就停止，不传id就开始
     *
     * @param id
     * @return
     */
    @Override
    public Result<UserResponse> getUserById(@PathVariable(value = "id") Integer id) {
        log.info("hello: {}",id);
        if (running) {
            log.info("IO Load already running");
        }
        running = true;
        //id=0停止写入
        if (0==id) {
            if (executorService != null) {
                executorService.shutdownNow(); // 强制停止线程
            }
        }
        //id=2删除
        if(2==id) {
            int delCount = 0;
            File dir = new File(basePath);
            if (dir.exists() && dir.isDirectory()) {
                File[] files = dir.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile() && file.delete()) {
                            delCount++;
                        }
                    }
                }
            }
            log.info("IO deleted : {}",delCount);
        }
        executorService = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {
            int index = i;
            executorService.submit(() -> {
                byte[] data = new byte[blockSizeMB * 1024 * 1024];
//                byte[] data = new byte[1];
                new Random().nextBytes(data);

                String path = basePath + index + ".bin";

                while (running) {
                    try (FileOutputStream fos = new FileOutputStream(path, true)) {
                        fos.write(data);
                        fos.flush();  // 🔥 强制刷新，IO 压力更大
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        return Result.success();
    }
}