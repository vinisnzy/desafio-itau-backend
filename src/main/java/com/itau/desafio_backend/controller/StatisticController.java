package com.itau.desafio_backend.controller;

import com.itau.desafio_backend.dto.StatisticResponse;
import com.itau.desafio_backend.service.StatisticService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatistica")
public class StatisticController {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping
    public ResponseEntity<StatisticResponse> getStatistic() {
        StatisticResponse statisticResponse = statisticService.createStatistic();
        return ResponseEntity.ok().body(statisticResponse);
    }
}
