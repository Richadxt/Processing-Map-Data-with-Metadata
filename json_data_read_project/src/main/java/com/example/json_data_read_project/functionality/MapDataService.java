package com.example.json_data_read_project.functionality;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.json_data_read_project.dto.Location;
import com.example.json_data_read_project.dto.Metadata;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class MapDataService {

	private static final String LOCATION_JSON = "src/main/resources/locations.json";
    private static final String METADATA_JSON = "src/main/resources/metadata.json";

    private List<Location> locations;
    private List<Metadata> metadataList;

    public void loadData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        
        // Load Location Data
        locations = objectMapper.readValue(Paths.get(LOCATION_JSON).toFile(), new TypeReference<>() {});
        
        // Load Metadata
        metadataList = objectMapper.readValue(Paths.get(METADATA_JSON).toFile(), new TypeReference<>() {});
    }

    // Merge Data Based on ID
    public List<Map<String, Object>> mergeData() {
        Map<String, Metadata> metadataMap = metadataList.stream()
                .collect(Collectors.toMap(Metadata::getId, meta -> meta));

        return locations.stream().map(loc -> {
            Map<String, Object> merged = new HashMap<>();
            merged.put("id", loc.getId());
            merged.put("latitude", loc.getLatitude());
            merged.put("longitude", loc.getLongitude());

            Metadata meta = metadataMap.get(loc.getId());
            if (meta != null) {
                merged.put("type", meta.getType());
                merged.put("rating", meta.getRating());
                merged.put("reviews", meta.getReviews());
            } else {
                merged.put("type", "Unknown");
                merged.put("rating", 0.0);
                merged.put("reviews", 0);
            }
            return merged;
        }).toList();
    }

    // Count Valid Points per Type
    public Map<String, Long> countValidPoints() {
        return metadataList.stream()
                .collect(Collectors.groupingBy(Metadata::getType, Collectors.counting()));
    }

    // Calculate Average Rating per Type
    public Map<String, Double> calculateAverageRatings() {
        return metadataList.stream()
                .collect(Collectors.groupingBy(
                        Metadata::getType,
                        Collectors.averagingDouble(Metadata::getRating)
                ));
    }

    // Find Location with Highest Reviews
    public Metadata findHighestReviewedLocation() {
        return metadataList.stream()
                .max(Comparator.comparingInt(Metadata::getReviews))
                .orElse(null);
    }

    // Identify Locations with Incomplete Data
    public List<String> findIncompleteLocations() {
        Set<String> metadataIds = metadataList.stream()
                .map(Metadata::getId)
                .collect(Collectors.toSet());

        return locations.stream()
                .filter(loc -> !metadataIds.contains(loc.getId()))
                .map(Location::getId)
                .toList();
    }

}
