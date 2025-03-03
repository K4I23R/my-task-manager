package pl.michalsnella.mytaskmanager.utils.healthcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("health")
    public ResponseEntity<ApplicationStatus> checkHealth() {
//        return new ResponseEntity<>("OK", HttpStatus.OK);

        return ResponseEntity.ok(new ApplicationStatus(1));

//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .header("Content-Type", "text/plain;charset=UTF-8")
//                .body("OK");
    }
}
