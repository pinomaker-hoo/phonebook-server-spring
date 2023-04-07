package pinomaker.phonebook.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pinomaker.phonebook.common.entity.BaseTimeEntity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_phone")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Phone extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "phone_idx")
    private Long idx;

    @Column(name = "phone_name")
    private String name;

    @Column(name = "phone_number")
    private String number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_idx")
    private User user;
}
