package ca.fxco.moreculling.utils;

import net.minecraft.world.phys.Vec3;

public class MathUtils {

    public static final double ONE_SIGN_ROTATION = 0.3926991D; // 22.5 degrees
    public static final double PI2 = Math.PI * 2; // 360 degrees

    // Angle in Radians
    public static boolean isBehindLine(double angle, Vec3 linePos, Vec3 pos) {
        double rad = Math.atan2(pos.z() - linePos.z(), pos.x() - linePos.x());
        rad += Math.ceil(-rad / PI2) * PI2;
        return rad - angle > Math.PI; // Simplified so it's faster for this use case
    }

    // In Radians
    public static boolean isAngleBetween(double angle, double start, double end) {
        end -= start;
        angle -= start;
        return (angle + PI2) % PI2 > (end + PI2) % PI2;
    }

    public static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }

    public static float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(max, value));
    }
}
