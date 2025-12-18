package shiqu.data;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        runCase("同一天上班时间内",
                "2025-09-15 10:00:01",
                "2025-09-22 10:00:01",
                20 * 60);
    }


    /**
     * 辅助方法：运行测试用例
     */
    private static void runCase(String title, String userTimeStr, String teacherTimeStr, long expectedSeconds) {
        Timestamp userMsg = Timestamp.valueOf(userTimeStr);
        Timestamp teacherReply = Timestamp.valueOf(teacherTimeStr);

        // 转换 Timestamp -> LocalDateTime
        LocalDateTime userDateTime = userMsg.toLocalDateTime();
        LocalDateTime teacherDateTime = teacherReply.toLocalDateTime();

        long seconds = calculateReplyTimeSeconds(
                userDateTime,
                teacherDateTime,
                LocalTime.of(9, 00),   // 上班 09:00
                LocalTime.of(22, 00),  // 下班 22:00
                LocalTime.of(12, 00),  // 午休 12:00
                LocalTime.of(14, 00),  // 午休结束 14:00
                DayOfWeek.SUNDAY      // 周日休息
        );

        System.out.printf("【%s】\n用户: %s, 老师: %s\n→ 计算结果: %d 秒 (%.2f 分钟)，期望: %d 秒\n\n",
                title, userTimeStr, teacherTimeStr,
                seconds, (double) seconds / 60.0, expectedSeconds);
    }

    /**
     * 计算回复时间（秒）
     *
     * @param userTime      用户消息时间（Timestamp）
     * @param teacherTime   老师回复时间（Timestamp）
     * @param workStart     工作开始时间（LocalTime，如 09:00）
     * @param workEnd       工作结束时间（LocalTime，如 22:00）
     * @param lunchStart    午休开始时间（LocalTime，如 12:00）
     * @param lunchEnd      午休结束时间（LocalTime，如 14:00）
     * @param restDay       休息日（如 DayOfWeek.SUNDAY）
     * @return 有效回复间隔（秒）
     */
    public static long calculateReplyTimeSeconds(LocalDateTime userTime, LocalDateTime teacherTime, LocalTime workStart,
                                                 LocalTime workEnd, LocalTime lunchStart, LocalTime lunchEnd, DayOfWeek restDay) {
        // 如果老师回复早于用户消息，不合理，直接返回0
        if (!teacherTime.isAfter(userTime)) {
            return 0L;
        }

        long totalSeconds = 0L;

        LocalDateTime current = userTime;

        while (current.isBefore(teacherTime)) {
            // 如果是休息日，跳到下一个工作日的上班时间
            if (current.getDayOfWeek() == restDay) {
                current = LocalDateTime.of(current.toLocalDate().plusDays(1), workStart);
                continue;
            }

            LocalTime nowTime = current.toLocalTime();

            // 如果当前时间在下班后 -> 跳到下一天上班时间
            if (!nowTime.isBefore(workEnd)) {
                current = LocalDateTime.of(current.toLocalDate().plusDays(1), workStart);
                continue;
            }

            // 如果当前时间在上班前 -> 跳到上班时间
            if (nowTime.isBefore(workStart)) {
                current = LocalDateTime.of(current.toLocalDate(), workStart);
                continue;
            }

            // 如果当前时间在午休时间内 -> 跳到午休结束
            if (!nowTime.isBefore(lunchStart) && nowTime.isBefore(lunchEnd)) {
                current = LocalDateTime.of(current.toLocalDate(), lunchEnd);
                continue;
            }

            // 计算下一个可能的临界点（午休开始、下班时间、老师回复时间）
            LocalDateTime nextLimit = teacherTime;

            // 午休开始时间
            LocalDateTime todayLunchStart = LocalDateTime.of(current.toLocalDate(), lunchStart);

            // 下班开始时间
            LocalDateTime todayWorkEnd = LocalDateTime.of(current.toLocalDate(), workEnd);

            // 处理中间休息时间
            if (current.isBefore(todayLunchStart) && teacherTime.isAfter(todayLunchStart)) {
                // 中间间隔午休时间
                nextLimit = todayLunchStart;
            }else if(current.isBefore(todayWorkEnd) && teacherTime.isAfter(todayWorkEnd)) {
                // 中间间隔下班时间
                nextLimit = todayWorkEnd;
            }


            // 取当前时间和临界点的最小值
            LocalDateTime stepEnd = nextLimit.isBefore(teacherTime) ? nextLimit : teacherTime;

            // 累加有效时长（用户消息时间->午休时间or下班时间or老师回复消息时间）
            totalSeconds += Duration.between(current, stepEnd).getSeconds();

            // 移动 current （用户发的消息->午休开始、下班时间、老师回复消息时间）
            current = stepEnd;
        }

        return totalSeconds;
    }

}


