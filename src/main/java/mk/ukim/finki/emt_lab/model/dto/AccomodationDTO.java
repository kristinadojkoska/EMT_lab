package mk.ukim.finki.emt_lab.model.dto;

import lombok.Data;
import mk.ukim.finki.emt_lab.model.Category;

@Data
public class AccomodationDTO {
String name;
Category category;
Long hostId;
Integer numRooms;
}
