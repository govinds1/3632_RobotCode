// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DrivetrainControlCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DrivetrainSubsystem m_drivetrain;
  private final Joystick m_joystick;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DrivetrainControlCommand(DrivetrainSubsystem drivetrain, Joystick joystick) {
    m_drivetrain = drivetrain;
    m_joystick = joystick;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double forward = -m_joystick.getRawAxis(Constants.DRIVE_FORWARD_AXIS);
    double turn = m_joystick.getRawAxis(Constants.DRIVE_TURN_AXIS);
    // double leftPower = -m_joystick.getRawAxis(Constants.DRIVE_LEFT_AXIS);
    // double rightPower = -m_joystick.getRawAxis(Constants.DRIVE_RIGHT_AXIS);

    double powerMult = 0.5;
    if (m_joystick.getRawButton(Constants.DRIVE_BOOST_BUTTON)) {
      powerMult = 0.8;
    }

    m_drivetrain.arcadeDrive(forward * powerMult, turn * powerMult);
    // m_drivetrain.tankDrive(leftPower * powerMult, rightPower * powerMult);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
