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
    private int nightCount;
    private String travelArea;
    private int totalHeadCount;
    private boolean petStatus;
    private double price;
}
