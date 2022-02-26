package br.com.inthurn.VilaDevInHouse.service.restservice.report;

import br.com.inthurn.VilaDevInHouse.model.projections.VillagerWithIncome;
import br.com.inthurn.VilaDevInHouse.model.security.report.VillageReport;
import br.com.inthurn.VilaDevInHouse.repository.VillagerRepository;
import br.com.inthurn.VilaDevInHouse.service.restservice.villageService.VillageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;

@Service
public class ReportService {

    private final VillagerRepository villagerRepository;
    private final VillageService villageService;


    public ReportService(VillagerRepository villagerRepository, VillageService villageService) {
        this.villagerRepository = villagerRepository;
        this.villageService = villageService;
    }

    @Value("${village.budget}")
    private BigDecimal villageBudget;

    public VillageReport villageReport() throws SQLException {
        return new VillageReport(villageBudget, villagerRepository.villageCost(), villagerRepository.findTopByOrderByIncomeDesc());
    }

}
