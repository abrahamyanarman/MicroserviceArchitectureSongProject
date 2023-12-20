package com.song.resourceservice.service.impl;

import com.song.resourceservice.client.SongServiceClient;
import com.song.resourceservice.dto.SongDTO;
import com.song.resourceservice.entity.Resource;
import com.song.resourceservice.repository.ResourceRepository;
import com.song.resourceservice.service.ResourceService;

import org.apache.commons.lang3.StringUtils;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

@Service
public class ResourceServiceImpl implements ResourceService {

    private static final Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);

    private final static String FIELD_ID_NAME = "id";
    private final ResourceRepository resourceRepository;
    private final Parser audioParser;
    private final SongServiceClient songServiceClient;

    public ResourceServiceImpl(ResourceRepository resourceRepository, Parser audioParser, SongServiceClient songServiceClient) {
        this.resourceRepository = resourceRepository;
        this.audioParser = audioParser;
        this.songServiceClient = songServiceClient;
    }

    @Override
    public Long uploadResource(MultipartFile file) throws Exception {
        logger.info("{}: Uploading the file: {}", ResourceServiceImpl.class.getSimpleName(), file.getName());

        Metadata metadata = new Metadata();
        BodyContentHandler bodyContentHandler = new BodyContentHandler();
        ParseContext parseContext = new ParseContext();

        try (InputStream inputStream = new ByteArrayInputStream(file.getBytes())) {
            audioParser.parse(inputStream, bodyContentHandler, metadata, parseContext);

            Resource resource = new Resource();
            resource.setData(file.getBytes());
            resource = resourceRepository.save(resource);
            logger.info("{}: Resource with id: {} saved", ResourceServiceImpl.class.getSimpleName(), resource.getId());

            SongDTO songDTO = new SongDTO();
            songDTO.setResourceId(String.valueOf(resource.getId()));
            songDTO.setAlbum(StringUtils.defaultString(metadata.get("xmpDM:album")));
            songDTO.setArtist(StringUtils.defaultString(metadata.get("xmpDM:albumArtist")));
            songDTO.setYear(StringUtils.defaultString(metadata.get("xmpDM:releaseDate")));
            songDTO.setName(StringUtils.defaultString(metadata.get("dc:title")));
            songDTO.setLength(StringUtils.defaultString(metadata.get("xmpDM:duration")));
            ResponseEntity<Map<String, Long>> songResponse = songServiceClient.createSong(songDTO);

            if (songResponse.getStatusCode().is2xxSuccessful()) {
                logger.info("{}: Song with resourceId: {} saved", ResourceServiceImpl.class.getSimpleName(), resource.getId());
                return resource.getId();
            }
            logger.info("{}: Something went wrong rilling back resource with id: {}", ResourceServiceImpl.class.getSimpleName(), resource.getId());
            resourceRepository.delete(resource);
        }
        throw new Exception("ERROR-1004: Something went wrong, file not saved");
    }

    @Override
    public Optional<Resource> getResourceById(Long id) {
        return resourceRepository.findById(id);
    }

    @Override
    public void deleteResources(Long[] ids) {
        for (Long id : ids) {
            resourceRepository.deleteById(id);
        }
    }
}
