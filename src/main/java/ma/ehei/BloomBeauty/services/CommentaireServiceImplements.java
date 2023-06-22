package ma.ehei.BloomBeauty.services;

import lombok.AllArgsConstructor;
import ma.ehei.BloomBeauty.entity.Commentaire;
import ma.ehei.BloomBeauty.repository.CommandeRepository;
import ma.ehei.BloomBeauty.repository.CommentaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class CommentaireServiceImplements implements CommentaireServices{

   public final CommentaireRepository commentaireRepository;
    @Override
    public Commentaire create(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @Override
    public List<Commentaire> read() {
        return commentaireRepository.findAll();
    }

    @Override
    public Commentaire update(Long id, Commentaire commentaire) {

       return commentaireRepository.findById(id)
                .map(clt->{
                    clt.setCommentaire(commentaire.getCommentaire());
                    clt.setEtoile(commentaire.getEtoile());
                    clt.setDate(commentaire.getDate());
                    clt.setEtat(commentaire.getEtat());
                    return commentaire;
                }).orElseThrow(() -> new RuntimeException("Commentaire introuvable"));


    }

    @Override
    public String delete(Long id) {
        commentaireRepository.deleteById(id);
        return "bien supprimer";
    }
}
