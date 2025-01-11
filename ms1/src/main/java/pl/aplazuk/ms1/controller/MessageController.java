package pl.aplazuk.ms1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MessageController {

    @Value("${message:wiem, że nic nie wiem}")
    private String message;

    @GetMapping("/hello")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok(this.message);
    }
}
