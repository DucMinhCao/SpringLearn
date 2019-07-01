package com.springlearn.topics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
    private static List<Topic> list = new ArrayList<Topic>();

    static {
        list.add(new Topic("Java", "CTT001", "Introduction To Programming"));
        list.add(new Topic("C++", "CTT002", "Programming Technique"));
        list.add(new Topic("C#", "CTT003", "Windows Programming"));
        list.add(new Topic(".NET", "CTT004", "Microsoft Framework"));
        list.add(new Topic("Java Spring", "CTT005", "Oracle"));
        list.add(new Topic("MySQL", "CTT006", "Introduction To Database"));
        list.add(new Topic("SQL-Server", "CTT007", "Information System"));
        list.add(new Topic("HTML", "CTT008", "Web Programming"));
    }

    public List<Topic> getList() {
        return list;
    }

    public void setList(List<Topic> list) {
        TopicService.list = list;
    }

    public Topic getTopic(String id) {
        Topic result = new Topic();
        for (Topic tempTopic : list) {
            if (tempTopic.getId().equals(id)) {
                result = tempTopic;
            }
        }
        return result;
    }

    public void add(Topic topictoadd) {
        // TODO Auto-generated method stub
        list.add(topictoadd);
    }

    public void delete(String id) {
        for (Topic tempTopic : list) {
            if (tempTopic.getId().equals(id)) {
                list.remove(tempTopic);
            }
        }
    }

    public void update(Topic topic, String id) {
        for (Topic tempTopic : list) {
            if (tempTopic.getId().equals(id)) {
                tempTopic = topic;
                return;
            }
        }
    }
}
