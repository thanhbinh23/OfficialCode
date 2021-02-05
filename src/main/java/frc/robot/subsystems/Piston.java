// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Piston extends SubsystemBase {
  /** Creates a new Piston. */
  public Solenoid s1 = new Solenoid(0);
  public Piston() {
  }
  @Override
  public void periodic() {
    if (RobotContainer.stick.getRawButton(1)) {
      s1.toggle();
    }
  }
}

