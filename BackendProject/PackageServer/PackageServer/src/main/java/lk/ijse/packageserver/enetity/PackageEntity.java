package lk.ijse.packageserver.enetity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Package")
public class PackageEntity implements SuperEntity{
    @Id
    private String packageId;
    private String packageCategory;
    private double price;
    private int nightCount;
    private int dayCount;
    private int totalHeadCount;


}
