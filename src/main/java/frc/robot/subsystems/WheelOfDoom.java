// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.DRIVE_CONST.*;

import static frc.robot.Constants.STICK_CONST.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class WheelOfDoom extends SubsystemBase {
  public WPI_TalonSRX WOD = new WPI_TalonSRX(WOD_CAN);
  public WheelOfDoom() {
    //
  }

  @Override
  public void periodic() {
    if (RobotContainer.stick.getRawButton(RED))
    {WOD.set(0.5);}
    else {WOD.stopMotor();}
  }
}
