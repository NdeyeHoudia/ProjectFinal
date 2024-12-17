package com.Project9.MicroserviceGestationRisque.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="note-service", url="http://localhost:8083/notePatient")

public interface NoteClient {

    @GetMapping("/{id}/count-keyWord")
    public int countKeywordsInNote(
            @PathVariable String id,
            @RequestParam String[] keywords);

}
