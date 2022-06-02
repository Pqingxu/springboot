package com.pan.entry.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author qingxu.pan@tophant.com
 * @Date 2022/4/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private Long id;
    private String uuid;
    private String username;
    private Integer age;
}
