package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExtSystemsError {
    private String code;
    private String date;
    private String log;
    private int priority;
}
