package champion;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Champion {
    private String name;
    private String position;

//    public Champion(String champ, String pos) {
//        this.name = champ;
//        this.position = pos;
//    }
}