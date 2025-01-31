package com.pastebin.project;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/snippets")
public class PasteBinController {

    private final PasteBinService pasteBinService;

    public PasteBinController(PasteBinService pasteBinService){
        this.pasteBinService=pasteBinService;
    }

    // POST: Create a new snippet
    @PostMapping("/create")
    public ResponseEntity<PasteBin> createSnippet(@RequestBody PasteBin snippet) {
        return ResponseEntity.ok(pasteBinService.createSnippet(snippet));
    }

    // GET: Retrieve a snippet using its unique link
    @GetMapping("/view/{uniqueLink}")
    public ResponseEntity<PasteBin> getSnippet(@PathVariable String uniqueLink) {
        Optional<PasteBin> snippet = pasteBinService.getSnippet(uniqueLink);
        return snippet.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
