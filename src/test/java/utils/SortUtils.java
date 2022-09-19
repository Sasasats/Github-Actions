package utils;

import api.models.Post;

import java.util.List;
import java.util.stream.Collectors;

public class SortUtils {
    public static Boolean isPostsSorted(List<Post> posts) {
        List<Integer> ids = posts.stream().map(Post::getId).collect(Collectors.toList());
        List<Integer> sortedIds = ids.stream().sorted().collect(Collectors.toList());
        return ids.equals(sortedIds);
    }
}
