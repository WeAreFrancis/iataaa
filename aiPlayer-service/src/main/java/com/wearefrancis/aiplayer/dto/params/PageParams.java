package com.wearefrancis.aiplayer.dto.params;

import com.wearefrancis.aiplayer.dto.DTO;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
public class PageParams implements DTO {
    @Min(0)
    @Max(Integer.MAX_VALUE)
    private int page;
    @Min(1)
    @Max(50)
    private int perPage;

    public PageParams() {
        this.page = 0;
        this.perPage = 10;
    }
}
