package umc.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.UserAgreeTermEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "term")
public class TermEntity extends BaseEntity {

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String content;
    @Column(nullable = false)
    private boolean required;

    @OneToMany(mappedBy = "term", cascade = CascadeType.ALL)
    private List<UserAgreeTermEntity> userAgreeTermEntityList = new ArrayList<>();

}
