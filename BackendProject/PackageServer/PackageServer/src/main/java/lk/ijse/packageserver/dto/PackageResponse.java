package lk.ijse.packageserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackageResponse {
    private String packageId;
    private String packageCategory;
    private double price;
    private int nightCount;
    private int dayCount;
    private int totalHeadCount;
}
