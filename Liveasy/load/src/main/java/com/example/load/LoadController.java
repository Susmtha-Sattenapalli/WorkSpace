package com.example.load;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadService loadService;

    @PostMapping
    public ResponseEntity<String> addLoads(@RequestBody List<Load> loads) {
        return ResponseEntity.ok("Loads added successfully");
    }

    @GetMapping
    public List<Load> getLoadsByShipperId(@RequestParam UUID shipperId) {
        return loadService.getLoadsByShipperId(shipperId);
    }

    @GetMapping("/{loadId}")
    public Load getLoadById(@PathVariable UUID loadId) {
        return loadService.getLoadById(loadId);
    }

    @PutMapping("/{loadId}")
    public Load updateLoad(@PathVariable UUID loadId, @RequestBody Load loadDetails) {
        return loadService.updateLoad(loadId, loadDetails);
    }

    @DeleteMapping("/{loadId}")
    public String deleteLoad(@PathVariable UUID loadId) {
        loadService.deleteLoad(loadId);
        return "Load deleted successfully";
    }
}
