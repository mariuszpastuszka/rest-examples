package com.example.longrunningtasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/api")
public class LongRunningTasksController {

    private final LongRunningTaskService longRunningTaskService;

    public LongRunningTasksController(final LongRunningTaskService longRunningTaskService) {
        this.longRunningTaskService = longRunningTaskService;
    }

    @PostMapping("/long-tasks")
    public ResponseEntity<LongRunningTask> performLongRunningTask(@RequestBody LongRunningTask task) {
        // record user email
        // put on Kafka....
        // register as async task
        var id = longRunningTaskService.recordAsyncTask(task);
        return ResponseEntity
                .accepted()
                .location(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .replacePath("/task-in-progress")
                        .path("/" + id)
                        .build().toUri())
                .build();
    }

    @GetMapping("/task-in-progress/{id}")
    public ResponseEntity<LongRunningTask> getStatusOfTaskInProgress(@PathVariable("id") String taskId) {
        log.info(ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/long-tasks/other").build().toString());

        // check if task with taskId exists
        // if in progress - return status: 200 with progress in percentage :)
        // if not
        // check if there are results - redirect to end resource
        // if there's no results - 404

        return ResponseEntity
                .status(HttpStatus.SEE_OTHER)
                .location(ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/api/long-tasks/other").build().toUri())
                .build();
    }

    @DeleteMapping("/task-in-progress/{id}")
    public void tryToCancelTaskInProgress(@PathVariable("id") String taskId) {
        // trying to cancel task.....
    }


    @GetMapping("/long-tasks-results/{id}")
    public Object taskResult(@PathVariable("id") String id) {
        log.info("computed task results");
        log.info("returning computed task with id: [{}]", id);
        return new Object();
    }

    @DeleteMapping("/long-tasks-results/{id}")
    public void clearComputedTaskResult(@PathVariable String id) {
        log.info("clearing computed task with id: [{}}", id);
    }
}
