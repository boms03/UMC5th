package umc.spring.service.MissionService;

import umc.spring.domain.MissionEntity;
import umc.spring.domain.RestaurantEntity;

import java.util.Optional;

public interface MissionQueryService {
    Optional<MissionEntity> findMission(Long id);
}
