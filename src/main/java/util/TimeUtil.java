package util;


import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    private static final String YYYY_MM_DD_HH_MM_SS = "yyyy/MM/dd HH:mm:ss";
    private static final String TAIPEI_ZONEID = "Asia/Taipei";

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter
            .ofPattern(YYYY_MM_DD_HH_MM_SS)
            .withZone(ZoneId.of(TAIPEI_ZONEID));

    /**
     * 依要求轉為(yyyy/MM/dd HH:mm:ss，台北時間)
     * @param time ISO時間
     * @return 台北時間
     */
    public static String transLocaleTime(String time) {
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(time);
        Instant instant = offsetDateTime.toInstant();
        return dateTimeFormatter.format(instant);
    }
}
