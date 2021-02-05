package pl.pjatk.store.service;

import org.springframework.stereotype.Service;
import pl.pjatk.store.exception.PalletException;
import pl.pjatk.store.model.Article;
import pl.pjatk.store.model.Pallet;
import pl.pjatk.store.repository.ArticleRepository;
import pl.pjatk.store.repository.PalletRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Optional.ofNullable;

@Service
public class PalletService {

    private final PalletRepository palletRepository;
    private final ArticleRepository articleRepository;

    public PalletService(PalletRepository palletRepository, ArticleRepository articleRepository) {
        this.palletRepository = palletRepository;
        this.articleRepository = articleRepository;
    }

    public Optional<Pallet> findById(int id) {
        return palletRepository.findById(id);
    }

    public List<Pallet> findAll() {
        return palletRepository.findAll();
    }

    public Pallet addNew(Pallet pallet) {
        return palletRepository.save(pallet);
    }

    public void deleteByID(int id) {
        palletRepository.deleteById(id);
    }

    public Set<Article> findAllArticlesInId(int id){
        return palletRepository.findById(id).get().getArticles();
    }

    public void addArticleToPallet(int idArticle, int idPallet) throws PalletException {
        Optional<Article> article = articleRepository.findById(idArticle);
        Optional<Pallet> pallet = palletRepository.findById(idPallet);
        if (pallet.isPresent() && article.isPresent()) {
            pallet.get().addArticle(article.get());
        } else throw new PalletException("Brak artykułu lub palety");
    }

    public void removeArticleFromPallet(int idArticle, int idPallet) throws PalletException {
        Optional<Article> article = articleRepository.findById(idArticle);
        Optional<Pallet> pallet = palletRepository.findById(idPallet);
        if (article.isPresent() && pallet.isPresent()) {
            pallet.get().removeArticle(article.orElse(null));
        }else throw new PalletException("Brak artykułu lub palety");
    }
}
