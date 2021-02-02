package pl.pjatk.store.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.store.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private ArticleService articleService;
}
