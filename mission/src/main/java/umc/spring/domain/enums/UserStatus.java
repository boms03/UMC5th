package umc.spring.domain.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public enum UserStatus {
    REGISTERED("등록"),
    CHALLENGING("해지")
    ;
    private String description;
}
