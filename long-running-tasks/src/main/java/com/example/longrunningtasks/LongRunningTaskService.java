package com.example.longrunningtasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class LongRunningTaskService {

    private Map<Long, LongRunningTask> longRunningTasks = new HashMap<>();

    public UUID recordAsyncTask(LongRunningTask task) {
        longRunningTasks.put(task.id(), task);
        return UUID.randomUUID();
    }
}
