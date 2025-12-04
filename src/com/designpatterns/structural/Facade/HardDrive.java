package com.designpatterns.structural.Facade;

public class HardDrive {
    public byte[] read(long lba, int size) {
        System.out.println("Reading " + size + " bytes from HDD at " + lba);
        return new byte[size];
    }
}