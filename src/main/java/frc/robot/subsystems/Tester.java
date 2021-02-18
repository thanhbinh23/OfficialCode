// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Tester extends SubsystemBase {
  public WPI_TalonSRX test1 = new WPI_TalonSRX(1);
  public WPI_TalonSRX test2 = new WPI_TalonSRX(2);
  public WPI_TalonSRX test3 = new WPI_TalonSRX(3);
  public WPI_TalonSRX test4 = new WPI_TalonSRX(4);
  public WPI_TalonSRX test5 = new WPI_TalonSRX(5);
  public Tester(){
    //
  }
  public void test() {
    test1.set(0.5);
    test2.set(0.5);
    test3.set(0.5);
    test4.set(0.5);
    test5.set(0.5);
  }
  public void stop() {
    test1.set(0);
    test2.set(0);
    test3.set(0);
    test4.set(0);
    test5.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
