package umc.spring.domain;

import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.UserGender;
import umc.spring.domain.enums.UserStatus;
import umc.spring.domain.mapping.UserAgreeTermEntity;
import umc.spring.domain.mapping.UserFavouriteFoodCategoryEntity;
import umc.spring.domain.mapping.UserMissionEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

    @Column(length =20, nullable = false)
    private String name;

    @Column(length =20, nullable = false)
    private String nickname;

    @Column(length =20, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserGender gender;

    private LocalDate birth;

    @Column(length =20, nullable = false)
    private String email;

    @Column(length =20, nullable = false)
    private String phoneNumber;

    @Column(length =50, nullable = false)
    private String address;

    private Integer point;

    @Column(length =15, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private LocalDateTime inactiveDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserAgreeTermEntity> userAgreeTermEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserFavouriteFoodCategoryEntity> userFavoruiteFoodCategoryEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMissionEntity> userMissionEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ReviewEntity> reviewEntityList = new ArrayList<>();

}
