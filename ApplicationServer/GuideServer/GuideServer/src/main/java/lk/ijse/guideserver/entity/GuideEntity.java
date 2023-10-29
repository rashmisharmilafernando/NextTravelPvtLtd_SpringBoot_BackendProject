package lk.ijse.guideserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GuideEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String guideId;
    @Column(nullable = false)
    private String guideName;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private String experience;
    @Column(nullable = false)
    private double manDayValue;
    @Column(nullable = false)
    private String guideImage;
    @Column(nullable = false)
    private String nicImage;
    @Column(nullable = false)
    private String GuideIDImage;
}
