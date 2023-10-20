package lk.ijse.packageserver.enetity;

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
public class PackageEntity implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String packageId;
    @Column(nullable = false)
    private String packageCategory;
    @Column(nullable = false)
    private int nightCount;
    @Column(nullable = false)
    private String travelArea;
    @Column(nullable = false)
    private int totalHeadCount;
    @Column(nullable = false)
    private boolean petStatus;
    @Column(nullable = false)
    private double price;
}
