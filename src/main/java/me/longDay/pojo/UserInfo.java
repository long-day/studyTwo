package me.longDay.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 君
 * @version 1.0
 * @desc TODO
 * @since 2022-11-29
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfo {
    private String name;
    private Integer age;

}
