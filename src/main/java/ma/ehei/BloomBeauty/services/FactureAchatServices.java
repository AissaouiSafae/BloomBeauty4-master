package ma.ehei.BloomBeauty.services;


import ma.ehei.BloomBeauty.entity.FactureAchat;

import java.util.List;

public interface FactureAchatServices {
    FactureAchat create ( FactureAchat factureAchat);
    List< FactureAchat> read();
    FactureAchat update (Long id,  FactureAchat  factureAchat);
    String delete(Long id);
}
