package umc.spring.domain.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserMissionStatus {
    COMPLETE("완료"),
    PROCEEDING("진행중")

    ;

    private String description;


}
