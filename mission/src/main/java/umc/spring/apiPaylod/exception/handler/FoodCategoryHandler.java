package umc.spring.apiPaylod.exception.handler;

import umc.spring.apiPaylod.BaseErrorCode;
import umc.spring.apiPaylod.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode code) {
        super(code);
    }
}
