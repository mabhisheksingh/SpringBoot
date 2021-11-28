package publicissapient.com.pojos;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "IMAGE")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = " it is primary key in long ",notes = "This is unique in DB Image tables")
    private Long id;
    @Column(name = "PHOTO")
    @Lob
    private byte[] photo;
    private String photoName;
    private Long size;
}
