package umc.spring.service.TempSerivce;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPaylod.code.status.ErrorStatus;
import umc.spring.apiPaylod.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempCommandServiceImpl implements TempQueryService {
    @Override
    public void CheckFlag(Integer flag) {
        if(flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
