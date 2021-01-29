// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.DRIVE_CONST.INTAKE_CAN;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Intake extends SubsystemBase {
  public WPI_TalonSRX Intake = new WPI_TalonSRX(INTAKE_CAN);

  public Intake() {
    //
  }

  @Override
  public void periodic() {
    if (RobotContainer.stick.getRawButton(2)) {
      Intake.set(0.9);
    } else {
      Intake.set(0);
    }
  }
}
