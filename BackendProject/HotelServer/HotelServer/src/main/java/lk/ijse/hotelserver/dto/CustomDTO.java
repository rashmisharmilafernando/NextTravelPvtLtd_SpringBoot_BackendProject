package lk.ijse.hotelserver.dto;

public class CustomDTO {
    private String value;
    private int count;

    public CustomDTO(String lastIndex){
        this.value=lastIndex;
    }
    public CustomDTO(int count){
        this.count=count;
    }
}
