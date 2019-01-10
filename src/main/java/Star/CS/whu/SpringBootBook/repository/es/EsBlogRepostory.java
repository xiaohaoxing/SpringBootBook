package Star.CS.whu.SpringBootBook.repository.es;

import Star.CS.whu.SpringBootBook.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsBlogRepostory extends ElasticsearchRepository<EsBlog, String> {
    Page<EsBlog> findByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);
}
