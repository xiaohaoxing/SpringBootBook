package Star.CS.whu.SpringBootBook.repository.es;


import Star.CS.whu.SpringBootBook.domain.es.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {
    @Autowired
    private EsBlogRepostory repo;

    @Before
    public void initRepositoryData() {
        // 清除所有数据
        repo.deleteAll();

        // 初始化数据
        repo.save(new EsBlog("Had I not seen the sun",
                "I could have borne the shade",
                "But Light a newer Wilderness. My Wilderness has made."));
        repo.save(new EsBlog("There is room in the halls of pleasure",
                "For a long and lordly train",
                "But one by one we must all file on, Through the narrow aisles of pain."));
        repo.save(new EsBlog("When you are old",
                "When you are old and grey and full of sleep",
                "And nodding by the fire, take down this book."));
    }

    @Test
    public void testFindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining() {
        Pageable pageable = PageRequest.of(0, 20);
        String title = "sun";
        String summary = "is";
        String content = "down";

        Page<EsBlog> page = repo.findByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);

        System.out.println("============ start 1");
        for (EsBlog blog : page) {
            System.out.println(blog);
        }
        System.out.println("============ end   1");


        title = "sun";
        summary = "is";
        content = "down";

        page = repo.findByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);

        System.out.println("============ start 2");
        for (EsBlog blog : page) {
            System.out.println(blog);
        }
        System.out.println("============ end   2");


    }
}
