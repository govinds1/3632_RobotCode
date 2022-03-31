// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutoShootCommand;
import frc.robot.commands.DrivetrainControlCommand;
import frc.robot.commands.IntakeControlCommand;
import frc.robot.commands.ClimberControlCommand;
import frc.robot.commands.ShooterControlCommand;
import frc.robot.commands.autonomous.AutonOneBall;
import frc.robot.commands.autonomous.AutonTwoBall;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DrivetrainSubsystem m_drivetrain = new DrivetrainSubsystem();
  private final IntakeSubsystem m_intake = new IntakeSubsystem();
  private final ShooterSubsystem m_shooter = new ShooterSubsystem();
  private final ClimberSubsystem m_climber = new ClimberSubsystem();
  private final Joystick m_driverController = new Joystick(Constants.DRIVER_CONTROLLER);
  private final Joystick m_operatorController = new Joystick(Constants.OPERATOR_CONTROLLER);

  private final IntakeControlCommand m_intakeCommand = new IntakeControlCommand(m_intake, true);
  private final IntakeControlCommand m_outtakeCommand = new IntakeControlCommand(m_intake, false);
  private final ClimberControlCommand m_climbUpCommand = new ClimberControlCommand(m_climber, true);
  private final ClimberControlCommand m_climbDownCommand = new ClimberControlCommand(m_climber, false);
  private final ShooterControlCommand m_shooterSpinUpCommand = new ShooterControlCommand(m_shooter);
  private final DrivetrainControlCommand m_drivetrainControlCommand = new DrivetrainControlCommand(m_drivetrain, m_driverController);
  private final AutoShootCommand m_autoShootCommand = new AutoShootCommand(m_intake, m_shooter);

  private final AutonOneBall m_autonOneBall = new AutonOneBall(m_drivetrain, m_intake, m_shooter);
  private final AutonTwoBall m_autonTwoBall = new AutonTwoBall(m_drivetrain, m_intake, m_shooter);

  private final String[] autoList = {"One Ball", "Two Ball"};

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    SmartDashboard.putStringArray("Auto List", autoList);

    m_drivetrain.setDefaultCommand(m_drivetrainControlCommand);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(m_operatorController, Constants.INTAKE_BUTTON).whileHeld(m_intakeCommand);
    new JoystickButton(m_operatorController, Constants.OUTTAKE_BUTTON).whileHeld(m_outtakeCommand);
    new JoystickButton(m_operatorController, Constants.SHOOT_BUTTON).whileHeld(m_autoShootCommand);
    new JoystickButton(m_operatorController, Constants.SHOOTER_SPINUP_BUTTON).whileHeld(m_shooterSpinUpCommand);

    new JoystickButton(m_driverController, Constants.CLIMBUP_BUTTON).whileHeld(m_climbUpCommand);
    new JoystickButton(m_driverController, Constants.CLIMBDOWN_BUTTON).whileHeld(m_climbDownCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    Command m_autoCommand = m_autonOneBall;
    String m_autoSelected = SmartDashboard.getString("Auto Selector", autoList[0]);
    
    if (m_autoSelected.equals(autoList[0])) {
      m_autoCommand = m_autonOneBall;
    } else if (m_autoSelected.equals(autoList[1])) {
      m_autoCommand = m_autonTwoBall;
    }

    return m_autoCommand;
  }
}
