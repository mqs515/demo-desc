package com.test.demo.test.commmon;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Slf4j
public class RandomMsg {

    private final Object descLock = new Object();
    private volatile List<String> descriptions = Collections.emptyList();

    public String randomDesc() {
        if (descriptions.isEmpty()) {
            synchronized (descLock) {
                if (descriptions.isEmpty()) {
                    try {
                        // 读取文件中的内容
                        InputStream is = this.getClass().getResourceAsStream("/descriptions.txt");
                        descriptions = IOUtils.readLines(is);
                        IOUtils.closeQuietly(is);
                    } catch (Exception e) {
                        log.warn("读取 descriptions.txt出 错", e);
                    }
                }
            }
        }
        // 随机获取文件中的一条内容
        return descriptions.get(new Random().nextInt(descriptions.size()));
    }


}
