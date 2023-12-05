package umc.spring.domain.mapping;


import lombok.*;
import lombok.experimental.SuperBuilder;
import umc.spring.domain.TermEntity;
import umc.spring.domain.UserEntity;
import umc.spring.domain.common.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "user_agree_term")
public class UserAgreeTermEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "term_id")
    private TermEntity term;


}
