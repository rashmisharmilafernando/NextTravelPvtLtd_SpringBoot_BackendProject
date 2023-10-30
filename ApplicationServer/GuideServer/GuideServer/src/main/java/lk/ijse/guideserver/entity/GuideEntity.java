package lk.ijse.guideserver.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GuideEntity {
    @Id

    private String guideId;

    private String guideName;

    private String address;

    private String gender;

    private String number;

    private String experience;

    private double manDayValue;

    private String guideImage;

    private String nicImage;

    private String GuideIDImage;
}
