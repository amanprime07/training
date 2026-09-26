package com.training.heap;

import java.util.*;

/*
*
* 621. Task Scheduler
You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.
Return the minimum number of CPU intervals required to complete all tasks.
Example 1:
    Input: tasks = ['A','A','A','B','B','B'], n = 2
    Output: 8
    Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
    After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.

Example 2:
    Input: tasks = ['A','C','A','B','D','B'], n = 1
    Output: 6
    Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.
    With a cooling interval of 1, you can repeat a task after just one other task.
Example 3:
    Input: tasks = ['A','A','A', 'B','B','B'], n = 3
    Output: 10
    Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.
    There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.
* */
public class TaskScheduler {

    public static void main(String[] args) {
        char[] arr = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(leastInterval(arr, n));
        System.out.println(leastInterval(arr, 3));
        arr = new char[]{'A','C','A','B','D','B'};
        n =1;
        System.out.println(leastInterval(arr, n));
    }

    private static int leastInterval(char[] tasks, int n) {
        int times = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            int f = map.getOrDefault(task, 0);
            map.put(task, f + 1);
        }
        Queue<TaskFrequency> q = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            q.offer(new TaskFrequency(e.getKey(), e.getValue()));
        }

        while (!q.isEmpty()) {
            List<TaskFrequency> list = new ArrayList<>();
            int cycle = n + 1;
            int taskCount = 0;
            while (cycle > 0 && !q.isEmpty()) {
                TaskFrequency tf = q.poll();
                tf.freq--;
                if (tf.freq > 0) {
                    list.add(tf);
                }
                taskCount++;
                cycle--;
            }
            if (list.isEmpty()) {
                times += taskCount;
            } else {
                times += n + 1;
            }
            q.addAll(list);

        }

        return times;
    }

    private static class TaskFrequency {
        char task;
        int freq;

        TaskFrequency(char t, int f) {
            task = t;
            freq = f;
        }
    }
}
