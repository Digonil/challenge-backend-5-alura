package br.com.alura.video_api_search.repository;

import br.com.alura.video_api_search.model.Videos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideosRepository extends JpaRepository<Videos, Integer> {
}
