//package us.challenge.core.utils;
//
//import org.apache.log4j.Logger;
//
///**
// * Time utils class.
// */
//public final class TimeUtils {
//
//    private static final Logger LOGGER = Logger.getLogger(TimeUtils.class.getName());
//
//    /**
//     * Constructor to prevent instantiation.
//     */
//    private TimeUtils() {
//    }
//
//    /**
//     * This method sleep the tread for a period of time.
//     *
//     * @param millis to sleep.
//     */
//    public static void waitFixedTime(final int millis) {
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException ex) {
//            LOGGER.info(ex.getMessage());
//        }
//    }
//}
