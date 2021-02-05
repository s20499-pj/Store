package pl.pjatk.store.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.store.exception.ArticleException;
import pl.pjatk.store.model.Article;
import pl.pjatk.store.repository.ArticleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ArticleServiceTest {

    @Mock
    private ArticleRepository articleRepository;
    Article article = new Article("nożyczki", 10, 1);
    Article article1 = new Article("patelnia", 30, 2);
    List<Article> list = new ArrayList<>();

    @InjectMocks
    private ArticleService articleService;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all test do nothing");
    }

    @BeforeEach
    public void beforeEach() {
    }

    @AfterEach
    public void afterEach() {
    }

    @Test
    public void shouldAddNew() throws ArticleException {
        //Given
        when(articleRepository.save(article)).thenReturn(article);
        //When
        Article savedArticle = articleService.addNew(article);
        //Then
        assertThat(savedArticle).isEqualTo(article);
    }

    @Test
    public void shouldFindById() throws ArticleException {
        //Given
        when(articleRepository.findById(1)).thenReturn(Optional.of(article));
        //When
        Optional<Article> article1 = articleService.findById(1);
        //Given
        assertThat(article1).isEqualTo(Optional.of(article));
    }

    @Test
    public void shouldUpdateById() throws ArticleException {
        //Given
        when(articleRepository.findById(1)).thenReturn(Optional.of(article));
        //When
        Optional<Article> test = articleService.updateById(1, "nożyki", 30, 20);
        //Then
        assertThat(test).isNotEmpty();
    }

    @Test
    public void shouldFindAll(){
        //Given
        list.add(article);
        list.add(article1);
        when(articleRepository.findAll()).thenReturn(list);
        //When
        List<Article> test = articleService.findAll();
        //Then
        assertThat(test).isEqualTo(list);
    }

    @Test
    public void shouldDeleteById() throws ArticleException {
        //Given
        articleService.addNew(article);
        //When
        articleService.deleteByID(article.getId());
        articleService.deleteByID(article.getId());
        //Then
        verify(articleRepository, times(2)).deleteById(article.getId());
    }

    @Test
    public void shouldUpdateByName() throws ArticleException {
        //Given
        list.add(article);
        list.add(article1);
        when(articleRepository.findAll()).thenReturn(list);
        //When
        List<Article> test = articleService.updateByName("nożyczki", "nożyki", 30, 20);
        //Then
        //System.out.println(test.stream().findFirst().get().getName());
        assertThat(test.stream().findFirst().get()).isEqualTo(article);
    }


}
