package com.srkapi.base.shared;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class DateUtils {
  public static String dateToString(LocalDateTime dateTime) {
    return dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
  }

  public String dateToString(Timestamp timestamp) {
    return dateToString(timestamp.toLocalDateTime());
  }
}
