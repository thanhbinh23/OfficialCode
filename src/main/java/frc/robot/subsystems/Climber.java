// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.DRIVE_CONST.*;

import static frc.robot.Constants.STICK_CONST.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Climber extends SubsystemBase {
  public WPI_TalonSRX Climber = new WPI_TalonSRX(CLIMBER_CAN);
  public Climber() {
    //
  }

  public void climb() {
    Climber.set(1);
  }
  public void stop() {
    Climber.stopMotor();
  }
}
