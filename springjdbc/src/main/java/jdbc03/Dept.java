package jdbc03;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private Integer deptno;
    private String dname;
    private String loc;

    public Dept(String dname, String loc) {
        this.dname = dname;
        this.loc = loc;
    }
}
