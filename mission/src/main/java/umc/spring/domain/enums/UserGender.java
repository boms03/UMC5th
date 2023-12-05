package umc.spring.domain.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserGender {
    MALE("남자"),
    FEMALE("여자"),
    NONE("없음")

    ;

    private String description;
}
