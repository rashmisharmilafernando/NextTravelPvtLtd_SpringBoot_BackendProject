package lk.ijse.packageserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PackageDTO {
    private String packageId;
    private String packageCategory;
    private double price;
    private int nightCount;
    private int dayCount;
    private int totalHeadCount;

}
