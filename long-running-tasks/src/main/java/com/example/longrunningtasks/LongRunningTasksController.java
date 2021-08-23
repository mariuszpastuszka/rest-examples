package com.example.longrunningtasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@Slf4j
@RequestMapping("/api")
public class LongRunningTasksController {

    @PostMapping("/long-tasks")
    public ResponseEntity<LongRunningTask> performLongRunningTask() {
        return ResponseEntity
                .accepted()
                .location(ServletUriComponentsBuilder.fromCurrentRequest().build().toUri())
                .build();
    }

    @GetMapping("/long-tasks/{id}")
    public ResponseEntity<LongRunningTask> getStatusOfTask(@PathVariable("id") Long taskId) {
        log.info(ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/long-tasks/other").build().toString());
        return ResponseEntity
                .status(HttpStatus.SEE_OTHER)
                .location(ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/api/long-tasks/other").build().toUri())
                .build();
    }

    @GetMapping("/long-tasks/other")
    public void other() {
        log.info("other....");
    }
}
