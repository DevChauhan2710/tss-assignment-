package com.tss.entities;

import com.tss.enumm.MarkType;

public class Player
{
    private final String nameOfPlayer;
    private final MarkType markType;

    public Player(String nameOfPlayer, MarkType markType) {
        this.nameOfPlayer = nameOfPlayer;
        this.markType = markType;
    }

    public char getSymbol()
    {
        return markType.name().charAt(0);
    }

    public String getNameOfPlayer() {
        return nameOfPlayer;
    }
}
