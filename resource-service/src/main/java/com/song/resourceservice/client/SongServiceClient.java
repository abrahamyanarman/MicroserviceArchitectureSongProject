package com.song.resourceservice.client;

import com.song.resourceservice.dto.SongDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "song-service")
public interface SongServiceClient {
    @PostMapping(value = "/songs")
    ResponseEntity<Map<String, Long>> createSong(@RequestBody SongDTO song);
}
