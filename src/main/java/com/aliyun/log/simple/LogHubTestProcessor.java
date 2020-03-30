package com.aliyun.log.simple;

import java.util.List;

import com.aliyun.openservices.log.common.LogGroupData;
import com.aliyun.openservices.loghub.client.ILogHubCheckPointTracker;
import com.aliyun.openservices.loghub.client.interfaces.ILogHubProcessor;


public class LogHubTestProcessor implements ILogHubProcessor {

    @Override
    public void initialize(int shardId) {
    }

    @Override
    public String process(List<LogGroupData> logGroups,
                          ILogHubCheckPointTracker checkPointTracker) {
        return null;
    }

    @Override
    public void shutdown(ILogHubCheckPointTracker checkPointTracker) {
    }

}
