// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.STICK_CONST.*;
import static frc.robot.Constants.DRIVE_CONST.*;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class Drivebase extends SubsystemBase {

  public WPI_TalonSRX leftMaster = new WPI_TalonSRX(LEFT_MASTER_CAN);
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX(RIGHT_MASTER_CAN);
  public WPI_TalonSRX leftFollow = new WPI_TalonSRX(LEFT_FOLLOW_CAN);
  public WPI_TalonSRX rightFollow = new WPI_TalonSRX(RIGHT_FOLLOW_CAN);

  public Drivebase() {
    leftFollow.follow(leftMaster);
    leftFollow.setNeutralMode(NeutralMode.Brake);
    leftMaster.setNeutralMode(NeutralMode.Brake);
    rightFollow.setNeutralMode(NeutralMode.Brake);
    rightMaster.setNeutralMode(NeutralMode.Brake);

    rightFollow.follow(rightMaster);
    leftMaster.setInverted(true);
    leftFollow.setInverted(true);
  }

  public void drive(double x, double y) {
    leftMaster.set(x);
    rightMaster.set(y);
  }

  @Override
  public void periodic() {
    if (RobotContainer.logitech.getRawButton(8) && RobotContainer.logitech.getRawButton(7)) {
      drive(RobotContainer.logitech.getRawAxis(1) * 1, RobotContainer.logitech.getRawAxis(3) * 1);

    } else if (RobotContainer.logitech.getRawButton(8)) {
      drive(RobotContainer.logitech.getRawAxis(1) * 0.35, RobotContainer.logitech.getRawAxis(3) * 1);
    } else if (RobotContainer.logitech.getRawButton(7)) {
      drive(RobotContainer.logitech.getRawAxis(1) * 1, RobotContainer.logitech.getRawAxis(3) * 0.35);
    } else {
      drive(RobotContainer.logitech.getRawAxis(1) * 1, RobotContainer.logitech.getRawAxis(3) * 1);
    }
  }

}
