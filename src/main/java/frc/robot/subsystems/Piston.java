// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Piston extends SubsystemBase {
  /** Creates a new Piston. */
  public DoubleSolenoid s1 = new DoubleSolenoid(0,1);
  public Compressor c = new Compressor();
  boolean enabled = c.enabled();
  boolean pressureSwitch = c.getPressureSwitchValue();
  double current = c.getCompressorCurrent();

  public Piston() {
    //
  }
  @Override
  public void periodic() {
    if (RobotContainer.stick.getRawButton(1)) {
      s1.set(Value.kReverse);
    }
    else if (RobotContainer.stick.getRawButton(2)) {
      s1.set(Value.kForward);
    }
    else {
      s1.set(Value.kOff);
    }
  }
}
