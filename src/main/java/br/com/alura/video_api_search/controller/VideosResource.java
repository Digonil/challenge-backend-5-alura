package br.com.alura.video_api_search.controller;

import br.com.alura.video_api_search.model.Videos;
import br.com.alura.video_api_search.repository.VideosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("videos")
public class VideosResource {

    @Autowired
    private VideosRepository videosRepository;

    @GetMapping
    public List<Videos> buscarVideo() {
        return videosRepository.findAll();
    }

    @GetMapping("{id}")
    public Videos buscarVideoPorId(@PathVariable Integer id) {
        return videosRepository.findById(id).get();

    }

    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @PostMapping
    public Videos adicionarVideo(@RequestBody Videos video) {
        return videosRepository.save(video);
    }

    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @PutMapping("{id}")
    public Videos atualizarVideo(@RequestBody Videos video, @PathVariable Integer id) {
        video.setId(id);
        return videosRepository.save(video);
    }

    @DeleteMapping("{id}")
    public void deletarVideo(@PathVariable Integer id) {
        videosRepository.deleteById(id);
    }

}



