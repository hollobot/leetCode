package com.example.queue;

import org.junit.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MyPriorityQueue {


    private static PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

    public static void main(String[] args) {
        queue = new PriorityQueue<Integer>((a,b)->b-a);
        queue.offer(1);
        queue.offer(2);
        offers(queue);

    }

    public static void offers(PriorityQueue queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }


    class TeacherOperationsDataVo {
        private Long groupId;
        private LocalDate startTime;

        public Long getGroupId() {
            return groupId;
        }

        public void setGroupId(Long groupId) {
            this.groupId = groupId;
        }

        public LocalDate getStartTime() {
            return startTime;
        }

        public void setStartTime(LocalDate startTime) {
            this.startTime = startTime;
        }
    }

    private TeacherOperationsDataVo createVo(Long groupId, LocalDate startTime) {
        TeacherOperationsDataVo vo = new TeacherOperationsDataVo();
        vo.setGroupId(groupId);
        vo.setStartTime(startTime);
        return vo;
    }

    private void printList(List<TeacherOperationsDataVo> list, Set<Long> groupIdSet) {
        list.forEach(dto -> {
            boolean isTop = groupIdSet.contains(dto.getGroupId());
            System.out.println(String.format("StartTime: %s, GroupId: %d, 是否置顶: %s %s",
                dto.getStartTime(),
                dto.getGroupId(),
                isTop,
                isTop ? "★" : ""));
        });
    }

    @Test
    public void testSortByStartTimeWithGroupIdSetOnTop() {
        // 准备测试数据
        List<TeacherOperationsDataVo> collect = new ArrayList<>();

        // 2024-01-01 批次
        collect.add(createVo(1L, LocalDate.of(2024, 1, 1)));
        collect.add(createVo(5L, LocalDate.of(2024, 1, 1)));  // 需要置顶
        collect.add(createVo(3L, LocalDate.of(2024, 1, 1)));

        // 2024-01-02 批次
        collect.add(createVo(2L, LocalDate.of(2024, 1, 2)));
        collect.add(createVo(7L, LocalDate.of(2024, 1, 2)));  // 需要置顶
        collect.add(createVo(4L, LocalDate.of(2024, 1, 2)));

        // 2024-01-03 批次
        collect.add(createVo(6L, LocalDate.of(2024, 1, 3)));
        collect.add(createVo(9L, LocalDate.of(2024, 1, 3)));  // 需要置顶
        collect.add(createVo(8L, LocalDate.of(2024, 1, 3)));

        // 需要置顶的 groupId 集合
        Set<Long> groupIdSet = new HashSet<>(Arrays.asList(5L, 7L, 9L));

        System.out.println("=== 排序前 ===");
        printList(collect, groupIdSet);

        // 执行排序
        List<TeacherOperationsDataVo> startIntoDateOperations = collect.stream()
            .sorted((dto1, dto2) -> {
                // 首先按 startTime 排序
                int timeCompare = dto1.getStartTime().compareTo(dto2.getStartTime());
                if (timeCompare != 0) {
                    return timeCompare;
                }

                // 在同一个 startTime 批次内，groupIdSet 中的记录置顶
                boolean isDto1Top = groupIdSet.contains(dto1.getGroupId());
                boolean isDto2Top = groupIdSet.contains(dto2.getGroupId());

                if (isDto1Top && !isDto2Top) {
                    return -1;
                } else if (!isDto1Top && isDto2Top) {
                    return 1;
                } else {
                    return 0;
                }
            })
            .collect(Collectors.toList());

        System.out.println("\n=== 排序后 ===");
        printList(startIntoDateOperations, groupIdSet);

    }


}
