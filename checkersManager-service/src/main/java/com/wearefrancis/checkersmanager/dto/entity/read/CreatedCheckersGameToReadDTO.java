package com.wearefrancis.checkersmanager.dto.entity.read;

import com.wearefrancis.checkersmanager.dto.DTO;
import com.wearefrancis.checkersmanager.dto.entity.Token;
import lombok.Data;

@Data
public class CreatedCheckersGameToReadDTO implements DTO {
    private CheckersGameToReadDTO checkersGame;
    private Token playerToken;
}
