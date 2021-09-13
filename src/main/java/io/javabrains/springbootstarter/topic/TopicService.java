package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("Sprin", "Spring framework", "Spring framework description"),
					new Topic("Java", "Core Java", "Java description"), new Topic("PY", " Python", "Py description"),
					new Topic("JS", " JavaScript", "JS description")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {

		topics.add(topic);
	}

	public void updateTopic(Topic topic, String id) {

		for (int i = 0; i < topics.size(); i++) {
			Topic top = topics.get(i);
			if (top.getId().equals(id)) {
				topics.set(i, topic);
			}
		}

	}

	public void deleteTopic(String id) {

		/*
		 * for (int i = 0; i < topics.size(); i++) { Topic top = topics.get(i); if
		 * (top.getId().equals(id)) { topics.remove(i); } }
		 */

		topics.removeIf(t -> t.getId().equals(id));
	}

}
