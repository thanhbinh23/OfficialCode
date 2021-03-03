/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Autonomous;
import frc.robot.commands.Open;
import frc.robot.commands.Shoot;
import frc.robot.commands.Spin;
import frc.robot.commands.Suck;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Piston;
import frc.robot.subsystems.Sucker;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.WheelOfDoom;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import static frc.robot.Constants.STICK_CONST.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  public final Drivebase drivebase = new Drivebase();
  private final Autonomous m_autoCommand = new Autonomous(drivebase);
  public static Joystick stick = new Joystick(0);
  public final Shooter shooter = new Shooter();
  public final Sucker sucker = new Sucker();
  public final WheelOfDoom WOD = new WheelOfDoom();
  public final Piston piston = new Piston();

  
  Command shoot = new Shoot(shooter);
  Command suck = new Suck(sucker, 0.4);
  Command spin = new Spin(WOD);
  Command Open = new Open(piston);

  



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    new JoystickButton(stick, L2).whileActiveOnce(suck);
    new JoystickButton(stick, R2).whileActiveOnce(shoot);
    new JoystickButton(stick, RED).whileActiveOnce(spin);
    new JoystickButton(stick, R1).whileActiveOnce(Open);
    
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
