package com.example.demo.service;

import com.example.demo.entity.IPO;
import com.example.demo.repository.IpoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IpoService {

    private final IpoRepository ipoRepository;

    public IpoService(IpoRepository ipoRepository) {
        this.ipoRepository = ipoRepository;
    }

    public List<IPO> recommend(Double minRate, Integer maxPrice, String market, String industry,
                               String sort, LocalDate startDate, LocalDate endDate) {

        List<IPO> result = ipoRepository.findAll().stream()
                .filter(ipo -> minRate == null || ipo.getCompetitionRate() >= minRate)
                .filter(ipo -> maxPrice == null || ipo.getOfferingPrice() <= maxPrice)
                .filter(ipo -> market == null || market.isEmpty() || ipo.getMarket().equals(market))
                .filter(ipo -> industry == null || industry.isEmpty() || ipo.getCompany().getIndustry().equals(industry))
                .filter(ipo -> startDate == null || !ipo.getIpoDate().isBefore(startDate))
                .filter(ipo -> endDate == null || !ipo.getIpoDate().isAfter(endDate))
                .collect(Collectors.toList());

        // 정렬 조건 적용
        if ("rateDesc".equals(sort))  result.sort(Comparator.comparing(IPO::getCompetitionRate).reversed());
        if ("rateAsc".equals(sort))   result.sort(Comparator.comparing(IPO::getCompetitionRate));
        if ("priceDesc".equals(sort)) result.sort(Comparator.comparing(IPO::getOfferingPrice).reversed());
        if ("priceAsc".equals(sort))  result.sort(Comparator.comparing(IPO::getOfferingPrice));
        if ("dateDesc".equals(sort))  result.sort(Comparator.comparing(IPO::getIpoDate).reversed());
        if ("dateAsc".equals(sort))   result.sort(Comparator.comparing(IPO::getIpoDate));

        return result;
    }
}
