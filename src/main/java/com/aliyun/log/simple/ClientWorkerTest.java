package com.aliyun.log.simple;

import com.aliyun.openservices.loghub.client.ClientWorker;
import com.aliyun.openservices.loghub.client.config.LogHubConfig;
import com.aliyun.openservices.loghub.client.exceptions.LogHubClientWorkerException;

public class ClientWorkerTest {

    private static final String TEST_PROJECT = "";
    private static final String TEST_ENDPOINT = "";
    private static final String TEST_LOGSTORE = "";
    private static final String ACCESS_KEY_ID = "";
    private static final String ACCESS_KEY = "";

    public static void main(String[] args) throws LogHubClientWorkerException,
            InterruptedException {
        int n = 1;
        Thread[] threads = new Thread[n];

        for (int i = 0; i < n; i++) {
            LogHubConfig config = new LogHubConfig(
                    "data-transform", "consumer_" + i,
                    TEST_ENDPOINT, TEST_PROJECT, TEST_LOGSTORE,
                    ACCESS_KEY_ID, ACCESS_KEY,
                    LogHubConfig.ConsumePosition.BEGIN_CURSOR);
            config.setHeartBeatIntervalMillis(10 * 1000);
            ClientWorker worker = new ClientWorker(new LogHubProcessorTestFactory(), config);
            threads[i] = new Thread(worker);
        }
        for (int i = 0; i < n; i++) {
            threads[i].start();
        }
        for (int i = 0; i < n; i++) {
            threads[i].join();
        }
    }

}
