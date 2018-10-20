package pl.bkalemba.lametwit.beans;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.bkalemba.lametwit.model.Tweet;
import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    @Query("SELECT t FROM Tweet t ORDER BY t.id DESC")
    List<Tweet> loadAllDesc();
}
