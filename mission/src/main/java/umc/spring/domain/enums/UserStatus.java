package umc.spring.domain.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public enum UserStatus {
    ACTIVE("등록"),
    DEACTIVATED("해지")
    ;
    private String description;
}
