package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.MissionEntity;
import umc.spring.domain.RestaurantEntity;
import umc.spring.repository.MissionRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionQueryImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public Optional<MissionEntity> findMission(Long id) {
        return missionRepository.findById(id);
    }
}
