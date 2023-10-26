package lk.ijse.packageserver.util;

import lk.ijse.packageserver.dto.BookingDTO;
import lk.ijse.packageserver.dto.PackageDTO;
import lk.ijse.packageserver.enetity.BookingEntity;
import lk.ijse.packageserver.enetity.PackageEntity;
import lk.ijse.packageserver.server.BookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataConvertor {

    //ModelMapper instance to handle object mapping
    private final ModelMapper modelMapper;
    // Constructor to initialize the ModelMapper
    public DataConvertor(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


   //---------------------------------PACKAGE-------------------------------------------------

    // Converts a PackageDTO to a PackageEntity
    public PackageEntity getPackageEntity(PackageDTO packageDTO) {
        // Using ModelMapper to map fields from packageDTO to a new PackageEntity
         return modelMapper.map(packageDTO, PackageEntity.class);
    }

    // Converts a PackageEntity to a PackageDTO (returned as an Object)
    public PackageDTO getPackageDTO(PackageEntity packageEntity) {
        // Using ModelMapper to map fields from packageEntity to a new PackageDTO
        return modelMapper.map(packageEntity, PackageDTO.class);
    }

    // Converts a List of PackageEntity to a List of PackageDTO
    public List<PackageDTO> pacackageDTOtoPackageDTOList(List<PackageEntity> packages){
        // Using ModelMapper to map a List of PackageEntity to a List of PackageDTO
        // The TypeToken is used to specify the destination type as List<PackageDTO>
        return modelMapper.map(packages,new TypeToken<List<PackageDTO>>(){}.getType());
    }

    //------------------------------BOOKING-----------------------------------------------------

    // Converts a bookingDTO to a bookingEntity
    public BookingEntity getBookingEntity(BookingDTO bookingDTO) {
        // Using ModelMapper to map fields from bookingDTO to a new bookingEntity
        return modelMapper.map(bookingDTO, BookingEntity.class);
    }

    // Converts a bookingEntity to a bookingDTO
    public BookingDTO getBookingDTO(BookingEntity bookingEntity){
        return modelMapper.map(bookingEntity, BookingDTO.class);
    }



}
