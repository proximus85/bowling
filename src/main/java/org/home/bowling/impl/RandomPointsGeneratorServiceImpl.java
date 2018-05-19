package org.home.bowling.impl;

import javax.ejb.Stateless;

@Stateless
public class RandomPointsGeneratorServiceImpl {

    public Integer getRandomNumber(int maxRange) {
        return (int) Math.random() * maxRange;
    }
}
