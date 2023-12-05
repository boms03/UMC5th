package umc.spring.domain.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserGender {
    MALE("남자"),
    FEMALE("여자"),

    ;
    private String description;
}
