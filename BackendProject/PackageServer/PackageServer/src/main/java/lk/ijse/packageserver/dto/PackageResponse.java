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
    private int nightCount;
    private String travelArea;
    private int totalHeadCount;
    private boolean petStatus;
    private double price;
}
