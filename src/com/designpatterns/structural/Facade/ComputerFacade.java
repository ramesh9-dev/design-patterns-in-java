package com.designpatterns.structural.Facade;

public class ComputerFacade {

    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        cpu = new CPU();
        memory = new Memory();
        hardDrive = new HardDrive();
    }

    public void start() {
        System.out.println("Starting computer...");
        cpu.freeze();
        byte[] bootSector = hardDrive.read(0, 1024);
        memory.load(0, bootSector);
        cpu.jump(0);
        cpu.execute();
        System.out.println("Computer started successfully!");
    }
}