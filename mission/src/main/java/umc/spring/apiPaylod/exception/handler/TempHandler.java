package umc.spring.apiPaylod.exception.handler;

import umc.spring.apiPaylod.BaseErrorCode;
import umc.spring.apiPaylod.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode code) {
        super(code);
    }
}
