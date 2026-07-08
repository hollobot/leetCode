package com.example.面试.面试01;

import java.util.*;

public class demo4 {
    public static void main(String[] args) {
        demo4 demo4 = new demo4();
        String msg =
            "1001,hello world,1700000000000,INFO\n" + "1002,error occurred,1700000005000,ERROR\n" + "1001,second msg," + "1700000010000,INFO\n" + "1003,test data,1700000020000,INFO";
        String[] split = msg.split("\n");
        List<String> list = Arrays.asList(split);

        List<Message> parse = demo4.parse(list);
        List<Message> filterError = demo4.filterError(parse);
        Map<String, Integer> stringIntegerMap = demo4.countByUser(filterError);
        List<Message> messages = demo4.queryByTime(filterError, 1700000000000l, 1700000020000l);
        List<Message> messages1 = demo4.sortByTime(filterError);
        System.out.println(messages1);
    }

    // 解析"1001,hello world,1700000000000,INFO"
    List<Message> parse(List<String> lines) {
        List<Message> result = new ArrayList();
        for (String line : lines) {
            String[] split = line.trim().split(",");
            String userId = split[0];
            String message = split[1];
            Long time = Long.parseLong(split[2]);
            String type = split[3];
            result.add(new Message(userId, message, time, type));
        }
        return result;
    }

    // 过滤type为ERROR的消息
    List<Message> filterError(List<Message> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            Message message = list.get(i);
            if (message.getType().equals("ERROR")) {
                list.remove(message);
            }
        }
        return list;
    }

    // 统计每个 userId 的消息数量
    Map<String, Integer> countByUser(List<Message> list) {
        Map<String, Integer> result = new HashMap();
        for (Message message : list) {
            String id = message.getUserId();
            result.put(id, result.getOrDefault(id, 0) + 1);
        }
        return result;
    }

    // 查找时间范围内的数据（左闭右开）
    List<Message> queryByTime(List<Message> list, long start, long end) {
        Iterator<Message> iterator = list.iterator();
        while (iterator.hasNext()) {
            Message message = iterator.next();
            if (message.time >= start && message.time < end) {
                continue;
            }
            iterator.remove();
        }
        return list;
    }

    // 按照createTime升序排序（如果时间相同按照ID排序）
    List<Message> sortByTime(List<Message> list) {
        Collections.sort(list, new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                int result = Long.compare(o1.getTime(), o2.getTime());
                if (result == 0) {
                    result = Integer.compare(Integer.parseInt(o1.getUserId()), Integer.parseInt(o2.getUserId()));
                }
                return result;
            }
        });
        return list;
    }

    class Message {

        private String userId;
        private String message;
        private Long time;
        private String type;

        public Message(String userId, String message, Long time, String type) {
            this.userId = userId;
            this.message = message;
            this.time = time;
            this.type = type;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Long getTime() {
            return time;
        }

        public void setTime(Long time) {
            this.time = time;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Message{" + "userId='" + userId + '\'' + ", message='" + message + '\'' + ", time=" + time + ", type='" + type + '\'' + '}';
        }
    }
}
