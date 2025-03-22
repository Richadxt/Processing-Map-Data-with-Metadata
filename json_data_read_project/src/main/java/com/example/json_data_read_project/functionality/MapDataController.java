package com.example.json_data_read_project.functionality;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.json_data_read_project.dto.Metadata;

@RestController
@RequestMapping("/api/v1/mapdata")
public class MapDataController {

	@Autowired
    private MapDataService mapDataService;

    @GetMapping("/load")
    public String loadData() {
        try {
            mapDataService.loadData();
            return "Data Loaded Successfully!";
        } catch (IOException e) {
            return "Error Loading Data: " + e.getMessage();
        }
    }

    @GetMapping("/merged")
    public List<Map<String, Object>> getMergedData() {
        return mapDataService.mergeData();
    }

    @GetMapping("/valid-count")
    public Map<String, Long> getValidCounts() {
        return mapDataService.countValidPoints();
    }

    @GetMapping("/average-ratings")
    public Map<String, Double> getAverageRatings() {
        return mapDataService.calculateAverageRatings();
    }

    @GetMapping("/highest-reviews")
    public Metadata getHighestReviewedLocation() {
        return mapDataService.findHighestReviewedLocation();
    }

    @GetMapping("/incomplete-data")
    public List<String> getIncompleteLocations() {
        return mapDataService.findIncompleteLocations();
    }
}
