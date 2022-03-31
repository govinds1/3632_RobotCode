// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Mapping

    // motor channels/IDs
    public static final int LEFT_FRONT_MOTOR = 0;
    public static final int LEFT_REAR_MOTOR = 1;
    public static final int RIGHT_FRONT_MOTOR = 2;
    public static final int RIGHT_REAR_MOTOR = 3;
    public static final int CLIMBER_MOTOR = 4;
    public static final int INTAKE_MOTOR = 5;
    public static final int SHOOTER1_MOTOR = 6;
    public static final int SHOOTER2_MOTOR = 7;

    // controller bindings
    public static final int INTAKE_BUTTON = 1;
    public static final int OUTTAKE_BUTTON = 2;
    public static final int SHOOT_BUTTON = 3;
    public static final int SHOOTER_SPINUP_BUTTON = 4;
    public static final int DRIVE_FORWARD_AXIS = 1;
    public static final int DRIVE_TURN_AXIS = 4;
    public static final int DRIVE_LEFT_AXIS = 1;
    public static final int DRIVE_RIGHT_AXIS = 5;
    public static final int DRIVE_BOOST_AXIS = 3;
    public static final int CLIMBDOWN_BUTTON = 5;
    public static final int CLIMBUP_BUTTON = 6;
    public static final int DRIVER_CONTROLLER = 0;
    public static final int OPERATOR_CONTROLLER = 0;



    // Calibrations
    public static final double INTAKE_POWER = 1;
    public static final double OUTTAKE_POWER = -1;
    public static final double CLIMBUP_POWER = 0.5;
    public static final double CLIMBDOWN_POWER = -0.5;
    public static final double SHOOT_POWER = 1;
    public static final double SHOOT_RPM = 4000;
    public static final double SHOOT_SPIN_UP_TIME = 2.0;
    public static final double AUTON_DRIVE_POWER = 0.4;
    public static final double AUTON_TURN_POWER = 0.4;
    public static final double AUTON_TURN90_TIME = 1.2;

}
